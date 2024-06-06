package com.coastalcare.services;

import com.coastalcare.dto.photo.PhotoClassificationCountDTO;
import com.coastalcare.dto.photo.PhotoDetailsDTO;
import com.coastalcare.dto.photo.UpdatePhotoDTO;
import com.coastalcare.dto.photo.UploadPhotoDTO;
import com.coastalcare.infra.exceptions.EntityHasNoAssociationException;
import com.coastalcare.models.Beach;
import com.coastalcare.models.Participantion;
import com.coastalcare.models.Photo;
import com.coastalcare.models.User;
import com.coastalcare.models.enums.ClassificationPhoto;
import com.coastalcare.repositories.BeachRepository;
import com.coastalcare.repositories.PhotoRepository;
import com.coastalcare.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Photo upload(UploadPhotoDTO photoDTO) {
        User user = userRepository.getReferenceById(photoDTO.userId());
        Beach beach = beachRepository.getReferenceById(photoDTO.beachId());
        Photo photo = new Photo(photoDTO, user, beach);

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
    public Photo update(Long photoId, UpdatePhotoDTO photoDTO){
        User user = userRepository.getReferenceById(photoDTO.userId());
        Photo photo = photoRepository.getReferenceById(photoId);
        checkPhotoAssociationWithUser(user, photo);

        if(photoDTO.beachId() != null)
            photo.setBeach(beachRepository.getReferenceById(photoDTO.beachId()));

        if(!photoDTO.url().isEmpty())
            photo.setUrl(photoDTO.url());

        if(!photoDTO.url().isEmpty())
            photo.setUrl(photoDTO.url());

        return photoRepository.save(photo);
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
