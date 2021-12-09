package com.telgatech.crud.entity;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AccessType;
@Entity
@Table(name = "EMPLOYEE")
@Access(value=AccessType.FIELD)
@Data
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
