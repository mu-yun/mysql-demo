package com.muyun.mysqldemo.controller;

import com.muyun.mysqldemo.entity.User;
import com.muyun.mysqldemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


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

    @GetMapping( "/{id}")
    public Optional<User> findByIds(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User findByIds(@RequestBody User user) {
        return userRepository.save(user);
    }



}
