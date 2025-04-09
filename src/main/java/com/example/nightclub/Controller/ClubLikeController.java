package com.example.nightclub.Controller;

import com.example.nightclub.Entity.Like;
import com.example.nightclub.Service.ClubLikeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class ClubLikeController {
    @GetMapping("/api/Clublike/{Like_Id}")
    public ResponseEntity<Like> getClubLike(@PathVariable Long Like_Id) {
        Like like = ClubLikeService.getLike(Like_Id)
                .orElseThrow(() -> new EntityNotFoundException("Like not found"));
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

}
