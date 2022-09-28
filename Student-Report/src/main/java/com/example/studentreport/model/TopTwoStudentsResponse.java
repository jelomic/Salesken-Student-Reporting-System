package com.example.studentreport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopTwoStudentsResponse {
    private Integer semester;
    private String topperName;
    private Integer topperAverage;
    private String runnerUpName;
    private Integer runnerUpAverage;
}
