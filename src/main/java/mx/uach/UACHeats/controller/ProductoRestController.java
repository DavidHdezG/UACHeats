package mx.uach.UACHeats.controller;

import mx.uach.UACHeats.model.Producto;
import mx.uach.UACHeats.service.api.ProductoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductoRestController {
    @Autowired
    private ProductoServiceAPI productoServiceAPI;
    @GetMapping("/all")
    public List<Producto> getAll(){
        return productoServiceAPI.getAll();
    }
    @GetMapping("/add")
    public ResponseEntity<Producto> add(Producto producto){
        Producto obj=productoServiceAPI.save(producto);
        return new ResponseEntity<Producto>(obj, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Producto getOne(@PathVariable Long id){
        return productoServiceAPI.get(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producto> delete(@PathVariable Long id){
        Producto producto = productoServiceAPI.get(id);
        if(producto != null){
            productoServiceAPI.delete(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        }else{
            return new ResponseEntity<Producto>(producto, HttpStatus.NOT_FOUND);
        }
    }
}
