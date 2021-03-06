package ddwucom.mobile.week11.exam01;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodManager {
    private ArrayList<Food> foodList;

    public FoodManager() {
        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));
    }

    //getter
    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    //add
    public void addData(Food newFood) {
        foodList.add(newFood);
    }

    //remove
    public void removeData(int index) {
        foodList.remove(index);
    }

    //항목 받아오기
    public Food getFood(int index) {
        Food food = foodList.get(index);
        return food;
    }

    //수정하기
    public void changeData(int index, Food food) {
        foodList.set(index, food);
    }
}

