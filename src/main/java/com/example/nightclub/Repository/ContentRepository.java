package com.example.nightclub.Repository;

import com.example.nightclub.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    Optional<Content> findTopByUser_idOrderByPost_idDesc(Long user_id);
}
