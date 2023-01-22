package com.example.bookmanager.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookmanager.booklist.Book;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    private JdbcTemplate jdbcTemplate;

    //コンストラクタ
    @Autowired
    public BorrowController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@ModelAttribute Borrow borrow,@ModelAttribute Book book, @PathVariable int id) {
        return "borrow/borrow";
    }

    @PostMapping("/borrow/{id}")
    public String borrowsave(Borrow Borrow, @PathVariable int id) {
        String sql = "INSERT INTO borrow(id, user, takeout, due) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, Borrow.getId(), Borrow.getUser(),Borrow.getTakeout(),Borrow.getDue());
        return "redirect:/list";
    }
    
    @GetMapping("/return/{id}")
    public String returnview(@ModelAttribute Borrow borrow,@ModelAttribute Book book, @PathVariable int id) {
        return "borrow/return";
    }

    @PostMapping("/return/{id}")
    public String retrunsave(Borrow Borrow, @PathVariable int id) {
        String sql = "INSERT INTO borrow(id,returnday) VALUES(?, ?)";
        jdbcTemplate.update(sql, Borrow.getId(), Borrow.getReturnday());
        return "redirect:/list";
    }
}
