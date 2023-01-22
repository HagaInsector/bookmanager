package com.example.bookmanager.booklist;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> listAll() {
        return repo.findAll();
    }

    public Book get(long id) {
        return repo.findById(id).get();
        
    }
    
    public void save(Book book) {
        repo.save(book);
    }
  

}