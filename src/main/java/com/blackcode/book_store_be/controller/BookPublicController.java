package com.blackcode.book_store_be.controller;

import com.blackcode.book_store_be.dto.books.BooksRes;
import com.blackcode.book_store_be.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/books")
public class BookPublicController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/getBooksListAll")
    public ResponseEntity<List<BooksRes>> getBooksListAll(){
        return ResponseEntity.ok(booksService.getBooksListAll());
    }

    @GetMapping("/getBooksFindById/{id}")
    public ResponseEntity<BooksRes> getBooksFindById(@PathVariable("id") Long id){
        return ResponseEntity.ok(booksService.getBooksFindById(id));
    }


}
