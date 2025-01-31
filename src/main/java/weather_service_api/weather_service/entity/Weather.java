package weather_service_api.weather_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temp_c")
    private double tempC;

    @Column(name = "temp_color")
    @Size(max = 128)
    private String tempColor;

    @Column(name = "wind_kph")
    private double windKph;

    @Column(name = "wind_color")
    @Size(max = 128)
    private String windColor;

    private int cloud;

    @Column(name = "cloud_color")
    @Size(max = 128)
    private String cloudColor;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
