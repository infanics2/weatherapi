package weather_service_api.weather_service.services.helperservices;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class CloudColorService extends ColorService {
    private final List<RangeTemplate> range = Arrays.asList(
        new RangeTemplate(0, 10, "#FFF9C4"),
        new RangeTemplate(11, 30, "#FFF176"),
        new RangeTemplate(31, 60, "#E0E0E0"),
        new RangeTemplate(61, 90, "#9E9E9E"),
        new RangeTemplate(91, 100, "#616161")
    );

    public String getColor(double cloudCoverage) {
        return this.findColor(cloudCoverage, range);
    }
}
