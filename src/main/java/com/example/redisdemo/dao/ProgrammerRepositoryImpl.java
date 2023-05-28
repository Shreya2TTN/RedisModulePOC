package com.example.redisdemo.dao;

import com.example.redisdemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository{

    public static final String Redis_List_Key = "ProgrammerList";
    public static final String Redis_SET_Key = "ProgrammerSet";
    public static final String Redis_HASH_Key = "ProgrammerSet";



    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    @Qualifier("ListOperations")
    private ListOperations<String, Programmer> listOps;

    @Autowired
    @Qualifier("setOperations")
    private SetOperations<String, Programmer> setOps;

    @Autowired

    @Qualifier("HashOperations")
    public HashOperations<String, Integer, Programmer> hashOps;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        redisTemplate.opsForValue().set(idKey, programmer);
        redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);

    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return (String) redisTemplate.opsForValue().get(idKey);
    }

    @Override
    public void addToProgrammerList(Programmer programmer) {
        listOps.leftPush(Redis_List_Key, programmer);
    }

    @Override
    public List<Programmer> getProgrammerList() {
        return listOps.range(Redis_List_Key,0,-1);
    }

    @Override
    public Long getProgrammerListCount() {
        return listOps.size(Redis_List_Key);
    }

    @Override
    public void AddToProgrammersSet(Programmer... programmers) {
        setOps.add(Redis_SET_Key,programmers);
    }

    @Override
    public Set<Programmer> getProgrammersSetMembers() {
        return setOps.members(Redis_SET_Key);
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return setOps.isMember(Redis_SET_Key,programmer);
    }

    @Override
    public void savePHash(Programmer programmer) {
        hashOps.put(Redis_HASH_Key, programmer.getId(),programmer);

    }

    @Override
    public void updatePHash(Programmer programmer) {
        hashOps.put(Redis_HASH_Key, programmer.getId(),programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllPHash() {
        return hashOps.entries(Redis_HASH_Key);
    }

    @Override
    public Programmer findPInHash(int id) {
        return hashOps.get(Redis_HASH_Key,id);
    }

    @Override
    public void deletePhash(int id) {
        hashOps.delete(Redis_HASH_Key,id);
    }
}
