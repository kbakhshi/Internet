package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

import java.io.Serializable;



public class House2 implements Serializable{
    private User user;
    private Integer area;
    private String buildingType;
    private String address;
    private String phone;
    private String description;

    private String id;
    private Integer dealType;
    private Price price;

    private String expireTime;
    private String imageURL;

    public House2(User user, Integer area, String buildingType,
                 String address, String  phone,
                 String description, String id,
                 Integer dealType, Price price,
                 String expireTime, String imageURL){
        this.user = user;
        this.area = area;
        this.buildingType = buildingType;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.id = id;
        this.dealType = dealType;
        this.price = price;
        this.expireTime = expireTime;
        this.imageURL = imageURL;

    }

    public House2(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void printHouseInfo(){
        if(this.dealType == 0 ){
            System.out.println(" قیمت " +this.price.getSellPrice());
            System.out.println(" نوع : فروش ");
        }
        else {
            System.out.println("قیمت پایه : " + this.price.getBasePrice());
            System.out.println("قیمت اجاره: " + this.price.getRentPrice());
            System.out.println(" نوع : رهن و اجاره ");
        }
        System.out.println(" متراژ : " + this.area);
        System.out.println(" لینک عکس : " + this.imageURL);

    }
}
