package com.telgatech.crud.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.telgatech.crud.entity.Employee;
import com.telgatech.crud.repository.TelgaRepository;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
@Service
public class TelgaService{
    private static Logger logger = LoggerFactory.getLogger(TelgaService.class);

    @Autowired
    private TelgaRepository telgaRepository;
    
    
    public ResponseEntity<List<Employee>> getAllEmployee() {
        try{
         
         return new ResponseEntity<>(telgaRepository.findAll(),HttpStatus.OK);
        }catch(Exception e){
           logger.error("Excetion at getAllEmployee ", e);
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        
        try{
          Employee addEmp = telgaRepository.save(emp);
          return new ResponseEntity<>(addEmp,HttpStatus.OK);
        }catch(Exception e){
            logger.error("Excetion at addemployee ", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee emp){
        
        try{
            Optional<Employee> empData = telgaRepository.findById(id);
            if(empData.isPresent()){
                Employee tmpEmp = empData.get();
                tmpEmp.setName(emp.getName());
                Employee addEmp = telgaRepository.save(tmpEmp);
                return new ResponseEntity<>(addEmp,HttpStatus.OK);
               }else{
                    return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
                }
            }catch(Exception e){
                logger.error("Excetion at addemployee ", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id) {
        
		try {
			telgaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
            logger.error("Excetion at removeemployee ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}