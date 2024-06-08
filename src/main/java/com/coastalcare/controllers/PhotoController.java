package com.coastalcare.controllers;

import com.coastalcare.dto.photo.PhotoClassificationCountDTO;
import com.coastalcare.dto.photo.PhotoDetailsDTO;
import com.coastalcare.dto.photo.UploadPhotoDTO;
import com.coastalcare.models.Photo;
import com.coastalcare.models.enums.ClassificationPhoto;
import com.coastalcare.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @PostMapping
    public ResponseEntity<PhotoDetailsDTO> upload(
            @RequestParam("userId") Long userId,
            @RequestParam("beachId") Long beachId,
            @RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam("classification") ClassificationPhoto classification,
                                                  UriComponentsBuilder uri){
        Photo photo = photoService.upload(new UploadPhotoDTO(userId, beachId, classification), imageFile);
        var url = uri.path("/photos/{photo_id}").buildAndExpand(photo.getId()).toUri();
        return ResponseEntity.created(url).body(new PhotoDetailsDTO(photo));
    }

    @GetMapping
    public ResponseEntity<Page<PhotoDetailsDTO>> findAll(Pageable page){
        var photoList = photoService.getAll(page);
        return ResponseEntity.ok(photoList);
    }

    @GetMapping("/{photo_id}")
    public ResponseEntity<PhotoDetailsDTO> findOne(@PathVariable("photo_id") Long photoId){
        Photo photo = photoService.getOne(photoId);
        return ResponseEntity.ok(new PhotoDetailsDTO(photo));
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<Page<PhotoDetailsDTO>> findAllUserPhotos(@PathVariable("user_id") Long userId,
                                                             Pageable page){
        var userPhotos = photoService.getAllUserPhotos(userId, page);
        return ResponseEntity.ok(userPhotos);
    }

    @GetMapping("/beaches/{beach_id}")
    public ResponseEntity<Page<PhotoDetailsDTO>> findAllBeachPhotos(@PathVariable("beach_id") Long beachId,
                                                                   Pageable page){
        var beachPhotos = photoService.getAllBeachPhotos(beachId, page);
        return ResponseEntity.ok(beachPhotos);
    }

    @GetMapping("/by-classification-count")
    public ResponseEntity<List<PhotoClassificationCountDTO>> getClassificationCount(){
        var classificationCount = photoService.getClassificationCount();
        return ResponseEntity.ok(classificationCount);
    }


    @DeleteMapping("/{photo_id}")
    public ResponseEntity<Void> delete(@PathVariable("photo_id") Long photoId){
        photoService.delete(photoId);
        return ResponseEntity.noContent().build();
    }
}
