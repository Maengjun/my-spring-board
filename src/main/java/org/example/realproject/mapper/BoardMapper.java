package org.example.realproject.mapper;

import org.apache.ibatis.annotations.*;
import org.example.realproject.domain.Board;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT b.id as id, title, content, created_at, u.username FROM Board as b inner join users as u on b.user_id = u.id")
    List<Board> findAll();

    @Select("SELECT * FROM board where id = #{id}")
    Board findById(long id);

    @Insert("INSERT INTO board(title, content, user_id) VALUES (#{title}, #{content}, #{userId})")
    @Options (useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Update("UPDATE board SET title=#{title}, content=#{content}, user_id=#{user_id} where id = #{id}")
    void update(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    void delete(long id);

    @Select("Select * from board where title = #{title}")
    List<Board> search(String title);
}
