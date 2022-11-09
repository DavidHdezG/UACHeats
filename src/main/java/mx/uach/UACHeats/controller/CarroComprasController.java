package mx.uach.UACHeats.controller;

import lombok.RequiredArgsConstructor;
import mx.uach.UACHeats.dto.PedidoDTO;
import mx.uach.UACHeats.dto.ResponseDTO;
import mx.uach.UACHeats.model.Pedido;
import mx.uach.UACHeats.model.Producto;
import mx.uach.UACHeats.service.impl.PedidoServiceImpl;
import mx.uach.UACHeats.service.impl.ProductoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carroCompras")
public class CarroComprasController {
    private PedidoServiceImpl pedidoService;
    private ProductoServiceImpl productoService;

    public Logger logger = Logger.getLogger(CarroComprasController.class.getName());

    @GetMapping("/carroCompras/all")
    public ResponseEntity<List<Producto>> getAllProductos() {
        logger.info("Getting all productos");
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/carroCompras/getOrder/{orderId}")
    public ResponseEntity<Producto> getOrderDetails(@PathVariable int orderId) {
        logger.info("Getting order details");
        return ResponseEntity.ok(productoService.get((long) orderId));
    }

    @PostMapping("/carroCompras/placeOrder")
    public ResponseEntity<Producto> placeOrder(@RequestBody PedidoDTO pedido) {
        logger.info("Request Payload " + pedido.toString());
        ResponseDTO responseDTO = new ResponseDTO();
        float amount = pedidoService.getCantidad(pedido.getProductos());

        return null;
    }
}
