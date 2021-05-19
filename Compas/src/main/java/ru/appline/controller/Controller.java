package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.Compas;
import ru.appline.logic.Model;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    private final static Model model = Model.getInstance();

    @GetMapping(value = "/getCompas", produces = "application/json")
    public Map<Integer, Compas> getAll(){
        return model.getAll();
    }

    /*
{
    "north": "338-22",
    "northEast": "22-68",
    "east": "68-112",
    "southEast": "112-158",
    "south": "158-202",
    "southWest": "202-248",
    "west": "248-292",
    "northWest": "292-338"
}
     */
    @PostMapping(value = "/setCompas", consumes = "application/json")
    public void setCompas (@RequestBody Compas compas){
        model.add(compas, 1);
    }
    /*
{
    "Degree": 56
}
     */
    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public Map<String, String> getSide (@RequestBody Map<String, Integer> degree){
        String side = model.getSide(degree.get("Degree"));
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("Side", side);
        return ret;
    }
}
