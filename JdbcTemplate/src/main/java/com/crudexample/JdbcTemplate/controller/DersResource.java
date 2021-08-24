package com.crudexample.JdbcTemplate.controller;

import com.crudexample.JdbcTemplate.dao.OgrenciDAO;
import com.crudexample.JdbcTemplate.model.Ogrenci;
import com.crudexample.JdbcTemplate.dao.DersDAO;
import com.crudexample.JdbcTemplate.model.Ders;
import com.crudexample.JdbcTemplate.model.Konu;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/ders")
public class DersResource {
    private DersDAO dersDAO;

    // http://localhost:8080/konu/helloSpringBoot
    @GetMapping(path = "/helloSpringBoot")
    public String helloSpringBoot() {
        return "hello SpringBoot";
    }

    // http://localhost:8080/ders/getAll
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Ders>> getAll() {
        return new ResponseEntity<>(dersDAO.list(), HttpStatus.OK);
    }

    // http://localhost:8080/ders/getById/{id}
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Ders> getById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(dersDAO.selectById(id), HttpStatus.OK);
    }

    // http://localhost:8080/ders/insert
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody Ders ders) {
        dersDAO.insert(ders);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }

    // http://localhost:8080/ders/deleteById/{id}
    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id) {
        dersDAO.deleteById(id);
        return new ResponseEntity<>("başarılı", HttpStatus.OK);
    }
}