package com.example.redisdemo.dao;

import com.example.redisdemo.model.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerRepository {
    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String idKey);

    void addToProgrammerList(Programmer programmer);

    List<Programmer> getProgrammerList();

    Long getProgrammerListCount();

    void AddToProgrammersSet(Programmer ... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);

    void savePHash(Programmer programmer);

    void updatePHash(Programmer programmer);

    Map<Integer, Programmer> findAllPHash();

    Programmer findPInHash(int id);

    void deletePhash(int id);
}
