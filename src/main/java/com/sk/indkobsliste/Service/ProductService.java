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

    @Autowired
    ProductRepo productRepo;

    public List<Product> readAll(){
        List<Product> products = new ArrayList<>();
        //Tilføj elementer fra products(repo) listen til products(com.sk.indk.bsliste.Service) listen.
        for (Product product : productRepo.readAll()) {
            products.add(product);
        }
        return products;
    }
    public void create(Product product){

        productRepo.create(product);
    }
    public void delete(Long id){

        productRepo.delete(id);
    }
}
