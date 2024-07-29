package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;

import model.Person;
import model.Student;

// StudentForm.java
public class StudentForm extends PersonForm {
    private JTextField studentIdField;
    private JTextField majorField;

    public StudentForm() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("Age:"));
        add(ageField);

        add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        add(studentIdField);

        add(new JLabel("Major:"));
        majorField = new JTextField();
        add(majorField);
    }

    @Override
    public Person createPerson() {
        Student student = new Student();
        student.setName(nameField.getText());
        student.setAge(Integer.parseInt(ageField.getText()));
        student.setStudentId(studentIdField.getText());
        student.setMajor(majorField.getText());
        return student;
    }
}


