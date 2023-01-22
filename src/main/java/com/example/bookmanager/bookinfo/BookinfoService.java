package com.example.bookmanager.bookinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookinfoService {

    @Autowired
    private BookinfoRepository repo;


    public void save(Bookinfo bookinfo) {
        repo.save(bookinfo);
    }
    
    public void delete(long id) {
        repo.deleteById(id);
    }

    public Bookinfo get(long id) {
        return repo.findById(id).get();
    }
    
    @Transactional
    public void update(Bookinfo bookinfo) {
        repo.save(bookinfo);
    }
}