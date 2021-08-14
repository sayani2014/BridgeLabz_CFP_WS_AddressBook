package com.bridgelabz.sayani.addressbook.repository;

import com.bridgelabz.sayani.addressbook.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
