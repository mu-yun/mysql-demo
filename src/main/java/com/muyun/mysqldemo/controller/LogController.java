package com.muyun.mysqldemo.controller;

import com.muyun.mysqldemo.criteria.LogCriteria;
import com.muyun.mysqldemo.service.LogService;
import com.muyun.mysqldemo.vo.LogVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/log")
public class LogController {

    private final LogService logService;

    @GetMapping
    public Page<LogVO> list(LogCriteria logCriteria, @PageableDefault Pageable pageable) {
        return logService.list(logCriteria, pageable);
    }

}
