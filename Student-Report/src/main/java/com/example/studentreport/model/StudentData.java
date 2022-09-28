package com.example.studentreport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "data")
@IdClass(CompositeKey.class)
public class StudentData {

    @Id
    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "semester")
    private Integer semester;

    @Column(name = "maths")
    private Integer maths;

    @Column(name = "science")
    private Integer science;

    @Column(name = "english")
    private Integer english;
}
