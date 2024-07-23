package org.example.realproject.controller;


import org.apache.ibatis.annotations.Update;
import org.example.realproject.domain.Board;
import org.example.realproject.domain.Comment;
import org.example.realproject.service.BoardService;
import org.example.realproject.service.CommentService;
import org.example.realproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable long id, Model model) {
        boardService.delete(id);
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
        // return "redirect:/board/list"
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable long id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        List<Comment> comment = commentService.findByBoardId(id);
        model.addAttribute("comment", comment);
        return "board/single";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/update";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute Board board, Model model) {
        boardService.update(board);
        Board updatedBoard = boardService.findById(board.getId());
        model.addAttribute("updateBoard", updatedBoard);
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/insert")
    public String add(Model model) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "board/insert";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam("title") String title, @RequestParam("content") String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Long userId = userService.findUserIdByUsername(username);
        Board board= new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setUserId(userId);

        boardService.insert(board);
        return "redirect:/board/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("title") String title, Model model) {
        List<Board> board = boardService.search(title);
        System.out.println(board);
        model.addAttribute("boards", board);
        return "board/list";
    }
}
