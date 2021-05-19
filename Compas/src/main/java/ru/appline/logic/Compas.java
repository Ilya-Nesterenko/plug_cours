package ru.appline.logic;

public class Compas {
    private String north;
    private String northEast;
    private String east;
    private String southEast;
    private String south;
    private String southWest;
    private String west;
    private String northWest;


    public Compas(String north, String northEast, String east, String southEast, String south, String southWest, String west, String northWest) {
        this.north = north;
        this.northEast = northEast;
        this.east = east;
        this.southEast = southEast;
        this.south = south;
        this.southWest = southWest;
        this.west = west;
        this.northWest = northWest;
    }

    public Compas(){
        super();
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getNorthEast() {
        return northEast;
    }

    public void setNorthEast(String northEast) {
        this.northEast = northEast;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouthEast() {
        return southEast;
    }

    public void setSouthEast(String southEast) {
        this.southEast = southEast;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getSouthWest() {
        return southWest;
    }

    public void setSouthWest(String southWest) {
        this.southWest = southWest;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getNorthWest() {
        return northWest;
    }

    public void setNorthWest(String northWest) {
        this.northWest = northWest;
    }
}
