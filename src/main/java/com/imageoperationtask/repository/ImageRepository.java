package com.imageoperationtask.repository;

import com.imageoperationtask.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageData,Long> {
    ImageData findByImageName(String fileName);
}
