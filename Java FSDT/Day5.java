

public class Day5{
    public static void main(String[] args) throws Exception{
    Thread t1 = new Thread(()->{
        System.out.println("Order a food");
    });
        
    Thread t2 = new Thread(()->{
    System.out.println("Confirm by rest...");
    });

    Thread t3 = new Thread(()->{
    System.out.println("Food is served");
    });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
         
        
    System.out.println("Food is completed");
    }
}

/*Expected Output: 
 Order a food
Confirm by rest...
Food is served
Food is completed */