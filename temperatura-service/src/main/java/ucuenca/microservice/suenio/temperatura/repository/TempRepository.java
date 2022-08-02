package ucuenca.microservice.suenio.temperatura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ucuenca.microservice.suenio.temperatura.entity.TempEntity;

public interface TempRepository extends MongoRepository <TempEntity, String> {


}

