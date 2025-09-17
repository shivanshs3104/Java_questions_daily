import java.util.*;

class FoodRatings {
    Map<String, String> foodToCuisine;   // food -> cuisine
    Map<String, Integer> foodToRating;   // food -> rating
    Map<String, TreeSet<String>> cuisineFoods; // cuisine -> foods sorted by (rating desc, name asc)

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineFoods.putIfAbsent(cuisine, new TreeSet<>((a, b) -> {
                if (!foodToRating.get(a).equals(foodToRating.get(b))) {
                    return foodToRating.get(b) - foodToRating.get(a); // high rating first
                }
                return a.compareTo(b); // lexicographically smaller
            }));

            cuisineFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        // pehle purana remove karna padega
        cuisineFoods.get(cuisine).remove(food);

        // update rating
        foodToRating.put(food, newRating);

        // naya rating ke sath dobara add karo
        cuisineFoods.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first(); // sabse top element
    }
}
