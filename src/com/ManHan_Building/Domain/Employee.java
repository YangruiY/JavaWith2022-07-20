package com.ManHan_Building.Domain;

/**
 * 这是一个javabean 和 数据库的employee 相匹配
 *  id INT PRIMARY KEY AUTO_INCREMENT,
 * 	empId VARCHAR(50)NOT NULL DEFAULT '',
 * 	pwd CHAR(32)NOT NULL DEFAULT '',
 * 	NAME VARCHAR(32) NOT NULL DEFAULT '',
 * 	job VARCHAR(50) NOT NULL DEFAULT'',
 * 	salary INT NOT NULL DEFAULT'0'
 */
public class Employee {
    private Integer id;
    private String empId;
    private String pwd;
    private String name;
    private String job;
    private Integer salary;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee(Integer id, String empId, String pwd, String name, String job, Integer salary) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nid=" + id +
                ", empId='" + empId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary ;
    }
}
