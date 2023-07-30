package com.muyun.mysqldemo.service;

import com.muyun.mysqldemo.criteria.LogCriteria;
import com.muyun.mysqldemo.entity.Log;
import com.muyun.mysqldemo.mybatis.LogMapper;
import com.muyun.mysqldemo.repository.LogRepository;
import com.muyun.mysqldemo.vo.LogVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    private final LogMapper logMapper;

    public Page<LogVO> list(LogCriteria logCriteria, Pageable pageable) {
        List<LogVO> list = logMapper.findAll(logCriteria, pageable);
        long count = logMapper.count(logCriteria);
        return new PageImpl<>(list, pageable, count);
    }

    public void save(Log log) {
        logRepository.save(log);
    }

}
