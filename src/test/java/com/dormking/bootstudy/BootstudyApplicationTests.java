package com.dormking.bootstudy;

import com.dormking.bootstudy.bean.Position;
import com.dormking.bootstudy.mapper.PositionMapper;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class BootstudyApplicationTests {

    @Resource
    PositionMapper positionMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; // 操作字符串

    @Autowired
    RedisTemplate redisTemplate; // 操作 key-value 都是对象

    @Autowired
    RedisTemplate<Object, Position> positionRedisTemplate;

    @Test
    void contextLoads() {
        System.out.println(positionMapper.getPositionByName("妹妹"));
    }

    /**
     * Redis 常见5大操作类型
     * String List Set Hash ZSet(有序集合)
     * stringRedisTemplate.opsForValue() ----- String
     * stringRedisTemplate.opsForHash() ------ Hash
     * stringRedisTemplate.opsForList() ------ List
     * stringRedisTemplate.opsForSet() ------ Set
     * stringRedisTemplate.opsForZSet() ------ ZSet
     */
    @Test
    void testRedis(){
//        stringRedisTemplate.opsForValue().append("msg", "Hello");
        String result = stringRedisTemplate.opsForValue().get("msg");
        Position position = positionRedisTemplate.opsForValue().get("position-1");
        System.out.println(result);
        System.out.println(position);
    }

    // Redis 保存对象
    @Test
    void testRedisSaveObject(){
        Position position = positionMapper.getPositionByName("妹妹");
        // 使用 jdk序列化机制，序列化之后的数据保存至 redis，需首先实现 Serializable 接口
        //redisTemplate.opsForValue().set("position-1", position);

        //将数据以 json 形式保存，redisTemplate 默认的序列化规则是 jdk 自带的，需在 config 包下，自定义序列化规则
        positionRedisTemplate.opsForValue().set("position-1", position);
    }

}
