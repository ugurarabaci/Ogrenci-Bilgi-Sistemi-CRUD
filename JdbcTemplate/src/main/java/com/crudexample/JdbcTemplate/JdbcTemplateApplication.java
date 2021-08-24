package com.crudexample.JdbcTemplate;

import com.crudexample.JdbcTemplate.dao.DAO;
import com.crudexample.JdbcTemplate.dao.OgretmenDAO;
import com.crudexample.JdbcTemplate.model.Ogrenci;
import com.crudexample.JdbcTemplate.model.Ogretmen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JdbcTemplateApplication {
    private static DAO<Ogretmen> dao;

    public JdbcTemplateApplication(DAO<Ogretmen> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateApplication.class, args);
        List<Ogretmen> ogretmenler = dao.list();
        ogretmenler.forEach(System.out::println);
        //dao.deleteById(6);
        Ogretmen ogr = new Ogretmen(1,"1");
        //dao.insert(ogr);

    }

}
