package com.main.radiology.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessedData {

    @Id
    private String dataId;
    private String userId;
    private String data;

    @CreationTimestamp
    private Timestamp time;
}
