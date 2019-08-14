package com.dh.fullstack.project.salesservice.controller.api;

import com.dh.fullstack.project.salesservice.command.EmployeeListPaginationCmd;
import com.dh.fullstack.project.salesservice.commons.Pagination;
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
@RequestMapping(Constants.BasePath.API_EMPLOYEE_POSITION)
@Api(
        tags = Constants.EmployeeTagRead.NAME,
        description = Constants.EmployeeTagRead.DESCRIPTION
)
public class EmployeeListController {

    @Autowired
    private EmployeeListPaginationCmd employeeListPaginationCmd;

    @ApiOperation(
            value = Constants.EmployeeTagRead.OPERATION_PAGINATION
    )

    @RequestMapping(method = RequestMethod.GET)
    public Pagination<Employee> listEmployeesPagination(@RequestParam("limit") Integer limit,
                                                        @RequestParam("page") Integer page){
        employeeListPaginationCmd.setLimit(limit);
        employeeListPaginationCmd.setPage(page);
        employeeListPaginationCmd.execute();

        Pagination<Employee> pagination = new Pagination<>();
        pagination.setContent(employeeListPaginationCmd.getEmployees());
        pagination.setTotalElements(employeeListPaginationCmd.getTotalElements());
        pagination.setTotalPages(employeeListPaginationCmd.getTotalPages());

        return pagination;
    }
}
