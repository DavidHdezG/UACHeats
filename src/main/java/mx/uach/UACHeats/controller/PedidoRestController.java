package mx.uach.UACHeats.controller;

import mx.uach.UACHeats.model.Pedido;
import mx.uach.UACHeats.service.api.PedidoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
public class PedidoRestController {
    @Autowired
    private PedidoServiceAPI pedidoServiceAPI;
    @GetMapping("/all")
    public List<Pedido> getAll(){
        return pedidoServiceAPI.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<Pedido> add(Pedido pedido){
        Pedido obj=pedidoServiceAPI.save(pedido);
        return new ResponseEntity<Pedido>(obj, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Pedido get(@PathVariable Long id){
        return pedidoServiceAPI.get(id);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, Pedido pedido){
        Pedido obj = pedidoServiceAPI.get(id);
        if(obj != null){
            obj.setEstadoPedido(pedido.getEstadoPedido());
            pedidoServiceAPI.save(obj);
            return new ResponseEntity<Pedido>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<Pedido>(obj, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable Long id){
        Pedido pedido = pedidoServiceAPI.get(id);
        if(pedido != null){
            pedidoServiceAPI.delete(id);
            return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
        }else{
            return new ResponseEntity<Pedido>(pedido, HttpStatus.NOT_FOUND);
        }
    }
}
