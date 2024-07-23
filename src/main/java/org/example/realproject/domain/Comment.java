package org.example.realproject.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Comment {
    private long id;
    private String content;
    private LocalDateTime createdAt;
    private long userId;
    private long boardId;
    private String username;
}
