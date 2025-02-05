package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    // 생성자를 통해 BookService를 주입받음 (DI - Dependency Injection)
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // "/books" URL을 요청하면 엑셀 데이터에서 도서 목록을 가져와 화면에 표시
    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookService.getBooksFromExcel(); // 엑셀에서 도서 목록 가져오기
        model.addAttribute("books", books); // books 데이터를 HTML로 전달
        return "books"; // templates/books.html을 찾아서 렌더링
    }
}
