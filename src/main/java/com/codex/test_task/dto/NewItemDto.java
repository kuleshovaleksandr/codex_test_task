package com.codex.test_task.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewItemDto extends AbstractDto {
    private String name;
    private String description;
}
