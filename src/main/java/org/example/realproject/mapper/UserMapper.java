package org.example.realproject.mapper;

import org.apache.ibatis.annotations.*;
import org.example.realproject.domain.Board;
import org.example.realproject.domain.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO users (username, password, enabled) VALUES (#{username}, #{password}, #{enabled})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Select("Select id from users where username = #{username}")
    Long findUserIdByUsername(String username);

    @Insert("INSERT INTO authorities (user_id, authority) VALUES (#{userId}, #{authority})")
    void insertAuthority(Long userId, String authority);
}
