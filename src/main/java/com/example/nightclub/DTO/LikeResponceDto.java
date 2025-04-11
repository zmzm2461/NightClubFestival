package com.example.nightclub.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LikeResponceDto {
    private int likeCount;

    public LikeResponceDto(int likeCount) {
        this.likeCount = likeCount;
    }
}
