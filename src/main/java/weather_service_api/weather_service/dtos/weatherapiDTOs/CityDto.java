package weather_service_api.weather_service.dtos.weatherapiDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto {
    private String name;
    private String country;
    private Double lat;
    private Double lon;
    private String tz_id;
    private long localtime_epoch;
    private String localtime;
}
