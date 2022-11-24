package com.jpapractice1123.jpapractice.domain.dto;

import com.jpapractice1123.jpapractice.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String authorName;

    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(book.getAuthor().getName())
                .build();
    }
}