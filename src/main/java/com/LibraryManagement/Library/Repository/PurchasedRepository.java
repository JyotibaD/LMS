package com.LibraryManagement.Library.Repository;

import com.LibraryManagement.Library.Entity.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PurchasedRepository extends JpaRepository<Purchased,Integer> {

}
