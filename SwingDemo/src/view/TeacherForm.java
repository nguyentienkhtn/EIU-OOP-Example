package view;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Person;
import model.Teacher;
import java.awt.*;
public class TeacherForm extends PersonForm{
    private JTextField employeeIdField;
    private JTextField departmentField;

    public TeacherForm() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("Age:"));
        add(ageField);

        add(new JLabel("Employee ID:"));
        employeeIdField = new JTextField();
        add(employeeIdField);

        add(new JLabel("Department:"));
        departmentField = new JTextField();
        add(departmentField);
    }

    @Override
    public Person createPerson() {
        Teacher teacher = new Teacher();
        teacher.setName(nameField.getText());
        teacher.setAge(Integer.parseInt(ageField.getText()));
        teacher.setEmployeeId(employeeIdField.getText());
        teacher.setDepartment(departmentField.getText());
        return teacher;
    }
}
