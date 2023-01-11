package com.example.dobproducer.repository;

import com.example.dobproducer.enitity.EmployeeEnitity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEnitity,Long> {
}
