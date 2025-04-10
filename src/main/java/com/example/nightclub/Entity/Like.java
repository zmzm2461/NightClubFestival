package com.example.nightclub.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Club_Id")
    private Long Club_Id;
    @Column(name = "Club_Id")
    private Long Like_Id;


    private boolean Like_Toggle;

    public void setLikeCount(Long Like_Id) {
        this.Like_Id = Like_Id;
    }
    public Long getLikeCount() {
        return Like_Id;
    }
}
