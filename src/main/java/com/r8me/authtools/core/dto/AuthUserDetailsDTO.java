package com.r8me.authtools.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
public class AuthUserDetailsDTO {

    private Collection<? extends GrantedAuthority> authorities;

    private Long id;

    private String username;

    private String password;

    private boolean activated;
}
