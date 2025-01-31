package weather_service_api.weather_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userz")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 64)
    private String surname;

    @Column(nullable = false, length = 64, unique = true)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;
}
