package com.dh.fullstack.project.salesservice.controller.system;

import com.dh.fullstack.project.salesservice.command.EmployeeReadByEmailCmd;
import com.dh.fullstack.project.salesservice.controller.Constants;
import com.dh.fullstack.project.salesservice.model.domain.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Julio Daviu
 */
@RestController
@RequestScope
@RequestMapping(Constants.BasePath.SYSTEM_EMPLOYEE)
@Api(
        tags = Constants.EmployeeTagRead.NAME,
        description = Constants.EmployeeTagRead.DESCRIPTION
)
public class EmployeeReadByEmailController {

    @Autowired
    private EmployeeReadByEmailCmd employeeReadByEmailCmd;

    @ApiOperation(
            value = Constants.EmployeeTagRead.OPERATION_EMAIL
    )

    @RequestMapping(method = RequestMethod.GET)
    public Employee readEmployeeByEmail(@RequestParam("email") String email){
        employeeReadByEmailCmd.setEmail(email);
        employeeReadByEmailCmd.execute();
        return employeeReadByEmailCmd.getEmployee();
    }
}
