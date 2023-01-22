package com.example.bookmanager.booklist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
    @Autowired
    private BookService service;

    @RequestMapping("/list")
    public String viewHomePage(Model model) {
        List<Book> listBooks = service.listAll();
        model.addAttribute("listBooks", listBooks);

        return "/list";   
    }
    
    @RequestMapping("/detail/{id}")
    public ModelAndView showDetailPage2(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("detail");
        Book book = service.get(id);
        mav.addObject("book", book);

        return mav;
    }
   
}