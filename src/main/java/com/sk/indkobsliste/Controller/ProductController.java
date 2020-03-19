package com.sk.indkobsliste.Controller;


import com.sk.indkobsliste.Model.Product;
import com.sk.indkobsliste.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController
{
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("productList", productService.readAll());

        return "Index";
    }
    @GetMapping("/Create")
    public String create(){

        return "Create";
    }

    @PostMapping("/Create")
    public String create (@ModelAttribute Product product){
        productService.create(product);
        return "redirect:/";
    }



}