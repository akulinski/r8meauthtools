package com.r8me.authtools.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private String token;
}
