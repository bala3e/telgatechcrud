package com.telgatech.crud.repository;
import com.telgatech.crud.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TelgaRepository extends JpaRepository<Employee,Integer> {
    
}
