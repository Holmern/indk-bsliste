package com.sk.indkobsliste.Controller;


import com.sk.indkobsliste.Model.Product;
import com.sk.indkobsliste.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/Delete/{id}")
    public String delete(@PathVariable("id") long id){
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/Update/{id}")
    public String update(@PathVariable ("id") long id, Model model){
        model.addAttribute("productList", productService.read(id));
        return "Update";
    }

    @PostMapping("/Update")
    public String update(@ModelAttribute Product product){
        productService.update(product);
        return "redirect:/";
    }




}