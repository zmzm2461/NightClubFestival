package com.example.nightclub.Controller;

import com.example.nightclub.DTO.LikeRequestDto;
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
    public ResponseEntity<Like> getClubLike(@PathVariable Long Club_Id) {
        Optional<Like> like = clubLikeService.getLike(Club_Id);
        return ResponseEntity.ok(like.get());
    }

    @PostMapping("/api/Clublike/{Club_Id}")
    public ResponseEntity<String> toggleClubLike(@PathVariable Long Club_Id, @RequestBody LikeRequestDto request) {
        String like = clubLikeService.toggleLike(Club_Id, request.getLikeToggle());
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

}
