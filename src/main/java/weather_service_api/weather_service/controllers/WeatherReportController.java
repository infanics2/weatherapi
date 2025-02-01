package weather_service_api.weather_service.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weather_service_api.weather_service.dtos.WeatherReportDto;
import weather_service_api.weather_service.services.WeatherReportService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class WeatherReportController {
    private final WeatherReportService weatherReportService;

    @GetMapping("/weather-report")
    public WeatherReportDto getWeatherReport(@RequestBody String q) throws Exception {
        return weatherReportService.getWeatherReport(q);
    }
}
