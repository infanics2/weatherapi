package weather_service_api.weather_service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import weather_service_api.weather_service.dtos.WeatherReportDto;
import weather_service_api.weather_service.dtos.weatherapiDTOs.WeatherApiResponseDto;
import weather_service_api.weather_service.repositories.CityRepository;
import weather_service_api.weather_service.repositories.WeatherRepository;
import weather_service_api.weather_service.services.helperservices.CloudColorService;
import weather_service_api.weather_service.services.helperservices.ColorService;
import weather_service_api.weather_service.services.helperservices.TemperatureColorService;
import weather_service_api.weather_service.services.helperservices.WindColorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WeatherReportService {
    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository;
    private final String apiUrl;
    private final String apiKey;
    private final RestTemplate restTemplate;
    private final CloudColorService cloudColorService;
    private final TemperatureColorService temperatureColorService;
    private final WindColorService windColorService;

    @Autowired
    public WeatherReportService(
            WeatherRepository weatherRepository,
            CityRepository cityRepository,
            RestTemplate restTemplate,
            @Value("${spring.properties.weather-api-url}") String apiUrl,
            @Value("${spring.properties.api-key}") String apiKey,
            CloudColorService cloudColorService,
            WindColorService windColorService,
            TemperatureColorService temperatureColorService) {
        this.weatherRepository = weatherRepository;
        this.cityRepository = cityRepository;
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.cloudColorService = cloudColorService;
        this.windColorService = windColorService;
        this.temperatureColorService = temperatureColorService;
    }

    public WeatherReportDto getWeatherReport(String cityName) throws Exception {
        Map<String, String> uriVariables = Map.of(
                "q", cityName,
                "key", apiKey
        );
        ResponseEntity<WeatherApiResponseDto> response = restTemplate.getForEntity(apiUrl, WeatherApiResponseDto.class, uriVariables);
        return toWeatherReportDto(response);
    }

    private WeatherReportDto toWeatherReportDto(ResponseEntity<WeatherApiResponseDto> dto) {
        String cloudColor = cloudColorService.getColor(dto.getBody().getWeather().getCloud());
        String windColor = windColorService.getColor(dto.getBody().getWeather().getWindKph());
        String temperatureColor = temperatureColorService.getColor(dto.getBody().getWeather().getTemperatureCelsius());

        WeatherReportDto report = new WeatherReportDto();
        report.setName(dto.getBody().getCity().getName());
        report.setCountry(dto.getBody().getCity().getCountry());
        report.setLatitude(dto.getBody().getCity().getLat());
        report.setLongitude(dto.getBody().getCity().getLon());
        report.setTempC(dto.getBody().getWeather().getTemperatureCelsius());
        report.setTempColor(temperatureColor);
        report.setWindKph(dto.getBody().getWeather().getWindKph());
        report.setWindColor(windColor);
        report.setCloud(dto.getBody().getWeather().getCloud());
        report.setCloudColor(cloudColor);
        return report;
    }
}
