package ru.appline.logic;

import java.util.HashMap;
import java.util.Map;

public class Model {
    private static final Model instance = new Model();

    private final Map<Integer, Compas> model;

    public Model(){
        model = new HashMap<Integer, Compas>();
    }

    public static Model getInstance(){
        return instance;
    }

    public Map<Integer, Compas> getAll(){
        return model;
    }

    public void add(Compas compas, int id){
        model.put(id, compas);
    }

    public String getSide(int degree){
        Compas compas = model.get(1);
        String[] northDiap = compas.getNorth().split("-");
        String[] northEastDiap = compas.getNorthEast().split("-");
        String[] eastDiap = compas.getEast().split("-");
        String[] southEastDiap = compas.getSouthEast().split("-");
        String[] southDiap = compas.getSouth().split("-");
        String[] southWestDiap = compas.getSouthWest().split("-");
        String[] westDiap = compas.getWest().split("-");
        String[] northWestDiap = compas.getNorthWest().split("-");
        String side;

        if(degree>=Integer.parseInt(northDiap[0]) && degree<360 || degree<Integer.parseInt(northDiap[1]) && degree>0){
            side = "North";
        }
        else if (degree>=Integer.parseInt(northEastDiap[0]) && degree<Integer.parseInt(northEastDiap[1])){
            side = "North-East";
        }
        else if (degree>=Integer.parseInt(eastDiap[0]) && degree<Integer.parseInt(eastDiap[1])){
            side = "East";
        }
        else if (degree>=Integer.parseInt(southEastDiap[0]) && degree<Integer.parseInt(southEastDiap[1])){
            side = "South-East";
        }
        else if (degree>=Integer.parseInt(southDiap[0]) && degree<Integer.parseInt(southDiap[1])){
            side = "South";
        }
        else if (degree>=Integer.parseInt(southWestDiap[0]) && degree<Integer.parseInt(southWestDiap[1])){
            side = "South-West";
        }
        else if (degree>=Integer.parseInt(westDiap[0]) && degree<Integer.parseInt(westDiap[1])){
            side = "West";
        }
        else if (degree>=Integer.parseInt(northWestDiap[0]) && degree<Integer.parseInt(northWestDiap[1])){
            side = "North-West";
        }
        else {
            side = "Error in coordinate";
        }
        return side;
    }
}
