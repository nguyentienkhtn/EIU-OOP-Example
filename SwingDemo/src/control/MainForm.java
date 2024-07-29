package control;

// MainForm.java
import javax.swing.*;

import model.Person;
import view.PersonForm;
import view.StudentForm;
import view.TeacherForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JComboBox<String> personTypeCombo;
    private JPanel formPanel;
    private PersonForm personForm;

    public MainForm() {
        setTitle("Person Form");
        setLayout(new BorderLayout());

        personTypeCombo = new JComboBox<>(new String[]{"Student", "Teacher"});
        personTypeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateForm();
            }
        });

        add(personTypeCombo, BorderLayout.NORTH);

        formPanel = new JPanel(new BorderLayout());
        add(formPanel, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        add(submitButton, BorderLayout.SOUTH);

        updateForm();
    }

    private void updateForm() {
        String selectedType = (String) personTypeCombo.getSelectedItem();
        formPanel.removeAll();

        if ("Student".equals(selectedType)) {
            personForm = new StudentForm();
        } else if ("Teacher".equals(selectedType)) {
            personForm = new TeacherForm();
        }

        formPanel.add(personForm, BorderLayout.CENTER);
        formPanel.revalidate();
        formPanel.repaint();
    }

    private void handleSubmit() {
        Person person = personForm.createPerson();
        System.out.println("Submitted: " + person.getClass().getSimpleName() + " - " + person);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainForm mainForm = new MainForm();
            mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainForm.setSize(400, 300);
            mainForm.setVisible(true);
        });
    }
}
