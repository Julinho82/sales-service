package com.dh.fullstack.project.salesservice.controller.api;

import com.dh.fullstack.project.salesservice.command.EmployeeCreateCmd;
import com.dh.fullstack.project.salesservice.controller.Constants;
import com.dh.fullstack.project.salesservice.input.EmployeeCreateInput;
import com.dh.fullstack.project.salesservice.model.domain.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Julio Daviu
 */
@RestController
@RequestMapping(Constants.BasePath.API_EMPLOYEE)
@RequestScope
@Api(

        tags = Constants.EmployeeTagCreate.NAME,
        description = Constants.EmployeeTagCreate.DESCRIPTION
)
public class EmployeeCreateController {

    @Autowired
    private EmployeeCreateCmd employeeCreateCmd;

    @ApiOperation(
            value = Constants.EmployeeTagCreate.OPERATION
    )
    @RequestMapping(method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody EmployeeCreateInput input){
        employeeCreateCmd.setInput(input);
        employeeCreateCmd.execute();
        return employeeCreateCmd.getEmployee();
    }
}
