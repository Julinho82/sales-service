package com.dh.fullstack.project.salesservice.controller.system;

import com.dh.fullstack.project.salesservice.command.EmployeeReadByGenderCmd;
import com.dh.fullstack.project.salesservice.controller.Constants;
import com.dh.fullstack.project.salesservice.model.domain.Employee;
import com.dh.fullstack.project.salesservice.model.domain.Gender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * @author Julio Daviu
 */
@RestController
@RequestScope
@RequestMapping(Constants.BasePath.SYSTEM_EMPLOYEE_GENDER)
@Api(
        tags = Constants.EmployeeTagRead.NAME,
        description = Constants.EmployeeTagRead.DESCRIPTION
)
public class EmployeeReadByGenderController {

    @Autowired
    private EmployeeReadByGenderCmd employeeReadByGenderCmd;

    @ApiOperation(
            value = Constants.EmployeeTagRead.OPERATION_GENDER
    )
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> readEmployeeByGender(@RequestParam("gender") Gender gender){
        employeeReadByGenderCmd.setGender(gender);
        employeeReadByGenderCmd.execute();
        return employeeReadByGenderCmd.getEmployees();
    }
}
