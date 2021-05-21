package com.compassdev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compassdev.model.StreamProcessLookup;

@Repository
public interface LookUpRepository extends JpaRepository<StreamProcessLookup, Integer>{
	
	//<StreamProcessLookup> getProcessByStream(String streamName);

}
