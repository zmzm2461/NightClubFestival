package com.example.nightclub.Service;

import com.example.nightclub.DTO.ContentRequestDto;
import com.example.nightclub.Entity.Content;
import com.example.nightclub.Repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    // 댓글 작성 로직
    public String addContent(ContentRequestDto request ,String userid) {
        // user_id로 최신 댓글을 조회
        Optional<Content> existingContent = contentRepository.findByuserid(userid);

        if (existingContent.isPresent()) {
            // IP가 이미 존재하면 post_id를 증가시킨다
            Content content = new Content(request.getContent(), userid, request.getId());
            content.postup();
            contentRepository.save(content);
            return "댓글 추가";
        } else {
            // IP가 없으면 새로운 댓글을 추가 (첫 번째 댓글)
            Content content = new Content(request.getContent(), userid, request.getPost_id());
            contentRepository.save(content);
            return "댓글 추가";
        }
    }
    public Content save(ContentRequestDto request){
        return contentRepository.save(request.toEntity());
    }
   public List<Content> findAll(){
        return contentRepository.findAll();
   }
}
