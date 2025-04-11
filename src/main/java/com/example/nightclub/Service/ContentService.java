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
    public Content addContent(ContentRequestDto request ,String userIp) {
        // user_id로 최신 댓글을 조회
        Optional<Content> content = contentRepository.findByuserIp(userIp);

        if (content.isPresent()) {
            // IP가 이미 존재하면 post_id를 증가시킨다
            Content lastContent = content.get();
            content = Content.builder()
                    .user_id(userIp)
                    .content(userIp)
                    .post_id(lastContent.getPost_id() + 1)  // 마지막 post_id + 1 증가
                    .build();
        } else {
            // IP가 없으면 새로운 댓글을 추가 (첫 번째 댓글)
            content = Content.builder()
                    .user_id(user_id)
                    .content(userIp)
                    .post_id(1L)  // 첫 번째 댓글은 post_id가 1
                    .build();
        }

        // 댓글 저장
        return contentRepository.save(content);
    }
}
