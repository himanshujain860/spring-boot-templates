package com.app.repository;

import java.util.Map;

import com.app.model.Entry;

public interface RedisRepository {

    /**
     * Return all Entries
     */
    Map<Object, Object> findAllEntries();

    /**
     * Add key-value pair to Redis.
     */
    void add(Entry entry);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);
    
    /**
     * find a entry
     */
    Entry findEntry(String id);
    
}
