package com.example.candy.domain.lecture;

import com.example.candy.domain.challenge.Challenge;
import com.example.candy.domain.problem.Problem;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecture {
    @Id
    @GeneratedValue
    @Column(name = "lecture_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    private String videoUrl;

    private String content;

    private String fileUrl;
}
