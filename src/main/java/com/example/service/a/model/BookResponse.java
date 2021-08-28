package com.example.service.a.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse implements Serializable {

    private Long id;

    private String title;

    private String author;

    private Integer pagesNumber;

}
