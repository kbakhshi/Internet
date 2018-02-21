package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsonParser implements Serializable {
    private String result;
    private List<House> data;
    public JsonParser() {
        this.data=new ArrayList<>();
    }
    public JsonParser(String result, List<House> houses) {
        this.result = result;
        this.data = houses;
    }



    public String getResult() {
        return result;
    }

    public List<House> getHouses() {
        return data;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setHouses(List<House> houses) {
        this.data = houses;
    }
}
