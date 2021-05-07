import java.util.HashMap;
import java.util.Set;

public class Repository {
    private HashMap<Product, Integer> products;

    public Repository() {
        this.products = new HashMap<>();
    }

    public void add(Product product, int quantity){
        if (this.products.containsKey(product)){
            this.products.replace(product, this.products.get(product) + quantity);
        }else{
            this.products.put(product, quantity);
        }

    }

    public void remove(Product product, int quantity){
        if (this.products.containsKey(product)){
            if (this.getQuantity(product) < quantity){
                throw new RuntimeException("the existing quantity is not sufficient!");
            }
            this.products.replace(product, this.products.get(product) - quantity);
            if (this.getQuantity(product) == 0){
                this.products.remove(product);
            }

        }else{
            throw new RuntimeException("inexistent product in inventory!");
        }
    }

    public Set<Product> getProducts(){
        return this.products.keySet();
    }

    public int getQuantity(Product product) {
        return this.products.getOrDefault(product, 0);
    }

    @Override
    public String toString() {
        StringBuilder ss = new StringBuilder();
        for (Product product : this.getProducts()){
            ss.append("{").append(product.getName()).append(", ").append(this.getQuantity(product)).append("}\n");
        }

        return ss.toString();
    }
    public int TotalPrice()
    {
        int price=0;
        for (Product product : this.getProducts()){
            price += this.getQuantity(product) * product.getPrice();
        }
        return price;

    }
}
