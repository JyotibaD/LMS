package com.LibraryManagement.Library.Repository;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT u FROM user WHERE u.userName LIKE %:keyword%")
//    public User getUserByName(@Param("keyword") String keyword);

}
