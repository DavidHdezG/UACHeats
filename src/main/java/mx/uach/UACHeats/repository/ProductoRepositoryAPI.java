package mx.uach.UACHeats.repository;

import mx.uach.UACHeats.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductoRepositoryAPI  extends CrudRepository<Producto, Long> {
}
