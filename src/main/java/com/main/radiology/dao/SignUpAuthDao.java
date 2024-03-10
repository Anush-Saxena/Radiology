package com.main.radiology.dao;

import com.main.radiology.entities.SignUpAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpAuthDao extends JpaRepository<SignUpAuth, String> {}
