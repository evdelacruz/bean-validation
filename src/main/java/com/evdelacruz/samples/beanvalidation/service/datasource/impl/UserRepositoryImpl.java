package com.evdelacruz.samples.beanvalidation.service.datasource.impl;

import com.evdelacruz.samples.beanvalidation.service.datasource.UserRepository;
import com.evdelacruz.samples.beanvalidation.service.datasource.domain.User;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    private Map<Integer, User> collection;
    private int counter;

    public UserRepositoryImpl() {
        collection = new ConcurrentHashMap<>(20);
        counter = 0;
    }

    @Override
    public synchronized User save(User product) {
        int id = this.sequence();
        product.setId(id);
        collection.put(id, product);
        return product;
    }

    @Override
    public synchronized boolean delete(int id) {
        return collection.remove(id) != null;
    }

    @Override
    public synchronized boolean existUsername(String username) {
        return collection.values().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public synchronized Optional<User> find(int id) {
        return collection.values().stream().filter(product -> id == product.getId()).findAny();
    }

    @Override
    public synchronized Stream<User> findAll() {
        return  collection.values().stream();
    }

    //<editor-fold desc="Support methods">
    private int sequence() {
        return ++counter;
    }
    //</editor-fold>
}
