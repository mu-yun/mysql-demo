package com.muyun.mysqldemo.repository;

import com.muyun.mysqldemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from user")
    List<User> findAllByNativeSql();

    @Query(nativeQuery = true, value = "select * from user where id in (:ids)")
    List<User> findAllByIdsNativeSql(Collection<Long> ids);

    List<User> findAllByIdIn(Collection<Long> ids);
}
