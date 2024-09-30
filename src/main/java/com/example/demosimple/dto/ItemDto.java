package com.example.demosimple.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemDto {
    private List<Long> bookId;
    private Long studentId;
}
