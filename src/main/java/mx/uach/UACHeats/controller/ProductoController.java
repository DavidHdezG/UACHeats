package mx.uach.UACHeats.controller;

import mx.uach.UACHeats.model.Producto;
import mx.uach.UACHeats.service.api.ProductoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductoController {
    @Autowired
    private ProductoServiceAPI productoServiceAPI;

    @RequestMapping("/all")
    public String index(Model model){
        model.addAttribute("productos", productoServiceAPI.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("producto", new Producto());
        return "add";
    }
    @PostMapping("/save")
    public String save(Producto persona, Model model) {
        productoServiceAPI.save(persona);
        return "redirect:/home/";
    }
    @GetMapping("/edit/{id}")
    public String edit(Producto producto, Model model) {
        model.addAttribute("producto", productoServiceAPI.get((long) producto.getId()));
        return "edit";
    }
}
