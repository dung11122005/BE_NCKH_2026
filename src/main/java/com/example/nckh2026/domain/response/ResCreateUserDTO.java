package com.example.nckh2026.domain.response;

import java.time.Instant;

import com.example.nckh2026.util.constant.GenderEnum;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResCreateUserDTO {
    private long id;
    private String name;
    private String email;
    private GenderEnum gender;
    private String address;
    private int age;
    private Instant createdAt;
}
