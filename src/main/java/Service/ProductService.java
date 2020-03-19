package Service;

import Model.Product;
import Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> readAll(){
        List<Product> products = new ArrayList<>();
        //Tilføj elementer fra products(repo) listen til products(Service) listen.
        for (Product product : productRepo.readAll()) {
            products.add(product);
        }
        return products;
    }
}
