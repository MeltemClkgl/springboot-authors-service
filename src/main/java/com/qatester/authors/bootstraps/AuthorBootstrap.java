package com.qatester.authors.bootstraps;

import com.qatester.authors.beans.Author;
import com.qatester.authors.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class AuthorBootstrap implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        Author author1=new Author();
        author1.setAuthorBook("Phobia");
        author1.setAuthorName("Wulf Dorn");
        author1.setAuthorBirthday(LocalDate.parse("1969-04-20"));
        author1.setAuthorNationality("Germany");
        authorRepository.save(author1);

        authorRepository.save(Author.builder().authorName("Dan Brown").authorBook("Inferno").authorNationality("United States").authorBirthday(LocalDate.parse("1964-06-22")).build());
        authorRepository.save(new Author(0L,"Chevy Stevens",LocalDate.parse("1973-06-18"),"Canada","Never Let you Go"));
        authorRepository.save(new Author(0L,"Josh Malerman",LocalDate.parse("1975-07-24"),"United States","Unbury Carol"));
        authorRepository.save(new Author(0L,"John Katzenbach",LocalDate.parse("1950-06-23"),"United States","The Club Of Psychopaths"));
        authorRepository.save(new Author("Author6"));




    }
}
