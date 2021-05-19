package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private final static PetModel petModel = PetModel.getInstance();
    private final static AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "text/html")
    public String createPet(@RequestBody Pet pet){
        petModel.add(pet, newId.getAndIncrement());
        if (newId.get() == 2){
            return "You create your first pet!";
        }
        else return "You create pet!";
    }

    @GetMapping (value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll(){
        return petModel.getAll();
    }

    @GetMapping (value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id){
        return petModel.getFromList(id.get("id"));
    }

    /*
    {
    "1":{"name": "someName", "type": "someType", "age": 5}
    }
     */
    @PutMapping (value = "/putPet", consumes = "application/json")
    public void putPet(@RequestBody Map<Integer, Pet> pet){
        int petKey = pet.keySet().iterator().next();
        petModel.add(pet.get(petKey), petKey);
    }

    /*
    {"id": 3}
     */
    @DeleteMapping (value = "/deletePet", consumes = "application/json")
    public void deletePet(@RequestBody Map<String, Integer> id){
        petModel.deletePet(id.get("id"));
    }
}
