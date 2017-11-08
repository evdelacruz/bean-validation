package com.evdelacruz.samples.beanvalidation.service.impl;

import com.evdelacruz.samples.beanvalidation.service.UserService;
import com.evdelacruz.samples.beanvalidation.service.contract.vo.UserVO;
import com.evdelacruz.samples.beanvalidation.service.datasource.UserRepository;
import com.evdelacruz.samples.beanvalidation.util.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import static com.evdelacruz.samples.beanvalidation.service.contract.UserBinder.*;

@Service("userService")
public class UserServiceImpl implements UserService {
    private @Autowired UserRepository userRepository;

    public UserServiceImpl() {}

    @Override
    public int add(UserVO user) {
        return userRepository.save(bind(user)).getId();
    }
}
