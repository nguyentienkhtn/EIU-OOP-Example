package model;

public class Teacher extends Person{
    private String employeeId;
    private String department;
    public Teacher(String name, int age, String employeeId, String department) {
        super(name, age);
        this.employeeId = employeeId;
        this.department = department;
    }
    public Teacher() {
        //TODO Auto-generated constructor stub
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Teacher [employeeId=" + employeeId + ", department=" + department + "]";
    }
    
}
