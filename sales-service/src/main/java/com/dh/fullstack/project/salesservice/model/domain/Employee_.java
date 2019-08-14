package com.dh.fullstack.project.salesservice.model.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author Julio Daviu
 */
@StaticMetamodel(Employee.class)

public class Employee_ {

    public static volatile SingularAttribute<Employee, String> position;

}
