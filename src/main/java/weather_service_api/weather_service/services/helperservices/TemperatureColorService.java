package weather_service_api.weather_service.services.helperservices;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class TemperatureColorService extends ColorService {
    private final List<RangeTemplate> range = Arrays.asList(
        new RangeTemplate(-100, -30, "#003366"),
        new RangeTemplate(-29, -20, "#4A90E2"),
        new RangeTemplate(-19, -10, "#B3DFFD"),
        new RangeTemplate(-9, 0, "#E6F7FF"),
        new RangeTemplate(1, 10, "#D1F2D3"),
        new RangeTemplate(11, 20, "#FFFACD"),
        new RangeTemplate(21, 30, "#FFCC80"),
        new RangeTemplate(31, 40, "#FF7043"),
        new RangeTemplate(41, 70, "#D32F2F")
    );

    public String getColor(double temperature) {
        return this.findColor(temperature, range);
    }
}
