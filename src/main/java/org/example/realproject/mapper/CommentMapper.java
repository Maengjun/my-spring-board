package org.example.realproject.mapper;

import org.apache.ibatis.annotations.*;
import org.example.realproject.domain.Comment;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("Insert into comment(content, user_id, board_id) values (#{content}, #{userId}, #{boardId})")
    void insert(Comment comment);

//    SELECT b.id as id, title, content, created_at, u.username FROM Board as b inner join users as u on b.user_id = u.id
    @Select("Select * from comment as c join users as u on c.user_id = u.id where board_id = #{boardId}")
    List<Comment> findByBoardId(long boardId);
}