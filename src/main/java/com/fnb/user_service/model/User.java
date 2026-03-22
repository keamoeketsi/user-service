package com.fnb.user_service.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name ="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;
    private String password;
}