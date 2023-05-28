package com.example.redisdemo.service;

import com.example.redisdemo.dao.ProgrammerRepository;
import com.example.redisdemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    @Autowired
    ProgrammerRepository programmerRepository;
    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        programmerRepository.setProgrammerAsString(idKey,programmer);

    }

    @Override
    public String getProgrammerAsString(String key) {
        return programmerRepository.getProgrammerAsString(key);
    }

    @Override
    public void AddToProgrammersList(Programmer programmer) {
        programmerRepository.addToProgrammerList(programmer);
    }

    @Override
    public List<Programmer> getProgrammersListMembers() {
        return programmerRepository.getProgrammerList();
    }

    @Override
    public Long getProgrammersListCount() {
        return programmerRepository.getProgrammerListCount();
    }

    @Override
    public void AddToProgrammersSet(Programmer... programmers) {
        programmerRepository.AddToProgrammersSet(programmers);
    }

    @Override
    public Set<Programmer> getProgrammersSetMembers() {
        return programmerRepository.getProgrammersSetMembers();
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return programmerRepository.isSetMember(programmer);
    }

    @Override
    public void savePHash(Programmer programmer) {
        programmerRepository.savePHash(programmer);
    }

    @Override
    public void updatePHash(Programmer programmer) {
        programmerRepository.updatePHash(programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllPHash() {
        return programmerRepository.findAllPHash();
    }

    @Override
    public Programmer findPInHash(int id) {
        return programmerRepository.findPInHash(id);
    }

    @Override
    public void deletePhash(int id) {
        programmerRepository.deletePhash(id);
    }
}
