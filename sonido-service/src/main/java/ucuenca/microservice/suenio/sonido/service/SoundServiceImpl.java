package ucuenca.microservice.suenio.sonido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ucuenca.microservice.suenio.sonido.entity.SoundEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SoundServiceImpl implements SoundService {

    private final MongoOperations mongoOperations;

    @Autowired()
    @Qualifier(value = "mongoTemplate")
    MongoTemplate mongoTemplate;

    public SoundServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<SoundEntity> findListSound(String ini, String fin) {
        Query query = new Query();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(ini, format);
        LocalDateTime end = LocalDateTime.parse(fin, format);
        query.addCriteria(Criteria.where("fecha").gt(start).lt(end));
        List <SoundEntity> tempDB = this.mongoOperations.find(query,SoundEntity.class);
        return tempDB;
    }

    @Override
    public List<SoundEntity> findByIdUser(String id_usuario) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("id_usuario").is("0105737381"));
        List<SoundEntity> users = mongoTemplate.find(query1, SoundEntity.class);
        return users;
    }
}
