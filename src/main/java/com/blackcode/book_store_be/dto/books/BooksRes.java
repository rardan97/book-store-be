package com.blackcode.book_store_be.dto.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BooksRes {
    private Long bookId;

    private String bookTitle;

    private String author;

    private String description;

    private String price;

    private Integer stock;

    private String category;
}
