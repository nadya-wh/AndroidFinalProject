package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.init;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.*;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.FoodParameters;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.FoodType;

/**
 * Created by User on 20.12.2015.
 */
public class FoodInitializer {

    private FoodType foodType;
    private InputStream inputStream;
    private String file;
    private JSONObject jsonObject;

    public FoodInitializer(FoodType foodName, InputStream filename) {
        this.inputStream = filename;
        this.foodType = foodName;
    }

    public boolean init() {
        readJSON();
        try {
            jsonObject = new JSONObject(file);
            return true;
        } catch (JSONException e) {
        }
        return false;
    }

    private void readJSON() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            file = sb.toString();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public ArrayList<Food> initFoodItems() {
        ArrayList<Food> food = null;
        try {
            JSONArray foodJSON = jsonObject.getJSONArray(foodType.getMultipleFormValue());
            food = new ArrayList<>(foodJSON.length());
            for (int i = 0; i < foodJSON.length(); i++) {
                double price = foodJSON.getJSONObject(i).getDouble(FoodParameters.PRICE.getValue());
                String name = foodJSON.getJSONObject(i).getString(FoodParameters.NAME.getValue());
                String imageUrl = foodJSON.getJSONObject(i).getString(FoodParameters.IMAGE_URL.getValue());
                food.add(new Food(foodType, name, price, imageUrl));
            }
        } catch (JSONException e) {
            return null;
        }
        return food;
    }

}
