package com.example.nightclub.Controller;

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
        return like.isPresent() ? ResponseEntity.ok(like.get()) : ResponseEntity.notFound().build();
    }
    @PostMapping("/api/Clublike/{Club_Id}")
    public ResponseEntity<Like> toggleClubLike(@PathVariable Long Club_Id, @RequestBody Boolean Like_Toggle) {
        Like like = clubLikeService.toggleLike(Club_Id, Like_Toggle);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

}
