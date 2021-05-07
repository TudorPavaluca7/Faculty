import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static int THREADS = 4;
    private static Repository repo = new Repository();
    private static List<Product> products = new ArrayList<>();
    private static List<Operation> operations = new ArrayList<>();
    private static int firstPrice;
    private static RandomG r = new RandomG();

    private static void populate() {
        for (int i = 0; i < 1000; i++) {

            Product p = new Product(r.generateRandomString(), r.getRandomNumber());
            products.add(p);
            repo.add(p, r.getRandomNumber());
            //System.out.println(p.toString());
        }
    }

    static void check() {

        int afterSales= repo.TotalPrice();
        System.out.println(afterSales);
        int sum=0;
        for (Operation op:operations)
            sum+=op.TotalPrice();
        if (sum+afterSales==firstPrice)
            System.out.println("Verification Successful!");
        else
            System.out.println("Something went wrong");

    }


    public static void main(String[] args) {
    populate();
    firstPrice=repo.TotalPrice();
    System.out.println(firstPrice);
    float start =  System.nanoTime() / 1000000;
    for (int i = 0; i < THREADS; i++)
    {
        Operation op=new Operation(repo,"thread"+i);
        int NrOfProducts =  new Random().nextInt(10);
        if (NrOfProducts<0)
            NrOfProducts=0-NrOfProducts;
        for (int j = 0; j < NrOfProducts; j++) {

            int quantity= new Random().nextInt(5);
            if (quantity<0)
                quantity=0-quantity;
            int productId = new Random().nextInt(products.size());
            if (productId<0)
                productId=0-productId;
            op.add(products.get(productId), quantity);

        }
//        System.out.println(i);
//        for (Product p:op.getProducts())
//            System.out.println(p.toString());

        operations.add(op);



    }



        List<Thread> threads = new ArrayList<>();

        for (Operation o:operations)
            threads.add(new Thread(o));

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        check();

        float end = System.nanoTime() / 1000000;
        System.out.println("\n End work: " + (end - start) / 1000 + " seconds");

    }
}



