package com.example.nightclub.DTO;

import com.example.nightclub.Entity.Content;
import lombok.Getter;

@Getter
public class ContentResponceDto {
    String content;

    public ContentResponceDto(Content content) {
        this.content = content.getContent();
    }
}
