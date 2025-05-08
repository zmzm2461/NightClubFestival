package com.example.nightclub.Service;

import com.example.nightclub.DTO.ContentRequestDto;
import com.example.nightclub.Entity.Content;
import com.example.nightclub.Repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    // 댓글 작성 로직
    public String addContent(ContentRequestDto request ,String userid) {
        // 입력받은 ip가 댓글을 작성했는지 확인
        List<Content> existingContents = contentRepository.findByUserid(userid);

        if (!existingContents.isEmpty()) {
            // IP가 이미 존재하면 post_id를 증가시킨다
            Content content = new Content(request.getContent(), userid, request.getPost_id());
            content.postup();
            contentRepository.save(content);
            return "댓글 추가";
        } else {
            // IP가 없으면 새로운 댓글을 추가 (첫 번째 댓글)
            Content content = new Content(request.getContent(), userid, request.getPost_id());
            contentRepository.save(content);
            content.postset();
            return "댓글 생성";
        }
    }
    public List<Content> findAll(){
        return contentRepository.findAll();
   }

    public String updateContent(Long id, ContentRequestDto request, String userid) {
        Optional<Content> existingContents = contentRepository.findByUseridAndId(userid, id);

        if(existingContents.isPresent()) {
            Content content = new Content(id, request.getContent(), userid, request.getPost_id());
            contentRepository.save(content);
            return "댓글 수정 완료";
        } else {
            return "해당 댓글이 존재하지 않습니다.";
        }
    }
}
