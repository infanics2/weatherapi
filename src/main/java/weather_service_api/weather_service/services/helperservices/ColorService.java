package weather_service_api.weather_service.services.helperservices;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public abstract class ColorService {
    private final static String DEFAULT_COLOR = "#FFFFFF";

    protected String findColor(double wind, List<RangeTemplate> colorRange) {
        for (RangeTemplate range : colorRange) {
            if (wind >= range.getMin() && wind <= range.getMax()) {
                return range.getColor();
            }
        }
        return DEFAULT_COLOR;
    }
}
