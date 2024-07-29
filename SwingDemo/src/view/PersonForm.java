package view;

// PersonForm.java
import javax.swing.*;

import model.Person;

import java.awt.*;

public class PersonForm extends JPanel {
    protected JTextField nameField;
    protected JTextField ageField;

    public PersonForm() {
        // setLayout(new GridLayout(2, 2));

        // add(new JLabel("Name:"));
        nameField = new JTextField();
        // add(nameField);

        // add(new JLabel("Age:"));
        ageField = new JTextField();
        // add(ageField);
    }

    public Person createPerson() {
        Person person = new Person();
        person.setName(nameField.getText());
        person.setAge(Integer.parseInt(ageField.getText()));
        return person;
    }
}
