package org.example.realproject.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long id;
    private String username;
    private String password;
    private String password2;
    private boolean enabled = true;
}
