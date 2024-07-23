package org.example.realproject.controller;

import org.example.realproject.domain.Comment;
import org.example.realproject.service.BoardService;
import org.example.realproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    private BoardService boardService;

    @PostMapping("/{boardId}")
    public String addComment(@PathVariable Long boardId,@ModelAttribute Comment comment) {
        comment.setBoardId(boardId);
        commentService.insert(comment);
        return "redirect:/board/" + comment.getBoardId();
    }
}
