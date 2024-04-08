package org.example.service.mapping.department;

import org.example.persistence.entities.Department;
import org.example.service.dto.department.DepartmentGet;
import org.example.service.mapping.EntityMapperToModel;

public class DepartmentGetMapper implements EntityMapperToModel<DepartmentGet, Department> {

    private static DepartmentGetMapper instance;
    @Override
    public DepartmentGet convertEntityToModel(Department e) {
        DepartmentGet departmentGet = new DepartmentGet();
        departmentGet.setDepartmentID(e.getId());
        departmentGet.setDepartmentName(e.getDepartmentName());
        departmentGet.setManagerID(e.getManager().getId());
        departmentGet.setManagerName(e.getDepartmentName());
        return departmentGet;
    }
    private DepartmentGetMapper(){

    }
    public static DepartmentGetMapper getInstance(){
        if(instance==null)
            instance = new DepartmentGetMapper();
        return instance;
    }
}
