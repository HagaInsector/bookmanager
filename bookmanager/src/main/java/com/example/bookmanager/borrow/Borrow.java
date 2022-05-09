package com.example.bookmanager.borrow;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Borrow {

    private Long borrowid;
    private Integer id;
    private String user;
    private String takeout;
    private String due;
    private String returnday;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getBorrowid() {
        return borrowid;
    }
  
}