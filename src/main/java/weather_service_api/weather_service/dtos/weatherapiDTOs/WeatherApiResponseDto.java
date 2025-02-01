package weather_service_api.weather_service.dtos.weatherapiDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class WeatherApiResponseDto {
    @JsonProperty("location")
    private CityDto city;

    @JsonProperty("current")
    private WeatherDto weather;
}
