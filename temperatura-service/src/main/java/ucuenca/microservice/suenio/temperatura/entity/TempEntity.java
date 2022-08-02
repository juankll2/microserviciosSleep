package ucuenca.microservice.suenio.temperatura.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "temperatura")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TempEntity {
    @Id
    private String id;
    private String id_usuario;
    private LocalDateTime fecha;
    private Double temperatura;

}
