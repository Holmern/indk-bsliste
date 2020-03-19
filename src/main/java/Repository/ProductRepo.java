package Repository;

import Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {

    private List<Product>products = new ArrayList<>();

    public ProductRepo(){
        this.products.add(new Product(1, "Æble", 5, "Pink Lady"));
        this.products.add(new Product(2, "Mælk", 9, "Arla"));
        this.products.add(new Product(3, "Cola", 10, "Coca-cola"));
    }

    public List<Product> readAll(){
        return products;
    }
}
