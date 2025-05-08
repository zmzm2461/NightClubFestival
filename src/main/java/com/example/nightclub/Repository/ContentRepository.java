package com.example.nightclub.Repository;

import com.example.nightclub.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {


    List<Content> findByUserid(String userid);

    Optional<Content> findByUseridAndId(String userid, Long id);
}
