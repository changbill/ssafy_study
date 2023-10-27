package com.ssafy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {
    "com.ssafy.board.model.dao",
    "com.ssafy.user.model.dao",
    "com.ssafy.video.model.dao"
})
public class DBConfig {
}