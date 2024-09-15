package org.example.swp391.repository;

import org.example.swp391.entity.Account;
import org.example.swp391.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByAccount(Account account);
}
