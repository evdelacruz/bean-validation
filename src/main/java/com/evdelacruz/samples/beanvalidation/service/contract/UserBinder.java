package com.evdelacruz.samples.beanvalidation.service.contract;

import com.evdelacruz.samples.beanvalidation.service.contract.vo.UserVO;
import com.evdelacruz.samples.beanvalidation.service.contract.vo.map.UserVO2User;
import com.evdelacruz.samples.beanvalidation.service.datasource.domain.User;

public final class UserBinder {

    static public User bind(UserVO source) {
        return UserVO2User.INSTANCE.bind(source);
    }

    private UserBinder() {
        throw new AssertionError("No instances of 'UserBinder' for you !!!");
    }
}
