package com.example.nightclub.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`like`")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Club_id")
    private Long clubId;

    private int likeCount;

    private boolean likeToggle;

    public Like(Long id, Long clubId, int likeCount) {
        this.id = id;
        this.clubId = clubId;
        this.likeCount = likeCount;
    }

    public void upCount() {
        likeCount++;
    }

    public void downCount() {
        likeCount--;
    }
}
