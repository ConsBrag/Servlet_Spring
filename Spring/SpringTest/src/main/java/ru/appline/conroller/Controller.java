package ru.appline.conroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);
    private int Id;

    @PostMapping(value = "/createPet", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object createPet(@RequestBody Pet pet) {
        Id = newId.getAndIncrement();
        petModel.add(pet, Id);
        if(Id == 1){
            //You create first pet
            return new ResponseEntity<String>("{\"text\":You_create_first_pet}", HttpStatus.OK);
        }
        else if(Id != 1){
            //You create pet
            return new ResponseEntity<String>("{\"text\":You_create_pet}", HttpStatus.OK);
        }
        return new ResponseEntity<String>("{\"text\":Create_pet_-_FAILED}", HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @PutMapping(value = "/putPet", consumes = "application/json")
    public void putPet(@RequestBody Pet pet, int Id) {
        petModel.put(pet, Id);
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json")
    public void deletePet(@RequestParam(value="del") Integer del) {
        petModel.deleteById(del);
    }

}
