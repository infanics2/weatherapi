package weather_service_api.weather_service.dtos.weatherapiDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {
    @JsonProperty("last_updated_epoch")
    private long lastUpdatedEpoch;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("temp_c")
    private double temperatureCelsius;

    @JsonProperty("temp_f")
    private double temperatureFahrenheit;

    @JsonProperty("is_day")
    private int isDay;

    @JsonProperty("condition")
    private ConditionDto condition;

    @JsonProperty("wind_mph")
    private double windMph;

    @JsonProperty("wind_kph")
    private double windKph;

    @JsonProperty("wind_degree")
    private int windDegree;

    @JsonProperty("wind_dir")
    private String windDirection;

    @JsonProperty("pressure_mb")
    private double pressureMb;

    @JsonProperty("pressure_in")
    private double pressureIn;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("cloud")
    private int cloud;

    @JsonProperty("feelslike_c")
    private double feelsLikeCelsius;

    @JsonProperty("feelslike_f")
    private double feelsLikeFahrenheit;

    @JsonProperty("vis_km")
    private double visibilityKm;

    @JsonProperty("vis_miles")
    private double visibilityMiles;

    @JsonProperty("uv")
    private double uvIndex;

    @JsonProperty("gust_mph")
    private double gustMph;

    @JsonProperty("gust_kph")
    private double gustKph;
}
