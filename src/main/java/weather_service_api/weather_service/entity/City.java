package weather_service_api.weather_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 128)
    private String name;

    @NotNull
    @Size(max = 128)
    private String country;

    @Column(name = "lat", nullable = false)
    private Double latitude;

    @Column(name = "lon", nullable = false)
    private Double longitude;

    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Weather weather;
}
