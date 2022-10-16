package mx.uach.UACHeats.repository;

import mx.uach.UACHeats.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PedidoRepositoryAPI extends CrudRepository<Pedido, Long> {

}

