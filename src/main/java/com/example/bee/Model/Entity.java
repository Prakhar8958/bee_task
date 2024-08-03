package com.example.bee.Model;


import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@jakarta.persistence.Entity
@Data
public class Entity {

    @Id
    private Long id;

    private String originalUrl;

    private String shortCode;

    private LocalDateTime created;

    private Long accessCount;


}
