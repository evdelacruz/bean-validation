package com.evdelacruz.samples.beanvalidation.dist.rest;

import com.evdelacruz.samples.beanvalidation.service.UserService;
import com.evdelacruz.samples.beanvalidation.service.contract.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/users")
public class UserController {
    private @Autowired UserService userService;

    public UserController() {}

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserVO user) {
        return created(fromCurrentRequest().path("/{id}").buildAndExpand(userService.add(user)).toUri()).build();
    }
}
