package com.compassdev.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.compassdev.model.StreamProcessLookup;

public class LookUpRepositoryImpl  {
	/*
	 * @Autowired private EntityManager entityManager;
	 * 
	 * @Override public List<StreamProcessLookup> getProcessByStream(String
	 * streamName) { Session currentSession = entityManager.unwrap(Session.class);
	 * List<StreamProcessLookup> processList =
	 * currentSession.createNativeQuery("SELECT stream_code, process_name" +
	 * "	FROM stream_process_lookup where stream_code="+streamName).list();
	 * return processList; }
	 */
}
