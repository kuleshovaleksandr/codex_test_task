package com.codex.test_task.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto extends AbstractDto {

    private String email;

    private String password;
}
