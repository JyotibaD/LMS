package com.LibraryManagement.Library.Repository;

import com.LibraryManagement.Library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

//    @Query("SELECT b FROM book WHERE b.bookName LIKE %:keyword%")
//    public Book getBookByName(@Param("keyword") String keyword);

}
