package mx.uach.UACHeats.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public abstract class GenericServiceImpl<T,id extends Serializable> implements GenericServiceAPI<T,id>{

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(id id) {
        getRepository().deleteById(id);
    }

    @Override
    public T get(id id) {
        Optional<T> obj = getRepository().findById(id);

        return obj.orElse(null);
    }


    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        getRepository().findAll().forEach(obj -> returnList.add(obj));
        return returnList;
    }

    public abstract CrudRepository<T,id> getRepository();
}
