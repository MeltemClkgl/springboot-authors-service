package com.qatester.authors.beans;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorID;
    @NonNull
    private String authorName;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate authorBirthday;
    private String authorNationality;
    private String authorBook;

}
