package domain;

import java.util.ArrayList;

public class User {
    private Integer id;
    private String name;
    private ArrayList<House> houses;

    public User(String name) {
        this.name = name;
        this.houses = new ArrayList<House>();
        this.id=1;
    }

    public void addHouse(House house){
        this.houses.add(house);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<House> getHouses(){
        return houses;
    }

    public Integer getId() {
        return id;
    }
}
