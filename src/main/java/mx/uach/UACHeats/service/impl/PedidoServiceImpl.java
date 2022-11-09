package mx.uach.UACHeats.service.impl;

import mx.uach.UACHeats.commons.GenericServiceImpl;
import mx.uach.UACHeats.model.CarroCompras;
import mx.uach.UACHeats.model.Pedido;
import mx.uach.UACHeats.model.Producto;
import mx.uach.UACHeats.repository.PedidoRepositoryAPI;
import mx.uach.UACHeats.repository.ProductoRepositoryAPI;
import mx.uach.UACHeats.service.api.PedidoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoServiceAPI {
    @Autowired
    private PedidoRepositoryAPI pedidoRepositoryAPI;
    private ProductoRepositoryAPI productoRepository;

    public PedidoServiceImpl(PedidoRepositoryAPI pedidoRepositoryAPI, ProductoRepositoryAPI productoRepository) {
        this.pedidoRepositoryAPI = pedidoRepositoryAPI;
        this.productoRepository = productoRepository;
    }

    public Pedido getPedidoDescripcion(long id) {
        Optional<Pedido> pedido = pedidoRepositoryAPI.findById(id);
        return pedido.orElse(null);

    }

    public float getCantidad(List<CarroCompras> lista){
        float total = 0f;
        float totalIndividual = 0f;
        int cantidad = 0;

        for (CarroCompras carroCompras : lista) {
            int productoId = carroCompras.getProductId();
            Optional<Producto> producto = productoRepository.findById((long) productoId);

            if(producto.isPresent()){
                Producto producto1 = producto.get();
                if(producto1.getCantidad()<carroCompras.getQuantity()){
                    totalIndividual = producto1.getCantidad() * producto1.getPrecio();
                    carroCompras.setQuantity(producto1.getCantidad());
                } else {
                    totalIndividual=carroCompras.getQuantity() * producto1.getPrecio();
                    cantidad = producto1.getCantidad() - carroCompras.getQuantity();
                }
                total=total+totalIndividual;
                producto1.setCantidad(cantidad);
                cantidad=0;
                carroCompras.setProductName(producto1.getNombre());
                carroCompras.setAmount(totalIndividual);
                productoRepository.save(producto1);
            }

        }
        return total;
    }

    @Override
    public CrudRepository<Pedido, Long> getRepository() {
        return pedidoRepositoryAPI;
    }
}


