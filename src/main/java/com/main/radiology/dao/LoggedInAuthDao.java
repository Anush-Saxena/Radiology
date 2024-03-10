package com.main.radiology.dao;

import com.main.radiology.entities.LogInAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggedInAuthDao extends JpaRepository<LogInAuth, String> {

}
