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

    public Optional<Like> getLike(Long Club_Id) {
        return clubLikeRepository.findByClubId(Club_Id);
    }

    public String toggleLike(Long Club_Id, Boolean likeToggle) {

        Optional<Like> existingLike = clubLikeRepository.findByClubId(Club_Id);  // 수정된 부분
        if (existingLike.isPresent()) {
            // 클럽이 존재할 때
            Like like = existingLike.get();
            if (likeToggle) {
                // 토글을 활성화하면 좋아요 수 증가
                like.upCount();
                clubLikeRepository.save(like); // 변경된 상태 저장
                return "좋아요가 추가되었습니다";
            } else {
                // 토글을 비활성화하면 좋아요 수 감소
                like.downCount();
                clubLikeRepository.save(like); // 변경된 상태 저장
                return "좋아요가 삭제되었습니다.";
            }

        } else {
            Like newlike = new Like(null, Club_Id, 0);
            if (likeToggle) {
                newlike.upCount();
            }
            clubLikeRepository.save(newlike);
            return "좋아요가 추가되었습니다.";
        }
    }
}