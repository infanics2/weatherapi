package weather_service_api.weather_service.services.helperservices;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class WindColorService extends ColorService {
    private static final int MAX_SPEED = 1000;

    private final List<RangeTemplate> range = Arrays.asList(
        new RangeTemplate(0, 10, "#E0F7FA"),
        new RangeTemplate(11, 20, "#B2EBF2"),
        new RangeTemplate(21, 40, "#4DD0E1"),
        new RangeTemplate(41, 60, "#0288D1"),
        new RangeTemplate(60, MAX_SPEED, "#01579B")
    );

    public String getColor(double windSpeed) {
        return this.findColor(windSpeed, range);
    }
}
