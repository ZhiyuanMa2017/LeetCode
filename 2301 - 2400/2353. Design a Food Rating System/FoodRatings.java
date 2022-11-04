import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class FoodRatings {
    Map<String, TreeMap<Integer, TreeSet<String>>> cuisineToRatings;
    Map<String, String> foodToCuisines;
    Map<String, Integer> foodToRatings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineToRatings = new HashMap<>();
        foodToCuisines = new HashMap<>();
        foodToRatings = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            if (!cuisineToRatings.containsKey(cuisine)) {
                cuisineToRatings.put(cuisine, new TreeMap<>());
            }
            foodToRatings.put(food, rating);
            foodToCuisines.put(food, cuisine);
            TreeMap<Integer, TreeSet<String>> ratingToFood = cuisineToRatings.get(cuisine);
            if (!ratingToFood.containsKey(rating)) {
                ratingToFood.put(rating, new TreeSet<>());
            }
            ratingToFood.get(rating).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisines.get(food);
        int oldRating = foodToRatings.get(food);
        foodToRatings.put(food, newRating);
        TreeMap<Integer, TreeSet<String>> ratingToFood = cuisineToRatings.get(cuisine);
        ratingToFood.get(oldRating).remove(food);
        if (ratingToFood.get(oldRating).size() == 0) {
            ratingToFood.remove(oldRating);
        }
        if (!ratingToFood.containsKey(newRating)) {
            ratingToFood.put(newRating, new TreeSet<>());
        }
        ratingToFood.get(newRating).add(food);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> ratingToFood = cuisineToRatings.get(cuisine);
        TreeSet<String> last = ratingToFood.get(ratingToFood.lastKey());
        return last.first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
