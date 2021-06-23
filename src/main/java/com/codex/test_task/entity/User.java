package com.codex.test_task.entity;

import com.codex.test_task.model.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

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
