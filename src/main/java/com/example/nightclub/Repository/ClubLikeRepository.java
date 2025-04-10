package com.example.nightclub.Repository;

import com.example.nightclub.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubLikeRepository extends JpaRepository<Like, Long> {


    Optional<Like> findByClubId(Long clubId);

}
