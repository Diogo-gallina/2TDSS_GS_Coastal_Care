package com.coastalcare.controllers;

import com.coastalcare.dto.photo.PhotoDetailsDTO;
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

}
