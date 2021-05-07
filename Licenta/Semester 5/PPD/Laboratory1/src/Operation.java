import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operation extends Repository implements Runnable {

    private String name;
    private Repository deposit;
    private Lock _mutex = new ReentrantLock();

    public Operation(Repository deposit, String name) {
        this.deposit = deposit;
        this.name = name;
    }

   @Override
    public void run() {
        for (Product product : this.getProducts()){
            _mutex.lock();
            try {
                deposit.remove(product, this.getQuantity(product));
                System.out.println(this.name + ": took " + product.getName() + " -> " + String.valueOf(this.getQuantity(product)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            _mutex.unlock();
        }
    }

    @Override
    public void add(Product product, int quantity) {
        super.add(product, quantity);

    }

    @Override
    public void remove(Product product, int quantity) {
        super.remove(product, quantity);

    }

    public String getName() {
        return this.name;
    }




}
