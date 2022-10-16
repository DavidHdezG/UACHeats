package mx.uach.UACHeats.repository;

import mx.uach.UACHeats.model.Pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PagoRepositoryAPI extends CrudRepository<Pago, Integer> {


}
