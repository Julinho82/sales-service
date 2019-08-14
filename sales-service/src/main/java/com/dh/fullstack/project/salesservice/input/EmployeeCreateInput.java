package com.dh.fullstack.project.salesservice.input;

import com.dh.fullstack.project.salesservice.model.domain.Gender;
import lombok.Data;

/**
 * @author Julio Daviu
 */

@Data
public class EmployeeCreateInput {
    private String email;
    private String firstName;
    private String lastName;
    private String position;
    private Gender gender;
    private Integer age;
}
