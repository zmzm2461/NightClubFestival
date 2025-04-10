package com.example.nightclub.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeRequestDto {
    private Long clubId;
    private boolean likeToggle;

    public Boolean getLikeToggle() {
        return likeToggle;
    }
}
