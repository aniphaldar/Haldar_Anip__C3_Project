import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService  {
    private static List<Restaurant> restaurants = new ArrayList<>();

  //  RestaurantService service = new RestaurantService();
    Restaurant restaurant;

    public  static Restaurant findRestaurantByName(String restaurantName) {

        Restaurant restaurant;

       LocalTime openingTime = LocalTime.parse("10:00:00");
       LocalTime closingTime = LocalTime.parse("22:00:00");
       restaurant = new Restaurant("Amelie's cafe","Bangalore",  openingTime,  closingTime);

        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        System.out.println("this is the name "+ restaurant.getName());

       if (restaurant.getName().equals(restaurantName)) {
            System.out.println(" restaurant Name  ----" + restaurantName);
            return restaurant;

        }
      //return null;
      return null;
    }

    
    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }


    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public static List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
