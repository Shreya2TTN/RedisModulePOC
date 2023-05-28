package com.example.redisdemo.service;

import com.example.redisdemo.model.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerService {
    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String key);

    void AddToProgrammersList(Programmer programmer);

    List<Programmer> getProgrammersListMembers();

    Long getProgrammersListCount();

    void AddToProgrammersSet(Programmer ... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);


    // Hash
    void savePHash(Programmer programmer);

    void updatePHash(Programmer programmer);

    Map<Integer, Programmer> findAllPHash();

    Programmer findPInHash(int id);

    void deletePhash(int id);

}
