package mx.uach.UACHeats.service.impl;

import mx.uach.UACHeats.commons.GenericServiceImpl;
import mx.uach.UACHeats.model.Producto;
import mx.uach.UACHeats.repository.ProductoRepositoryAPI;
import mx.uach.UACHeats.service.api.ProductoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements ProductoServiceAPI {
    @Autowired
    private ProductoRepositoryAPI productoRepositoryAPI;
    @Override
    public CrudRepository<Producto, Long> getRepository() {
        return productoRepositoryAPI;
    }
}
