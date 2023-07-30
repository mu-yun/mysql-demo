package com.muyun.mysqldemo.mybatis;

import com.muyun.mysqldemo.criteria.LogCriteria;
import com.muyun.mysqldemo.vo.LogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Mapper
public interface LogMapper {

    List<LogVO> findAll(@Param("logCriteria") LogCriteria logCriteria, @Param("pageable") Pageable pageable);

    long count(@Param("logCriteria") LogCriteria logCriteria);

}