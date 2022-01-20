package com.tuanbaol.redis.controller;

import com.tuanbaol.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/getValue/{key}")
    public Object getValue(@PathVariable String key) {
        return redisService.getValue(key);
    }

    @PostMapping("/setValue/{key}/{value}")
    public Object getValue(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisService.setValue(key, value);
        return "success";
    }

    @DeleteMapping("/deleteValue/{key}")
    public Object deleteValue(@PathVariable String key) {
        return redisService.delete(key);
    }
}
