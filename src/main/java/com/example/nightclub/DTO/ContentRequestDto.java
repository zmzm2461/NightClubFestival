package com.example.nightclub.DTO;

import com.example.nightclub.Entity.Content;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ContentRequestDto {
    private Long id;
    private String content;
    private String userid;
    private Long post_id;

    public Content toEntity() {
        return Content.builder()  // 빌더 패턴을 사용하여 엔티티 생성
                .content(this.content)
                .userid(this.userid)
                .post_id(this.post_id)
                .build();
    }
}
