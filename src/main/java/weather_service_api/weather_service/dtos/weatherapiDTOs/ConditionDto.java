package weather_service_api.weather_service.dtos.weatherapiDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionDto {
    @JsonProperty("text")
    private String description;

    @JsonProperty("icon")
    private String iconUrl;

    @JsonProperty("code")
    private int code;
}
