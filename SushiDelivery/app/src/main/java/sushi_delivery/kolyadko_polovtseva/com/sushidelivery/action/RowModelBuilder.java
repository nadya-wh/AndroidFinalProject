package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action;

import java.util.ArrayList;
import java.util.List;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.RowModel;

/**
 * Created by User on 20.12.2015.
 */
public class RowModelBuilder {

    public static ArrayList<RowModel> buildRowModel(List<Food> food) {
        ArrayList<RowModel> rows = new ArrayList<>(food.size());
        for (int i = 0; i < food.size(); i++) {
            rows.add(new RowModel(food.get(i).getFoodName(), false,
                    food.get(i).getImageUrl(), food.get(i).getPrice(), food.get(i).getType()));
        }
        return rows;
    }
}
