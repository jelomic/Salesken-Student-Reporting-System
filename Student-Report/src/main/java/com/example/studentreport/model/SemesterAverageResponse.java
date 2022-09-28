package com.example.studentreport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterAverageResponse {
    private Integer semester;
    private Integer mathAverage;
    private Integer scienceAverage;
    private Integer englishAverage;
}
