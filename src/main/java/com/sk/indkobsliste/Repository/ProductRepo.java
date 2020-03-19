package com.sk.indkobsliste.Repository;

import com.sk.indkobsliste.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {

    private List<Product> products = new ArrayList<>();

    public ProductRepo(){
        this.products.add(new Product(1, "Æble", 5, "Pink Lady"));
        this.products.add(new Product(2, "Mælk", 9, "Arla"));
        this.products.add(new Product(3, "Cola", 10, "Coca-cola"));
    }

    public List<Product> readAll(){
        return products;
    }

    public void create(Product product) {
       products.add(new Product(product.getId(), product.getName(),product.getPrice(), product.getDescription()));
    }

    public void delete(Long id) {
        products.removeIf(i -> i.getId() == id);
    }

    public boolean update (Product product){
        for (int i = 0;  i<products.size(); i++){
            if (products.get(i).getId()==product.getId()){
                products.set(i,product);

                return true;
            }
        }
        return false;
    }
}
