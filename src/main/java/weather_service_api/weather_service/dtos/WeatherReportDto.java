package weather_service_api.weather_service.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import weather_service_api.weather_service.entity.City;
import weather_service_api.weather_service.entity.Weather;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WeatherReportDto {
    private String name;
    private String country;
    private Double latitude;
    private Double longitude;
    private double tempC;
    private String tempColor;
    private double windKph;
    private String windColor;
    private int cloud;
    private String cloudColor;
}
