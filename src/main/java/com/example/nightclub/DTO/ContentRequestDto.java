package com.example.nightclub.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.nightclub.Entity.Content;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ContentRequestDto {
    private Long id;
    private String content;
    private Long user_id;
    private Long post_id;

    public Content toEntity(){
        return Content.builder()
                .content(content)
                .user_id(user_id)
                .post_id(post_id)
                .build();
    }
}
