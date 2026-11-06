package com.example.springboot.dto;

import java.io.Serializable;

public record UserDto(Long id, String firstName, String lastName)  {
}
