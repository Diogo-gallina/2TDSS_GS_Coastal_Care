package com.coastalcare.controllers;

import com.coastalcare.dto.photo.PhotoDetailsDTO;
import com.coastalcare.dto.photo.UpdatePhotoDTO;
import com.coastalcare.dto.photo.UploadPhotoDTO;
import com.coastalcare.models.Photo;
import com.coastalcare.services.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @PostMapping
    public ResponseEntity<PhotoDetailsDTO> upload(@RequestBody @Valid UploadPhotoDTO photoDTO,
                                                  UriComponentsBuilder uri){
        Photo photo = photoService.upload(photoDTO);
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

    @GetMapping("users/{user_id}")
    public ResponseEntity<Page<PhotoDetailsDTO>> findAllUserPhotos(@PathVariable("user_id") Long userId,
                                                             Pageable page){
        var userPhotos = photoService.getAllUserPhotos(userId, page);
        return ResponseEntity.ok(userPhotos);
    }

    @GetMapping("beaches/{beach_id}")
    public ResponseEntity<Page<PhotoDetailsDTO>> findAllBeachPhotos(@PathVariable("beach_id") Long beachId,
                                                                   Pageable page){
        var beachPhotos = photoService.getAllBeachPhotos(beachId, page);
        return ResponseEntity.ok(beachPhotos);
    }

    @PutMapping("/{photo_id}")
    public ResponseEntity<PhotoDetailsDTO> update(@PathVariable("photo_id") Long photoId,
                                                  @RequestBody @Valid UpdatePhotoDTO photoDTO){
        Photo photo = photoService.update(photoId, photoDTO);
        return ResponseEntity.ok(new PhotoDetailsDTO(photo));
    }

    @DeleteMapping("/{photo_id}")
    public ResponseEntity<Void> delete(@PathVariable("photo_id") Long photoId){
        photoService.delete(photoId);
        return ResponseEntity.noContent().build();
    }
}
