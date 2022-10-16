package mx.uach.UACHeats.controller;

import mx.uach.UACHeats.model.Pago;
import mx.uach.UACHeats.service.api.PagoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pago")
@CrossOrigin("*")
public class PagoRestController {
    @Autowired
    private PagoServiceAPI pagoServiceAPI;

    @GetMapping("/all")
    public List<Pago> getAll(){
        return pagoServiceAPI.getAll();
    }

    @GetMapping("/{id}")
    public Pago get(@PathVariable("id") Integer id){
        return pagoServiceAPI.get(id);
    }

    @PostMapping("/add")
    public Pago add(@RequestBody Pago pago){
        return pagoServiceAPI.save(pago);
    }

    @PutMapping("/update")
    public Pago update(@RequestBody Pago pago){
        return pagoServiceAPI.save(pago);
    }
}
