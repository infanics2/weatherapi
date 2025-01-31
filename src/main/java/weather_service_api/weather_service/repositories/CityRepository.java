package weather_service_api.weather_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weather_service_api.weather_service.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
