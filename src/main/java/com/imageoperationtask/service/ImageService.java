package com.imageoperationtask.service;

import com.imageoperationtask.model.ImageData;
import com.imageoperationtask.repository.ImageRepository;
import com.imageoperationtask.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = imageRepository.save(ImageData.builder()
                        .imageName(file.getOriginalFilename())
                        .imageType(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).build());/*file.getBytes()).build();*/

        if(imageData != null){
            return "File Uploaded Successfully :"+file.getOriginalFilename();
        }
        return null;
    }

   public byte[] downloadImage(String fileName){
       ImageData imageData = imageRepository.findByImageName(fileName);
       byte[]  images = ImageUtils.decompressImage(imageData.getImageData());
       return images;
    }
}
