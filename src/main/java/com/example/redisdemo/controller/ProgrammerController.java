package com.example.redisdemo.controller;
import com.example.redisdemo.service.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.redisdemo.model.Programmer;

@RestController
public class ProgrammerController {
    @Autowired
    ProgrammerService programmerService;


    @PostMapping("/programmer-string")
    public ResponseEntity<?> addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
                mapper.writeValueAsString(programmer));
        return ResponseEntity.ok("Programmer is Added Successfully");

    }


    @GetMapping("/programmer-string/{id}")
    public ResponseEntity<?> readString(@PathVariable String id) {
        return new ResponseEntity<>(programmerService.getProgrammerAsString(id), HttpStatus.OK);

    }


    @PostMapping("/programmer-list")
    public ResponseEntity<?> addInProgrammerList(@RequestBody Programmer programmer) {
        programmerService.AddToProgrammersList(programmer);
        return ResponseEntity.ok("Programmer id added successfully");

    }

    @GetMapping("/programmer-list")
    public ResponseEntity<?> getProgrammerList() {
        return new ResponseEntity<>(programmerService.getProgrammersListMembers(), HttpStatus.OK);

    }

    @GetMapping("/programmer-list/count")
    public ResponseEntity<?> getProgrammerListCount() {
        return new ResponseEntity<>(programmerService.getProgrammersListCount(), HttpStatus.OK);

    }

    @PostMapping("/programmer-set")
    public ResponseEntity<?> addInProgrammerSet(@RequestBody Programmer... programmers) {
        programmerService.AddToProgrammersSet(programmers);
        return ResponseEntity.ok("Programmer is added successfully");

    }


    @GetMapping("/programmer-set")
    public ResponseEntity<?> getProgrammerSet() {
        return new ResponseEntity<>(programmerService.getProgrammersSetMembers(), HttpStatus.OK);

    }

    @PostMapping("/programmer-set/member")
    public ResponseEntity<?> addInProgrammerSet(@RequestBody Programmer programmer) {
        boolean isMember= programmerService.isSetMember(programmer);
        if (!isMember) {
            return ResponseEntity.ok("Not a Member");
        }
        return ResponseEntity.ok( "Member");

    }

    /*  @PostMapping("/programmer-hash")
      public ResponseEntity<?> addInProgrammerHash(@RequestBody Programmer programmer) {
          programmerService.savePHash(programmer);
          return ResponseEntity.ok("Programmer is added successfully");

      }*/
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-hash")
    public void savePHash(@RequestBody Programmer programmer) {
        programmerService.savePHash(programmer);

    }

    @PutMapping("/programmer-hash")
    public ResponseEntity<?> updateProgrammerHash(@RequestBody Programmer programmer) {
        programmerService.updatePHash(programmer);
        return ResponseEntity.ok("Programmer is added successfully");

    }

    @GetMapping("/programmer-hash")
    public ResponseEntity<?> getProgrammerHash() {
        return new ResponseEntity<>(programmerService.findAllPHash(), HttpStatus.OK);

    }

    @GetMapping("/programmer-hash/{id}")
    public ResponseEntity<?> getProgrammerHash(@PathVariable int id) {
        return new ResponseEntity<>(programmerService.findPInHash(id), HttpStatus.OK);

    }

    @DeleteMapping("/programmer-hash/{id}")
    public ResponseEntity<?> deleteAProgrammer(@PathVariable int id) {
        programmerService.deletePhash(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

    }

}
