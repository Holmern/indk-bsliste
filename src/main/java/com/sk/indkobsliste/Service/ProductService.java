package com.sk.indkobsliste.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sk.indkobsliste.Model.Product;
import com.sk.indkobsliste.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    @Autowired
    ProductRepo productRepo;

    public List<Product> readAll(){
        products = new ArrayList<>();
        //Tilføj elementer fra products(repo) listen til products(com.sk.indk.bsliste.Service) listen.
        for (Product product : productRepo.readAll()) {
            products.add(product);
        }
        return products;
    }
    public Product read(long id) {
        int i = 0;
        while (i < products.size()) {
            if (products.get(i).getId() == id) return products.get(i);
        i++;
        }
        return null;
    }



            public void create(Product product){

        productRepo.create(product);
    }
    public void delete(Long id){

        productRepo.delete(id);
    }
   public boolean update(Product product){
        boolean updateOK = productRepo.update(product);
        return updateOK;
    }

}
