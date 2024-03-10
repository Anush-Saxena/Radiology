package com.main.radiology.dao;

import com.main.radiology.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignedUserDao extends JpaRepository<UserDetails, String> {

    Optional<UserDetails> findByEmailId(String emailId);

}
