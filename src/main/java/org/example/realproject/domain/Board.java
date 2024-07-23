package org.example.realproject.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Board {
    private long id;
    private String title;
    private String content;
    private long userId;
    private LocalDateTime createdAt;
    private String username;
}
