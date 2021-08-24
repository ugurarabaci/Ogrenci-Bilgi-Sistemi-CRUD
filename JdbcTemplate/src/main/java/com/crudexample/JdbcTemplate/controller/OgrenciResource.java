package com.crudexample.JdbcTemplate.controller;

import com.crudexample.JdbcTemplate.dao.OgrenciDAO;
import com.crudexample.JdbcTemplate.model.Ogrenci;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/ogrenci")
public class OgrenciResource {
    private OgrenciDAO ogrenciDAO;

    // http://localhost:8080/ogrenci/helloSpringBoot
    @GetMapping(path = "/helloSpringBoot")
    public String helloSpringBoot() {
        return "hello SpringBoot";
    }

    // http://localhost:8080/ogrenci/getAll
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Ogrenci>> getAll() {
        return new ResponseEntity<>(ogrenciDAO.list(), HttpStatus.OK);
    }

    // http://localhost:8080/ogrenci/getById/{id}
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Ogrenci> getById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(ogrenciDAO.selectById(id), HttpStatus.OK);
    }

    // http://localhost:8080/ogrenci/insert
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody Ogrenci ogrenci) {
        ogrenciDAO.insert(ogrenci);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }

    // http://localhost:8080/ogrenci/deleteById/{id}
    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id) {
        ogrenciDAO.deleteById(id);
        return new ResponseEntity<>("başarılı", HttpStatus.OK);
    }
}