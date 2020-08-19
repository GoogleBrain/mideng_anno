package cn.k.mideng_anno.controller;

import cn.k.mideng_anno.anno.Token;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class TestMiDeng {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 生成token
     * @return
     */
    @RequestMapping("/getToken")
    public String createToken() {

        String token = UUID.randomUUID().toString().replace("-", "");

        redisTemplate.opsForValue().set(token, token);
        redisTemplate.expire(token, 1000, TimeUnit.SECONDS);

        return token;
    }

    /**
     * 保证了幂等性
     */
    @Token
    @RequestMapping("/testToken")
    public String testToken(HttpServletRequest request){
        return "当前时间>>>"+new Date();
    }

    @RequestMapping("/testToken2")
    public String testToken2(HttpServletRequest request){
        return "当前时间2>>>"+new Date();
    }
}
