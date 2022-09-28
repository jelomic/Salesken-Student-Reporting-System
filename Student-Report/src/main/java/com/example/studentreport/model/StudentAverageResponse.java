package com.example.studentreport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAverageResponse {
    private String firstName;
    private String lastName;
    private Integer mathAverage;
    private Integer scienceAverage;
    private Integer englishAverage;

}
