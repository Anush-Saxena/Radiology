package com.main.radiology.dao;

import com.main.radiology.entities.SignUpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<SignUpDetails, String> {}
