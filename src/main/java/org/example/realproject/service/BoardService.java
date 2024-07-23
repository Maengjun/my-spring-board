package org.example.realproject.service;

import org.example.realproject.domain.Board;
import org.example.realproject.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;


    @Autowired
    private UserService userService;

    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    public void delete(long id) {
        boardMapper.delete(id);
    }

    public Board findById(long id) {
        return boardMapper.findById(id);
    }

    public void update(Board board) {
        boardMapper.update(board);
    }

    public void insert(Board board) {
        boardMapper.insert(board);
    }

    public List<Board> search(String title) {
        return boardMapper.search(title);
    }

}
