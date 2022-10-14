package mx.uach.UACHeats.service.impl;

import mx.uach.UACHeats.commons.GenericServiceImpl;
import mx.uach.UACHeats.model.User;
import mx.uach.UACHeats.repository.UserRepositoryAPI;
import mx.uach.UACHeats.service.api.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserServiceAPI {
    @Autowired
    private UserRepositoryAPI userRepositoryAPI;

    @Override
    public CrudRepository<User, Long> getRepository() {
        return userRepositoryAPI;
    }
}
