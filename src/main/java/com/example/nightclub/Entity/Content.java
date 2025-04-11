package com.example.nightclub.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Builder
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String content;
    private String userid;
    private Long post_id;


    public Content(Long id, String content, String userid, Long post_id) {
        this.id = id;
        this.content = content;
        this.userid = userid;
        this.post_id = post_id;
    }

    public Content(String content, String userIp, Long postId) {
        this.content = content;
        this.userid = userIp;
        this.post_id = postId;
    }

    public void postup() {
        post_id++;
    }

}
