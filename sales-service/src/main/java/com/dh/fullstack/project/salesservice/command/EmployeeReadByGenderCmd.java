package com.dh.fullstack.project.salesservice.command;

import com.dh.fullstack.project.salesservice.model.domain.Employee;
import com.dh.fullstack.project.salesservice.model.domain.Gender;
import com.dh.fullstack.project.salesservice.model.repositories.EmployeeRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Julio Daviu
 */
@SynchronousExecution
public class EmployeeReadByGenderCmd implements BusinessLogicCommand {

    @Setter
    private Gender gender;

    @Getter
    private List<Employee> employees;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void execute() {
        employees = findEmployeesByGender(gender);
    }

    private List<Employee> findEmployeesByGender(Gender gender) {
        return employeeRepository.findEmployeeByGender(gender);
    }
}
