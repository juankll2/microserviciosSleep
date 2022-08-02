package ucuenca.microservice.suenio.sonido.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ucuenca.microservice.suenio.sonido.entity.SoundEntity;

public interface SoundRepository extends MongoRepository <SoundEntity, String> {
}
