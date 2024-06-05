package com.coastalcare.services;

import com.coastalcare.dto.Participation.ParticipationDetailsDTO;
import com.coastalcare.dto.photo.PhotoDetailsDTO;
import com.coastalcare.dto.photo.UploadPhotoDTO;
import com.coastalcare.models.Beach;
import com.coastalcare.models.Photo;
import com.coastalcare.models.User;
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

}
