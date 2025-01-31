package weather_service_api.weather_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weather_service_api.weather_service.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
