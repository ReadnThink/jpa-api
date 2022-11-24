package com.jpapractice1123.jpapractice.repository;

import com.jpapractice1123.jpapractice.domain.entity.Book;
import com.jpapractice1123.jpapractice.service.BookService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
