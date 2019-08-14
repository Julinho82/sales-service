package com.dh.fullstack.project.salesservice.command;

import com.dh.fullstack.project.salesservice.model.domain.Employee;
import com.dh.fullstack.project.salesservice.model.domain.Employee_;
import com.dh.fullstack.project.salesservice.model.repositories.EmployeeRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Julio Daviu
 */
@SynchronousExecution
public class EmployeeListPaginationCmd implements BusinessLogicCommand {

    @Setter
    private Integer limit;

    @Setter
    private Integer page;

    @Getter
    private List<Employee> employees;

    @Getter
    private Long totalElements;

    @Getter
    private Integer totalPages;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void execute() {
        employees = new ArrayList<>();

        PageRequest pageRequest = PageRequest.of(page, limit);
        Page<Employee> pageResult = employeeRepository.findAll(buildSpecification(), pageRequest);

        List<Employee> content = pageResult.getContent();
        if(!CollectionUtils.isEmpty(content))
            employees.addAll(content);

        totalPages = pageResult.getTotalPages();
        totalElements = pageResult.getTotalElements();
    }

    /*Query to get employees while the position field is not null*/
    private Specification<Employee> buildSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(Employee_.position)));

            predicates.add(criteriaBuilder.isNotNull(root.get(Employee_.position)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
