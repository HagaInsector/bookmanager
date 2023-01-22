package com.example.bookmanager.history;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class History {
    private Long id;
    private Long borrowid;
    private String title;  
    private String author;
    private String pubyear;
    private String genre;
    private String owner;
    private String user;
    private String takeout;
    private String due;
    private String returnday;
    private String priority;
    private String unavail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
        
    }
}