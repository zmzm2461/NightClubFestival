package com.example.nightclub.Controller;

import com.example.nightclub.DTO.LikeRequestDto;
import com.example.nightclub.DTO.LikeResponceDto;
import com.example.nightclub.Entity.Like;
import com.example.nightclub.Service.ClubLikeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
public class ClubLikeController {
    private final ClubLikeService clubLikeService;

    @GetMapping("/api/Clublike/{Club_Id}")
    public ResponseEntity<LikeResponceDto> getClubLike(@PathVariable Long Club_Id) {
        Optional<Like> like = clubLikeService.getLike(Club_Id);
        if (like.isPresent()) {
            LikeResponceDto likeResponceDto = new LikeResponceDto(like.get().getLikeCount());
            return ResponseEntity.ok(likeResponceDto);  // 상태 코드 200 OK는 기본값으로 설정됨
        } else {
            // like가 없을 경우
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/api/Clublike/{Club_Id}")
    public ResponseEntity<String> toggleClubLike(@PathVariable Long Club_Id, @RequestBody LikeRequestDto request) {
        String like = clubLikeService.toggleLike(Club_Id, request.getLikeToggle());
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

}
