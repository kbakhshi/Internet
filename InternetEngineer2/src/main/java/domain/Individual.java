package domain;

import java.util.ArrayList;
import java.util.List;

public class Individual extends User {
    String phone;
    Integer balance;
    String userName;
    String password;
    List<String> hasPhoneHouse;

    public Individual(String name, String phone, Integer balance, String userName, String password) {
        super(name);
        this.phone = phone;
        this.balance = balance;
        this.userName = userName;
        this.password = password;
        hasPhoneHouse=new ArrayList<>();
    }

    public Individual(String name) {
        super(name);
        this.balance = 0;
        hasPhoneHouse=new ArrayList<>();
    }

    @Override
    public void addHouse(House house){
        super.addHouse(house);
    }

    public String getPhone() {
        return phone;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean hasHouse(String id){
        return hasPhoneHouse.contains(id);
    }
    public void addHouse(String houseId){
        hasPhoneHouse.add(houseId);
    }
}
