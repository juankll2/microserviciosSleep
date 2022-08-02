package ucuenca.microservice.suenio.temperatura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import ucuenca.microservice.suenio.temperatura.entity.TempEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class TempServiceImpl implements TempService{

    private final MongoOperations mongoOperations;

    @Autowired()
    @Qualifier(value = "mongoTemplate")
    MongoTemplate  mongoTemplate;

    public TempServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<TempEntity> findListTemp(String ini, String fin){
        Query query = new Query();
        //System.out.println("--------Entro en la funcion de listar----------");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(ini, format);
        LocalDateTime end = LocalDateTime.parse(fin, format);
        query.addCriteria(Criteria.where("fecha").gt(start).lt(end));
        List <TempEntity> tempDB = this.mongoOperations.find(query,TempEntity.class);
        //List <TempEntity> tempDB =  mongoTemplate.find(query,TempEntity.class);
        //System.out.println(tempDB);
        return tempDB;

    }
    @Override
    public List<TempEntity> findByIdUser(String id_usuario) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("id_usuario").is("0105737381"));
        List<TempEntity> users = mongoTemplate.find(query1, TempEntity.class);
        //System.out.println(users);
        return users;

    }

}
