package domain;

import java.io.Serializable;

public class Price implements Serializable {
    private Integer basePrice;
    private Integer rentPrice;
    private Integer sellPrice;

    public Price() {
    }

    public Price(Integer basePrice, Integer rentPrice, Integer sellPrice) {
        this.basePrice = basePrice;
        this.rentPrice = rentPrice;
        this.sellPrice = sellPrice;
    }


    public Integer getBasePrice() {
        return basePrice;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }
}
