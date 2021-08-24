package com.crudexample.JdbcTemplate.controller;


import com.crudexample.JdbcTemplate.dao.DersOgrenciDAO;
import com.crudexample.JdbcTemplate.model.DersOgrenci;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/dersOgrenci")
public class DersOgrenciResource {
    private DersOgrenciDAO dersogrenciDAO;

    // http://localhost:8080/konu/helloSpringBoot
    @GetMapping(path = "/helloSpringBoot")
    public String helloSpringBoot() {
        return "hello SpringBoot";
    }

    // http://localhost:8080/ders/getAll
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<DersOgrenci>> getAll() {
        return new ResponseEntity<>(dersogrenciDAO.list(), HttpStatus.OK);
    }

    // http://localhost:8080/ders/getById/{id}
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<DersOgrenci> getById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(dersogrenciDAO.selectById(id), HttpStatus.OK);
    }

    // http://localhost:8080/ders/insert
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody DersOgrenci dersOgrenci) {
        dersogrenciDAO.insert(dersOgrenci);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }

    // http://localhost:8080/ders/deleteById/{id}
    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id) {
        dersogrenciDAO.deleteById(id);
        return new ResponseEntity<>("başarılı", HttpStatus.OK);
    }

}