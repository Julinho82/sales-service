package com.dh.fullstack.project.salesservice.command;

import com.dh.fullstack.project.salesservice.exception.EmployeeNotFoundException;
import com.dh.fullstack.project.salesservice.model.domain.Employee;
import com.dh.fullstack.project.salesservice.model.repositories.EmployeeRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Julio Daviu
 */
@SynchronousExecution
public class EmployeeReadByEmailCmd implements BusinessLogicCommand {

    @Setter
    private String email;

    @Getter
    private Employee employee;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void execute() {
        employee = findEmployeeByEmail(email);
    }

    private Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email).orElseThrow(()-> new EmployeeNotFoundException("Unable to locate an employee for email: " + email));
    }
}
