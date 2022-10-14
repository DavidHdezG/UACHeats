package mx.uach.UACHeats.repository;

import mx.uach.UACHeats.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserRepositoryAPI extends CrudRepository<User, Long> {


}

