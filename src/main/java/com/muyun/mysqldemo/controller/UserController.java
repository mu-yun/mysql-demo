package com.muyun.mysqldemo.controller;

import com.muyun.mysqldemo.entity.User;
import com.muyun.mysqldemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/test")
    public List<User> find() {
        return userRepository.findAllByNativeSql();
    }

    @GetMapping(params = "id")
    public List<User> findByIds(@RequestParam("id") Collection<Long> ids) {
        if (ids.size() == 1 && ids.contains(0L)) {
            List<User> users1 = userRepository.findAllById(Collections.emptySet());
            List<User> users2 = userRepository.findAllByIdIn(Collections.emptySet());
            List<User> users3 = userRepository.findAllByIdsNativeSql(Collections.emptySet());
            return Collections.emptyList();
        }
        return userRepository.findAllByIdsNativeSql(ids);
    }


}
