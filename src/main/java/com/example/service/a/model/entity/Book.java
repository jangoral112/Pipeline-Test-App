package com.example.service.a.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer pagesNumber;
}
