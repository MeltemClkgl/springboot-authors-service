package com.qatester.authors.controllers;

import com.qatester.authors.beans.Author;
import com.qatester.authors.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @GetMapping
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }
    @GetMapping("/{id}")
        public Author getAuthorById(@PathVariable Long id) {
            return authorRepository.findById(id).get();
        }
    @PostMapping(consumes="application/json")
    public List<Author> addAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return authorRepository.findAll();
    }
    @PutMapping(value = "/{id}",consumes = "application/json")
    public List<Author> replaceAuthor(@PathVariable Long id,@RequestBody Author author){
        authorRepository.deleteById(id);
        authorRepository.save(author);
        return authorRepository.findAll();
    }
    @PatchMapping(value="/{id}", consumes = "application/json" )
    public List<Author> updateAuthor(@PathVariable Long id, @RequestBody Author newAuthor)
    {
        Author activeAuthor = authorRepository.findById(id).get();

        activeAuthor.setAuthorBook(newAuthor.getAuthorBook());


        authorRepository.save(activeAuthor);
        return authorRepository.findAll();
    }
    @DeleteMapping(value = "/{id}")
    public List<Author> deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
        return authorRepository.findAll();
    }

    @DeleteMapping()
    public List<Author> deleteAllAuthors(){
        authorRepository.deleteAll();
        return authorRepository.findAll();
    }









}
