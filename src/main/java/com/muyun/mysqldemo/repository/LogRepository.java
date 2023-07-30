package com.muyun.mysqldemo.repository;

import com.muyun.mysqldemo.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LogRepository extends JpaRepository<Log, Long> {

}
