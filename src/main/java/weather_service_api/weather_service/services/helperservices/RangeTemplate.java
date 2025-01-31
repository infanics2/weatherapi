package weather_service_api.weather_service.services.helperservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RangeTemplate {
    private int min;
    private int max;
    private String color;
}
