package com.r8me.authtools.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenCheckResponseDTO {

    private boolean valid;

    private String reason;

    private final Instant checkTimestamp = Instant.now();

}
