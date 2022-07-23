package com.ManHan_Building.Service;

import com.ManHan_Building.Dao.EmployeeDao;
import com.ManHan_Building.Domain.Employee;

/**
 * 该类完成对employee表的各种操作(通过调用 EmployeeDao 对象完成)
 */
public class EmployeeService {
    private EmployeeDao employeeDao= new EmployeeDao();
    //方法(根据empId 和 pwd 返回一个 Employee 对象)
    public Employee getEmployeeFromIdempId(String Id,String empId){
        Employee employee =
                employeeDao.querySingle("select * from employee where id =? and empId =?", Employee.class, Id, empId);
        return employee;
    }

}
