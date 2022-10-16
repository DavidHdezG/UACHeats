package mx.uach.UACHeats.service.impl;

import mx.uach.UACHeats.commons.GenericServiceImpl;
import mx.uach.UACHeats.model.Pago;
import mx.uach.UACHeats.repository.PagoRepositoryAPI;
import mx.uach.UACHeats.service.api.PagoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl extends GenericServiceImpl<Pago, Integer> implements PagoServiceAPI {

        @Autowired
        private PagoRepositoryAPI pagoRepositoryAPI;

        @Override
        public CrudRepository<Pago, Integer> getRepository() {
            return pagoRepositoryAPI;
        }

}
