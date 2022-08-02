package ucuenca.microservice.suenio.temperatura.service;

import ucuenca.microservice.suenio.temperatura.entity.TempEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface TempService {

    public List<TempEntity> findListTemp(String ini,String fin);
    public List<TempEntity> findByIdUser(String id_usuario);
}
