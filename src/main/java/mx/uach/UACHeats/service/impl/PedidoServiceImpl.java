package mx.uach.UACHeats.service.impl;

import mx.uach.UACHeats.commons.GenericServiceImpl;
import mx.uach.UACHeats.model.Pedido;
import mx.uach.UACHeats.repository.PedidoRepositoryAPI;
import mx.uach.UACHeats.service.api.PedidoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoServiceAPI {
    @Autowired
    private PedidoRepositoryAPI pedidoRepositoryAPI;
    @Override
    public CrudRepository<Pedido, Long> getRepository() {
        return pedidoRepositoryAPI;
    }
}


