package com.dh.fullstack.project.salesservice.model.repositories;

import com.dh.fullstack.project.salesservice.model.domain.Employee;
import com.dh.fullstack.project.salesservice.model.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Julio Daviu
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    /*Obtener un empleado con un cierto email*/
    @Query("select item from Employee item where item.email = :email")
    Optional<Employee> findEmployeeByEmail(@Param("email") String email);

    /*Obtener lista de empleados segun genero*/
    @Query("select item from Employee item where item.gender = :gender")
    List<Employee> findEmployeeByGender(@Param("gender") Gender gender);
}
