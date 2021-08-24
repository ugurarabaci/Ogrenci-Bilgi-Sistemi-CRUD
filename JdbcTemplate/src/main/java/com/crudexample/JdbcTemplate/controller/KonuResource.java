package com.crudexample.JdbcTemplate.controller;

import com.crudexample.JdbcTemplate.dao.DAO;
import com.crudexample.JdbcTemplate.dao.KonuDAO;
import com.crudexample.JdbcTemplate.dao.OgrenciDAO;
import com.crudexample.JdbcTemplate.model.Konu;
import com.crudexample.JdbcTemplate.model.Ogrenci;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/konu")
public class KonuResource {
    private KonuDAO konuDAO;

    // http://localhost:8080/konu/helloSpringBoot
    @GetMapping(path = "/helloSpringBoot")
    public String helloSpringBoot() {
        return "hello SpringBoot";
    }

    // http://localhost:8080/konu/getAll
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Konu>> getAll() {
        return new ResponseEntity<>(konuDAO.list(), HttpStatus.OK);
    }

    // http://localhost:8080/konu/getById/{id}
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Konu> getById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(konuDAO.selectById(id), HttpStatus.OK);
    }

    // http://localhost:8080/konu/insert
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody Konu konu) {
        konuDAO.insert(konu);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }

    // http://localhost:8080/konu/deleteById/{id}
    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id) {
        konuDAO.deleteById(id);
        return new ResponseEntity<>("başarılı", HttpStatus.OK);
    }
}