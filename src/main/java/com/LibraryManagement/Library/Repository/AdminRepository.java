package com.LibraryManagement.Library.Repository;

import com.LibraryManagement.Library.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

//    @Query("SELECT u FROM user WHERE u.userName LIKE %:keyword%")
//    public User getUserByName(@Param("keyword") String keyword);

}
