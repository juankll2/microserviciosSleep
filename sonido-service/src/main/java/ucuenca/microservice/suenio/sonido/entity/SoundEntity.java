package ucuenca.microservice.suenio.sonido.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "sonido")
@Getter
@Setter
@NoArgsConstructor
public class SoundEntity {
    @Id
    private String id;
    private String id_usuario;
    private LocalDateTime fecha;
    private Boolean sonido;
}
