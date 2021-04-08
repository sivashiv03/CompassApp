package com.compassdev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compassdev.model.CustomerMaster;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerMaster, Long>{
	
}
