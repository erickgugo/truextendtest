package com.truextend.institute.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author gmercado
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {

    @Id
    private long code;
    private String title;
    private String description;
}
