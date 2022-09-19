package com.example.bookkeepingsys.controller;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Author;
import com.example.bookkeepingsys.pojo.AuthorPojo;
import com.example.bookkeepingsys.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("author/")
public class AuthorController extends ApiResponse {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("getAllAuthor")
    public ApiResponse getAllAuthor()
    {
        return authorService.totalAuthor();
    }

    @PostMapping("addAuthor")
    public ApiResponse addAuthor(@RequestBody @Valid AuthorPojo authorPojo)
    {
        return authorService.addAuthor(authorPojo);

    }
}
