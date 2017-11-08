package com.evdelacruz.samples.beanvalidation.service.datasource;

import com.evdelacruz.samples.beanvalidation.service.datasource.domain.User;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository {

    User save(User product);

    boolean delete(int id);

    boolean existUsername(String username);

    Optional<User> find(int id);

    Stream<User> findAll();
}
