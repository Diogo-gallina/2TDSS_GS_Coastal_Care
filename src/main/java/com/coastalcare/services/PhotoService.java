package com.coastalcare.services;

import com.coastalcare.dto.photo.PhotoClassificationCountDTO;
import com.coastalcare.dto.photo.PhotoDetailsDTO;
import com.coastalcare.dto.photo.UploadPhotoDTO;
import com.coastalcare.infra.exceptions.EntityHasNoAssociationException;
import com.coastalcare.models.Beach;
import com.coastalcare.models.Photo;
import com.coastalcare.models.User;
import com.coastalcare.models.enums.ClassificationPhoto;
import com.coastalcare.repositories.BeachRepository;
import com.coastalcare.repositories.PhotoRepository;
import com.coastalcare.repositories.UserRepository;
import com.coastalcare.utils.S3ImageUploader;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BeachRepository beachRepository;

    @Transactional
    public Photo upload(UploadPhotoDTO photoDTO, MultipartFile imageFile) {
        User user = userRepository.getReferenceById(photoDTO.userId());
        Beach beach = beachRepository.getReferenceById(photoDTO.beachId());
        String imageUrl = S3ImageUploader.uploadImageToS3(imageFile);
        Photo photo = new Photo(photoDTO, user, beach, imageUrl);
        return photoRepository.save(photo);
    }

    public Page<PhotoDetailsDTO> getAll(Pageable page) {
        return photoRepository.findAll(page).map(PhotoDetailsDTO::new);
    }

    public Photo getOne(Long photoId){
        return photoRepository.getReferenceById(photoId);
    }

    public Page<PhotoDetailsDTO> getAllUserPhotos(Long userId, Pageable page) {
        User user = userRepository.getReferenceById(userId);
        List<PhotoDetailsDTO> photoDetailsDTOs = user.getPhotos().stream()
                .map(PhotoDetailsDTO::new)
                .collect(Collectors.toList());

        return new PageImpl<>(photoDetailsDTOs, page, photoDetailsDTOs.size());
    }

    public Page<PhotoDetailsDTO> getAllBeachPhotos(Long beachId, Pageable page) {
        Beach beach = beachRepository.getReferenceById(beachId);
        List<PhotoDetailsDTO> photoDetailsDTOs = beach.getPhotos().stream()
                .map(PhotoDetailsDTO::new)
                .collect(Collectors.toList());

        return new PageImpl<>(photoDetailsDTOs, page, photoDetailsDTOs.size());
    }

    public List<PhotoClassificationCountDTO> getClassificationCount(){
        var results = photoRepository.countPhotosByClassification();
        return results.stream()
                .map(result -> new PhotoClassificationCountDTO((ClassificationPhoto) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long photoId) {
        photoRepository.deleteById(photoId);
    }

    private static void checkPhotoAssociationWithUser(User user, Photo photo){
        List<Long> userPhotosIndexes = user.getPhotos().stream().map(Photo::getId).toList();
        if(!userPhotosIndexes.contains(photo.getId()))
            throw new EntityHasNoAssociationException("Foto não tem associação com esse usuário");
    }

}
