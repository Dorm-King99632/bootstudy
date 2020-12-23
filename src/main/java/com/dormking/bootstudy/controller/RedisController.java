package com.dormking.bootstudy.controller;

import com.dormking.bootstudy.bean.Position;
import com.dormking.bootstudy.mapper.PositionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Package: com.dormking.bootstudy.controller
 * @ClassName: RedisController
 * @Author: dormking
 * @CreateTime: 2020/11/27 01:17
 * @Description:
 */

@Controller
@ResponseBody
@Slf4j
public class RedisController {

    @Resource
    PositionMapper positionMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; // 操作字符串

    @Autowired
    RedisTemplate redisTemplate; // 操作 key-value 都是对象

    @Autowired
    RedisTemplate<Object, Position> positionRedisTemplate;

    @GetMapping("/mysqlData")
    public Position getDataFromMysql(){
        Position result = positionMapper.getPositionByName("妹妹");
        log.info("RedisController -- getDataFromMysql:" + result);
        //positionRedisTemplate.opsForValue().set("position-1", result);
        return result;
    }

    @GetMapping("/redisData")
    public Position getDataFromRedis(){
        Position result = positionRedisTemplate.opsForValue().get("position-1");
        log.info("RedisController -- getDataFromRedis:" + result);
        return result;
    }

}
