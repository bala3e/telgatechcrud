package com.telgatech.crud.controller;

import java.util.List;


import com.telgatech.crud.entity.Employee;

import com.telgatech.crud.service.TelgaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TelgaController {
    private static Logger logger = LoggerFactory.getLogger(TelgaController.class);

    @Autowired
    private TelgaService service;
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        logger.info("Last accessed URL {} /getAllEmployee");
        return service.getAllEmployee();
    }

    @PostMapping(path = "/addemployee",consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        logger.info("Last accessed URL {} /addEmployee");
        return service.addEmployee(emp);
    }

    @PutMapping(value = "/updateemployee/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee emp){
        logger.info("Last accessed URL {} /updateemployee");
        return service.updateEmployee(id, emp);
    }

    @DeleteMapping("/removeemployee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id) {
        logger.info("Last accessed URL {} /removeemployee");
		return service.deleteEmployee(id);
	}

}
