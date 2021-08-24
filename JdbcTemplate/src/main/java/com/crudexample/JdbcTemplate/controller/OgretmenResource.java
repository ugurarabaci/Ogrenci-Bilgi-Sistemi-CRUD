package com.crudexample.JdbcTemplate.controller;

import com.crudexample.JdbcTemplate.dao.OgrenciDAO;
import com.crudexample.JdbcTemplate.dao.OgretmenDAO;
import com.crudexample.JdbcTemplate.model.Ogrenci;
import com.crudexample.JdbcTemplate.model.Ogretmen;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/ogretmen")
public class OgretmenResource {
    private OgretmenDAO ogretmenDAO;

    // http://localhost:8080/ogretmen/helloSpringBoot
    @GetMapping(path = "/helloSpringBoot")
    public String helloSpringBoot() {
        return "hello SpringBoot";
    }

    // http://localhost:8080/ogretmen/getAll
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Ogretmen>> getAll() {
        return new ResponseEntity<>(ogretmenDAO.list(), HttpStatus.OK);
    }


    // http://localhost:8080/ogrenci/insert
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody Ogretmen ogretmen) {
        ogretmenDAO.insert(ogretmen);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }

    // http://localhost:8080/ogrenci/deleteById/{id}
    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id) {
        ogretmenDAO.deleteById(id);
        return new ResponseEntity<>("başarılı", HttpStatus.OK);
    }
    // http://localhost:8080/ogrenci/getById/{id}
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Ogretmen> getById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(ogretmenDAO.selectById(id), HttpStatus.OK);
    }
}