package org.example.realproject.service;

import org.example.realproject.domain.Comment;
import org.example.realproject.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserService userService;


    public void insert(Comment comment) {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        comment.setUserId(userService.findUserIdByUsername(username));
        commentMapper.insert(comment);
    }

    public List<Comment> findByBoardId(long boardId) {
        commentMapper.findByBoardId(boardId);
        return commentMapper.findByBoardId(boardId);
    }
}
