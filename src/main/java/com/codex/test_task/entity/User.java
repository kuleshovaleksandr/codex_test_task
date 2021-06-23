package com.codex.test_task.entity;

import com.codex.test_task.model.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    @Email
    private String email;
}
