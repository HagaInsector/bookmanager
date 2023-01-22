package com.example.bookmanager.bookinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookinfoController {
	
	@Autowired
    private BookinfoService service;

    @RequestMapping("/new")
    public String showNewBookinfo(Model model) {
        Bookinfo bookinfo = new Bookinfo();
        model.addAttribute("bookinfo", bookinfo);
        return "/regist_book";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBookinfo(@ModelAttribute("bookinfo") Bookinfo bookinfo) {
        service.save(bookinfo);
        return "redirect:/list";       
    }
    
    @RequestMapping("/before_delete/{id}")
    public ModelAndView showDeletePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("before_delete");
        Bookinfo bookinfo = service.get(id);
        mav.addObject("bookinfo", bookinfo);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteBookinfo(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/list"; 
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Bookinfo bookinfo = service.get(id);
        mav.addObject("bookinfo", bookinfo);
        return mav;
    }
    
    @RequestMapping("/reserve/{id}")
    public ModelAndView showReservePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("reserve");
        Bookinfo bookinfo = service.get(id);
        mav.addObject("bookinfo", bookinfo);
        return mav;
    }
    
    
    @RequestMapping("/cancel/{id}")
    public ModelAndView showCancelReservePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("cancel");
        Bookinfo bookinfo = service.get(id);
        mav.addObject("bookinfo", bookinfo);
        return mav;
    }
    
    @RequestMapping("/unavail/{id}")
    public ModelAndView showUnavailPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("unavail");
        Bookinfo bookinfo = service.get(id);
        mav.addObject("bookinfo", bookinfo);
        return mav;
    }
    
    @RequestMapping("/avail/{id}")
    public ModelAndView showAvailPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("avail");
        Bookinfo bookinfo = service.get(id);
        mav.addObject("bookinfo", bookinfo);
        return mav;
    }
    
    
}