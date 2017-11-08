package com.evdelacruz.samples.beanvalidation.service.contract.vo.map;

import com.evdelacruz.samples.beanvalidation.service.contract.vo.UserVO;
import com.evdelacruz.samples.beanvalidation.service.datasource.domain.User;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserVO2User {
    UserVO2User INSTANCE = Mappers.getMapper(UserVO2User.class);

    @Mapping(target="id", ignore=true)
    User bind(UserVO source);
}
