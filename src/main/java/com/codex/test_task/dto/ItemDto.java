package com.codex.test_task.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItemDto extends AbstractDto {
    private UUID id;
    private String name;
    private String description;
    private List<TagDto> tags;
}
