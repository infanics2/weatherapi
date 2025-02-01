package weather_service_api.weather_service.schedulers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import weather_service_api.weather_service.entity.City;
import weather_service_api.weather_service.repositories.CityRepository;
import weather_service_api.weather_service.repositories.WeatherRepository;
import weather_service_api.weather_service.services.WeatherReportService;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class WeatherReportScheduler {
    private final WeatherReportService weatherReportService;
    private final CityRepository cityRepository;
    private final WeatherRepository weatherRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void getWeatherReport() throws InterruptedException, Exception {
        List<City> cities = cityRepository.findAll();
        if (cities.isEmpty()) {
            log.info("No cities found");
            return;
        }

        for (City city : cities) {
            weatherReportService.createWeatherReport(city.getName());
            log.info("Weather report has been saved for " + city.getName());
        }
    }
}
