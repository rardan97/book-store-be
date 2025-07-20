package com.blackcode.book_store_be.controller.public_controller;

import com.blackcode.book_store_be.dto.books.BooksRes;
import com.blackcode.book_store_be.service.BooksService;
import com.blackcode.book_store_be.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/public/books")
public class BookPublicController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private FileStorageService storageService;

    @GetMapping("/getBooksListAll")
    public ResponseEntity<List<BooksRes>> getBooksListAll(){
        return ResponseEntity.ok(booksService.getBooksPublicListAll());
    }

    @GetMapping("/getBooksFindById/{id}")
    public ResponseEntity<BooksRes> getBooksFindById(@PathVariable("id") Long id){
        return ResponseEntity.ok(booksService.getBooksFindById(id));
    }

    @GetMapping("/images/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        try {
            byte[] image = storageService.load(filename);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Image not found: " + filename + ". Returning fallback.");

            try {
                InputStream fallbackStream = getClass().getResourceAsStream("/static/default.jpg");
                if (fallbackStream == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                byte[] fallbackImage = fallbackStream.readAllBytes();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG);
                return new ResponseEntity<>(fallbackImage, headers, HttpStatus.OK);
            } catch (IOException ex) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }


}
