package com.main.radiology.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {

    @Id
    private String imageId;
    private String imageUrl;
    private String userId;

    @CreationTimestamp
    private Timestamp time;
}
