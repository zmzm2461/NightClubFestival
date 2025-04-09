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
        return clubLikeRepository.countByClubId(Like_Id);
    }

    public Like toggleLike(Long Club_Id, Boolean Like_Toggle) {

        Optional<Like> existingLike = clubLikeRepository.findById(Club_Id);
        if (existingLike.isPresent()) {
            // 클럽이 존재할 때
            Like like = existingLike.get();

            if (Like_Toggle) {
                // 토글을 활성화하면 좋아요 수 증가
                like.setLikeCount(like.getLikeCount() + 1);
            } else {
                // 토글을 비활성화하면 좋아요 수 감소
                like.setLikeCount(like.getLikeCount() - 1);
            }
            clubLikeRepository.save(like); // 변경된 상태 저장
            return like; // 수정된 상태로 반환
        }
        else {
            if(Like_Toggle) {
                Like like = new Like();
                like.setLikeCount(like.getLikeCount() + 1);
            }
            return null;
        }
    }
}