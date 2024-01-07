package liberman;

import java.util.HashMap;
import java.util.Map;

public class ECommercePlatform {
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Product> products = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();

    public void addUsers(User user){
        users.put(user.getId(),user);
    }

    public void addProducts(Product product){
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId, Map<Product, Integer> cart){
        Order order = new Order(orders.size()+1,userId,cart);

        for(Map.Entry<Product, Integer> entry: cart.entrySet()){
            Product product = entry.getKey();
            Integer value = entry.getValue();

            if (products.containsKey(product.getId()) && products.get(product.getId()).getStock() >= value) {

                products.get(product.getId()).setStock(products.get(product.getId()).getStock() - value);
            } else {
                System.out.println("Недостатньо товару на складі для продукту: " + product);
            }
        }

        orders.put(order.getId(), order);
    }

    public void displayAllOrders() {
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }
    public void displayAllUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
    public void displayAllAvailableProducts() {
        for (Product product: products.values()) {
            System.out.println(product);
        }
    }


}
