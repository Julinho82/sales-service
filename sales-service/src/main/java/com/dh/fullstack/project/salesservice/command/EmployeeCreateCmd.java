package com.dh.fullstack.project.salesservice.command;

import com.dh.chat.contact.service.input.TableApiCreateInput;
import com.dh.fullstack.project.salesservice.client.contact.service.SystemTableApiService;
import com.dh.fullstack.project.salesservice.config.SalesProperties;
import com.dh.fullstack.project.salesservice.input.EmployeeCreateInput;
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
public class EmployeeCreateCmd implements BusinessLogicCommand {

    @Getter
    private Employee employee;

    @Setter
    private EmployeeCreateInput input;

    @Autowired
    private SalesProperties salesProperties;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SystemTableApiService systemTableApiService;

    @Override
    public void execute(){
        employee = employeeRepository.save(composeInstanceEmployee());

        createTableApiClient();
    }

    private Employee composeInstanceEmployee() {
        Employee instance = new Employee();
        instance.setFirstName(input.getFirstName());
        instance.setLastName(input.getLastName());
        instance.setEmail(input.getEmail());
        instance.setPosition(input.getPosition());
        instance.setGender(input.getGender());
        instance.setIsDeleted(isPermit(input.getAge()));
        return instance;
    }

    private void createTableApiClient() {
        TableApiCreateInput input = new TableApiCreateInput();
        input.setColumnOne("columnOne");
        input.setColumnTwo("columnTwo");
        input.setColumnThree("columnThree");

        systemTableApiService.createTableApi(input);
    }

    private Boolean isPermit(Integer age){
        return salesProperties.getPermitAge() > age;
    }
}
