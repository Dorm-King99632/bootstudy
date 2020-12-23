package com.dormking.bootstudy.config;

import com.dormking.bootstudy.bean.Position;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @Package: com.dormking.bootstudy.config
 * @ClassName: MyRedisConfig
 * @Author: dormking
 * @CreateTime: 2020/11/21 13:17
 * @Description: 自定义 redis 模板，使用 Jackson 对数据进行序列化而不用 jdk 自带的序列化
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Position> positionRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Position> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Position> serializer = new Jackson2JsonRedisSerializer<>(Position.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    public static void main(String[] args) {
        byte[] data = new byte[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = 51;
        }
        String result = new String(data);
        System.out.println(result);
    }
}
