package com.evdelacruz.samples.beanvalidation.service;

import com.evdelacruz.samples.beanvalidation.service.contract.vo.UserVO;
import javax.validation.Valid;

public interface UserService {

    int add(@Valid UserVO user);
}
