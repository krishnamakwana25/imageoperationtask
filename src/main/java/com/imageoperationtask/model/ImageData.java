package com.imageoperationtask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ImageData")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String imageName;
    private String imageType;
    @Lob
    @Column(name = "imageData", length = 1000)
    private byte[] imageData;
}