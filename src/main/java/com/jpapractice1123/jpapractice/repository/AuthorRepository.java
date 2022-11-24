package com.jpapractice1123.jpapractice.repository;

import com.jpapractice1123.jpapractice.domain.entity.Author;
import com.jpapractice1123.jpapractice.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
