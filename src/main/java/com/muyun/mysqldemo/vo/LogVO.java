package com.muyun.mysqldemo.vo;

import com.muyun.mysqldemo.entity.Log;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class LogVO extends Log {

    private String username;

    private String name;
}
