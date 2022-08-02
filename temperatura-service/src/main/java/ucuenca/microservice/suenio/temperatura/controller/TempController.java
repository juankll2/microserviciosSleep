package ucuenca.microservice.suenio.temperatura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucuenca.microservice.suenio.temperatura.entity.TempEntity;
import ucuenca.microservice.suenio.temperatura.repository.TempRepository;
import ucuenca.microservice.suenio.temperatura.service.TempService;
import ucuenca.microservice.suenio.temperatura.service.TempServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.time.*;
import java.time.format.*;

@RestController
@RequestMapping("/api/temperatura")
public class TempController {
    @Autowired
    private TempRepository tempRepository;
    @Autowired
    TempService tempService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TempEntity> getAllTemp(){

        return tempRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createdTemp(@RequestBody TempEntity temp){
        tempRepository.save(temp);
    }


    @GetMapping (value = "/list/{fechaIni}/{fechaFin}")
    public  ResponseEntity<List<TempEntity>> findListTemp(@PathVariable String fechaIni,@PathVariable String fechaFin){
        System.out.println(fechaIni);
        System.out.println(fechaFin);
        List<TempEntity> temp = new ArrayList<>();
        temp = tempService.findListTemp(fechaIni, fechaFin);
        System.out.println(temp);
        if(temp.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/list/{id_user}")
    public ResponseEntity<List<TempEntity>> findListIdUser(@PathVariable String id_user){
        List<TempEntity> temp = new ArrayList<>();
        temp = tempService.findByIdUser(id_user);
        System.out.println(temp);
        if(temp.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(temp);
    }


}
