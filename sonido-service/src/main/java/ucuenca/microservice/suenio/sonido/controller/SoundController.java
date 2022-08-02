package ucuenca.microservice.suenio.sonido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucuenca.microservice.suenio.sonido.entity.SoundEntity;
import ucuenca.microservice.suenio.sonido.repository.SoundRepository;
import ucuenca.microservice.suenio.sonido.service.SoundService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sonido")
public class SoundController {


    @Autowired
    private SoundRepository soundRepository;

    @Autowired
    SoundService soundService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SoundEntity> getAllTemp(){
        return soundRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createdTemp(@RequestBody SoundEntity temp){
     soundRepository.save(temp);
    }


    @GetMapping (value = "/list/{fechaIni}/{fechaFin}")
    public ResponseEntity<List<SoundEntity>> findListSound(@PathVariable String fechaIni, @PathVariable String fechaFin){
        System.out.println(fechaIni);
        System.out.println(fechaFin);
        List<SoundEntity> temp = new ArrayList<>();
        temp = soundService.findListSound(fechaIni, fechaFin);
        System.out.println(temp);
        if(temp.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/list/{id_user}")
    public ResponseEntity<List<SoundEntity>> findListIdUser(@PathVariable String id_user){
        List<SoundEntity> temp = new ArrayList<>();
        temp = soundService.findByIdUser(id_user);
        System.out.println(temp);
        if(temp.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(temp);
    }


}
