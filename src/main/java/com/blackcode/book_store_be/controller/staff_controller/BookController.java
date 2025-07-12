package com.blackcode.book_store_be.controller.staff_controller;

import com.blackcode.book_store_be.dto.books.BooksReq;
import com.blackcode.book_store_be.dto.books.BooksRes;
import com.blackcode.book_store_be.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff/books")
public class BookController {

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

    @PostMapping("/addBooks")
    public ResponseEntity<BooksRes> addBooks(@RequestBody BooksReq booksReq){
        return ResponseEntity.ok(booksService.addBooks(booksReq));
    }

    @PutMapping("/updateBooks/{id}")
    public ResponseEntity<BooksRes> updateBooks(@PathVariable("id") Long id, @RequestBody BooksReq booksReq){
        return ResponseEntity.ok(booksService.updateBook(id, booksReq));
    }

    @DeleteMapping("/deleteBooksById/{id}")
    public ResponseEntity<String> deleteBooksById(@PathVariable("id") Long id){
        String rtn = booksService.deleteBook(id);
        return ResponseEntity.ok(rtn);
    }




}
