package com.main.radiology.dao;

import com.main.radiology.entities.ProcessedData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedDataDao extends JpaRepository<ProcessedData, String> {
}
