package com.muyun.mysqldemo.repository;

import com.muyun.mysqldemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
