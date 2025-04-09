package com.example.nightclub.Service;

import com.example.nightclub.Entity.Like;
import com.example.nightclub.Repository.ClubLikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClubLikeService {
    private final ClubLikeRepository clubLikeRepository;

    public Optional<Like> getLike(Long Like_Id) {
        return clubLikeRepository.findById(Like_Id);
    }
}
