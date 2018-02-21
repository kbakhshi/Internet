package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;



public class House implements Serializable{
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

    public House(User user, Integer area, String buildingType, String address, String phone, String description, String id, Integer dealType, Price price, String expireTime, String imageURL) {
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

    public House() {
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getArea() {
        return this.area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getBuildingType() {
        return this.buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDealType() {
        return this.dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public Price getPrice() {
        return this.price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public boolean checkHouse(String minArea, String buildingType, int dealType, String maxPrice){

        double price2 = ((price.getBasePrice()!=null)?price.getBasePrice():0) +
                ((price.getSellPrice()!=null)?price.getSellPrice():0) +
                ((price.getRentPrice()!=null)?price.getRentPrice():0);
        if((this.area >= Double.parseDouble(minArea)) &&
                buildingType.equals(this.buildingType) &&
                dealType==this.dealType &&
                Double.parseDouble(maxPrice) >= price2){
            return true;
        }
        return false;
    }
}
