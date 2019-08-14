package com.dh.fullstack.project.salesservice.controller;

/**
 * @author Julio Daviu
 */

public final class Constants {

    private Constants(){}

    public static class EmployeeTagCreate{

        public static final String NAME = "Employee create";

        public static final String DESCRIPTION = "creacion del empleado";

        public static final String OPERATION = "Endpoint  crear un empleado";
    }

    public static class EmployeeTagRead{

        public static final String NAME = "Employee read";

        public static final String DESCRIPTION = "Listar empleados";

        public static final String OPERATION_EMAIL = "Endpoint para encontrar emplado por su email";

        public static final String OPERATION_GENDER = "Endpoint para obtener empleados por genero";

        public static final String OPERATION_PAGINATION = "Endpoint para obtener empleados con paginacion";
    }

    public static class BasePath{
        public static final String SYSTEM = "/system";

        public static final String SYSTEM_EMPLOYEE = SYSTEM + "/employees";

        public static final String API = "/api";

        public static final String API_EMPLOYEE = API + "/employees";

        public static final String SYSTEM_EMPLOYEE_GENDER = SYSTEM_EMPLOYEE + "/gender";

        public static final String API_EMPLOYEE_POSITION = API_EMPLOYEE + "/position";
    }
}
