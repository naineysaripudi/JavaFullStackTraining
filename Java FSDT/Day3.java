import java.util.*;
import java.util.stream.Collectors;

class Order {

    int orderId;
    String customerName;
    String product;
    String category;
    double amount;
    String status;
    String deliveryCity;

    Order(int orderId, String customerName, String product,
          String category, double amount, String status,
          String deliveryCity) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.deliveryCity = deliveryCity;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               ", Customer: " + customerName +
               ", Product: " + product +
               ", Category: " + category +
               ", Amount: " + amount +
               ", Status: " + status +
               ", City: " + deliveryCity;
    }
}

public class Day3{

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(

            new Order(101, "Ravi", "Laptop", "Electronics", 55000, "Delivered", "Hyderabad"),
            new Order(102, "Raj", "Mobile", "Electronics", 25000, "Pending", "Vijayawada"),
            new Order(103, "Kiran", "Shoes", "Fashion", 3000, "Delivered", "Chennai"),
            new Order(104, "Arjun", "Watch", "Fashion", 5000, "Cancelled", "Hyderabad"),
            new Order(105, "Sai", "Tablet", "Electronics", 30000, "Delivered", "Bangalore"),
            new Order(106, "Manoj", "Chair", "Furniture", 8000, "Pending", "Chennai"),
            new Order(107, "Karthik", "Sofa", "Furniture", 45000, "Delivered", "Hyderabad"),
            new Order(108, "Pavan", "Headphones", "Electronics", 4000, "Delivered", "Vijayawada"),
            new Order(109, "Teja", "T-Shirt", "Fashion", 1500, "Pending", "Bangalore"),
            new Order(110, "Ajay", "Table", "Furniture", 12000, "Delivered", "Chennai")
        );



        System.out.println("\n--- FILTER ORDERS ---");

        orders.stream()
            .filter(o -> o.amount > 10000 && o.status.equals("Delivered"))
            .forEach(System.out::println);



        System.out.println("\n--- SORT BY AMOUNT ---");

        orders.stream()
            .sorted(Comparator.comparingDouble(o -> o.amount))
            .forEach(System.out::println);



        System.out.println("\n--- HIGHEST ORDER ---");

        orders.stream()
            .max(Comparator.comparingDouble(o -> o.amount))
            .ifPresent(System.out::println);



        System.out.println("\n--- LOWEST ORDER ---");

        orders.stream()
            .min(Comparator.comparingDouble(o -> o.amount))
            .ifPresent(System.out::println);



        System.out.println("\n--- TOTAL SALES ---");

        double totalSales = orders.stream()
            .mapToDouble(o -> o.amount)
            .sum();

        System.out.println("Total Sales: " + totalSales);



        System.out.println("\n--- TOTAL ORDERS ---");

        long count = orders.stream()
            .count();

        System.out.println("Total Orders: " + count);



        System.out.println("\n--- GROUP BY CATEGORY ---");

        Map<String, List<Order>> categoryGroups = orders.stream()
            .collect(Collectors.groupingBy(o -> o.category));

        categoryGroups.forEach((category, list) -> {
            System.out.println("\n" + category);
            list.forEach(System.out::println);
        });



        System.out.println("\n--- GROUP BY CITY ---");

        Map<String, List<Order>> cityGroups = orders.stream()
            .collect(Collectors.groupingBy(o -> o.deliveryCity));

        cityGroups.forEach((city, list) -> {
            System.out.println("\n" + city);
            list.forEach(System.out::println);
        });



        System.out.println("\n--- AVERAGE ORDER AMOUNT ---");

        double average = orders.stream()
            .collect(Collectors.averagingDouble(o -> o.amount));

        System.out.println("Average Order Amount: " + average);


        System.out.println("\n--- SALES BY CATEGORY ---");

        Map<String, Double> salesByCategory = orders.stream()
            .collect(Collectors.groupingBy(
                o -> o.category,
                Collectors.summingDouble(o -> o.amount)
            ));

        salesByCategory.forEach((category, sales) ->
            System.out.println(category + " : " + sales)
        );

    }
}
