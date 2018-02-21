package domain;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.net.*;

public class KhaneBeDoosh {
    private static List<User> users;
    private static Individual sessionUser;

    static {
        users = new ArrayList<User>();
        sessionUser = new Individual("بهنام همایون");
        sessionUser.setPhone("02122");
        users.add(sessionUser);

    }

    public static void createHouse(String area, String buildingType, String address, String dealType, String price, String phone, String description) throws IllegalArgumentException {
        int basePrice = 0;
        int rentPrice = 0;
        int sellPrice = 0;
        int houseDealType = 0;
        if (dealType.equals("فروش")) {
            sellPrice = Integer.parseInt(price);
        } else if (dealType.equals("اجاره")) {
            rentPrice = Integer.parseInt(price);
            houseDealType = 1;
        } else if (dealType.equals("رهن")) {
            basePrice = Integer.parseInt(price);
            houseDealType = 1;
        } else {
            throw new IllegalArgumentException("نوع قرار داد به درستی وارد نشده است");
        }
        House house = new House();
        house.setId("1");
        house.setArea(Integer.parseInt(area));
        house.setBuildingType(buildingType);
        house.setDealType(houseDealType);
        house.setAddress(address);
        house.setPhone(phone);
        house.setDescription(description);
        house.setPrice(new Price(basePrice, rentPrice, sellPrice));
        house.setUser(sessionUser);

        sessionUser.addHouse(house);

    }

    public static ArrayList<House> getAllHouses() {
        ArrayList<House> allHouses = new ArrayList<>();
        for (User user : users) {
            allHouses.addAll(user.getHouses());
        }
        return allHouses;
    }

    public static ArrayList<House> searchHouse(String minArea, String buildingType, String dealType, String maxPrice) {
        ArrayList<House> allHouses = getAllHouses();

        allHouses.addAll(getHouseFromBongah());
        ArrayList<House> foundHouses = new ArrayList<>();
        int dealTypeInt = 1;
        if (dealType.equals("فروش")) {
            dealTypeInt = 0;
        }
        for (House house : allHouses) {

            if (house.checkHouse(minArea, buildingType, dealTypeInt, maxPrice)) {
                foundHouses.add(house);
            }
        }
        return foundHouses;
    }

    public static House findHouse(String houseId) {
        List<House> allHouses = getAllHouses();
        allHouses.addAll(getHouseFromBongah());
        for (House h : allHouses) {
            if (h.getId().equals(houseId)) {
                return h;
            }
        }
        return null;
    }

    protected static List<House> getHouseFromBongah() {
        URL url = null;
        try {
            url = new URL("http://acm.ut.ac.ir/khaneBeDoosh/house");
            HttpURLConnection c = (HttpURLConnection) url.openConnection();  //connecting to url
            c.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));  //stream to resource
            String str, responsestring = "";
            List<House> actualObj2;
            str = in.readLine(); //reading data
            in.close();  //closing stream

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(str);

            ObjectMapper mapper2 = new ObjectMapper();
            List<House> participantJsonList = mapper.readValue(actualObj.get("data").toString(), new TypeReference<List<House>>() {
            });
            return participantJsonList;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean IncreaseEtebar(String pay) {
        Integer payment = Integer.parseInt(pay);
        int userId = 123;
        boolean result = getAnswerFromBank(payment, userId);
        if (result) {
            sessionUser.setBalance(sessionUser.getBalance() + payment);
        }
        return getAnswerFromBank(payment, userId);


    }

    public static boolean getAnswerFromBank(int value, int userId) {
        try {
            URL url = new URL("http://acm.ut.ac.ir/ieBank/pay");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("apiKey", "8a6160c0-165c-11e8-87b4-496f79ef1988");


            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.createObjectNode();
            ((ObjectNode) json).put("userId", sessionUser.getId());
            ((ObjectNode) json).put("value", value);
            String request = json.toString();
            byte[] out = request.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(out);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            ObjectMapper mapper2 = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(response.toString());
            boolean result = actualObj.get("success").asBoolean();
            return result;

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getPhoneNumber(String houseId) {
        House house=findHouse(houseId);
        if (sessionUser.hasHouse(houseId)) {
            return house.getPhone();
        } else if (sessionUser.getBalance() >= 1000) {
            if(house.getPhone()!=null){
                sessionUser.setBalance(sessionUser.getBalance()-1000);
                sessionUser.addHouse(house.getId());
                return house.getPhone();
            }
            throw new IllegalArgumentException("ملک انتخاب شده فاقد شماره می باشد");
        }
        throw new IllegalArgumentException("اعتبار شما برای نمایش شماره تلفن کافی نمیباشد");
    }

    public static Individual getSessionUser() {
        return sessionUser;
    }
}


