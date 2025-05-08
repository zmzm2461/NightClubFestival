package com.example.nightclub.Repository;

import com.example.nightclub.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {


    // 특정 IP(userid)와 postId에 해당하는 댓글을 찾기 위한 쿼리
    Optional<Content> findByUseridAndPostId(String userid, Long postId);

    // 특정 IP(userid)와 postId에 해당하는 댓글을 삭제하는 쿼리
    void deleteByUseridAndPostId(String userid, Long postId);


    List<Content> findByUserid(String userid);

}
