package com.app.repository;

import com.app.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import javax.annotation.PostConstruct;

@Repository
public class RedisRepositoryImpl implements RedisRepository {

    private static final String KEY = "Entry";
    
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    
    public void add(final Entry entry) {
        hashOperations.put(KEY, entry.getKey(), entry.getValue());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }
    
    public Entry findEntry(final String id){
        return (Entry) hashOperations.get(KEY, id);
    }
    
    public Map<Object, Object> findAllEntries(){
        return hashOperations.entries(KEY);
    }

}
