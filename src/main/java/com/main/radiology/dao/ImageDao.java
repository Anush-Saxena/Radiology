package com.main.radiology.dao;

import com.main.radiology.entities.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<ImageData, String> {
}
