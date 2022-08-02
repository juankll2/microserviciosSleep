package ucuenca.microservice.suenio.sonido.service;

import ucuenca.microservice.suenio.sonido.entity.SoundEntity;

import java.util.List;

public interface SoundService {

    public List<SoundEntity> findListSound(String ini, String fin);
    public List<SoundEntity> findByIdUser(String id_usuario);
}
