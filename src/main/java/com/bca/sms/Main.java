package com.bca.sms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Main extends JFrame {

    private JTextField rollField, nameField, emailField;
    private JTextField phoneField, courseField, semesterField;
    private JTextField searchField;

    private JTable table;
    private DefaultTableModel model;

    private StudentDAO dao = new StudentDAO();
    private int selectedId = -1;

    public Main() {
        setTitle("Student Management System");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(4, 4, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder(
            "Student Details"
        ));

        rollField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        courseField = new JTextField();
        semesterField = new JTextField();

        form.add(new JLabel("Roll Number:"));
        form.add(rollField);
        form.add(new JLabel("Full Name:"));
        form.add(nameField);

        form.add(new JLabel("Email:"));
        form.add(emailField);
        form.add(new JLabel("Phone:"));
        form.add(phoneField);

        form.add(new JLabel("Course:"));
        form.add(courseField);
        form.add(new JLabel("Semester:"));
        form.add(semesterField);

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        form.add(addButton);
        form.add(updateButton);
        form.add(deleteButton);
        form.add(clearButton);

        model = new DefaultTableModel(
            new String[]{"ID", "Roll No", "Name",
                "Email", "Phone", "Course", "Semester"}, 0
        );

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel searchPanel = new JPanel();

        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton refreshButton = new JButton("Refresh");

        searchPanel.add(new JLabel("Search Student:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);

        add(form, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addStudent());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        clearButton.addActionListener(e -> clearFields());
        searchButton.addActionListener(e -> searchStudents());
        refreshButton.addActionListener(e -> loadStudents());

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectStudent();
            }
        });

        loadStudents();
    }

    private void addStudent() {
        try {
            Student s = getStudentFromFields(-1);

            if (dao.addStudent(s)) {
                JOptionPane.showMessageDialog(this,
                    "Student added successfully!");
                loadStudents();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Unable to add student.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid student details.");
        }
    }

    private void updateStudent() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select a student first.");
            return;
        }

        try {
            Student s = getStudentFromFields(selectedId);

            if (dao.updateStudent(s)) {
                JOptionPane.showMessageDialog(this,
                    "Student updated successfully!");
                loadStudents();
                clearFields();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid details.");
        }
    }

    private void deleteStudent() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select a student first.");
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this student?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            if (dao.deleteStudent(selectedId)) {
                JOptionPane.showMessageDialog(this,
                    "Student deleted successfully!");
                loadStudents();
                clearFields();
            }
        }
    }

    private void loadStudents() {
        model.setRowCount(0);
        List<Student> students = dao.getAllStudents();

        for (Student s : students) {
            addRow(s);
        }
    }

    private void searchStudents() {
        model.setRowCount(0);

        List<Student> students =
            dao.searchStudents(searchField.getText().trim());

        for (Student s : students) {
            addRow(s);
        }
    }

    private void addRow(Student s) {
        model.addRow(new Object[]{
            s.getId(),
            s.getRollNo(),
            s.getFullName(),
            s.getEmail(),
            s.getPhone(),
            s.getCourse(),
            s.getSemester()
        });
    }

    private void selectStudent() {
        int row = table.getSelectedRow();

        if (row >= 0) {
            selectedId = Integer.parseInt(
                model.getValueAt(row, 0).toString()
            );

            rollField.setText(model.getValueAt(row, 1).toString());
            nameField.setText(model.getValueAt(row, 2).toString());
            emailField.setText(model.getValueAt(row, 3).toString());
            phoneField.setText(model.getValueAt(row, 4).toString());
            courseField.setText(model.getValueAt(row, 5).toString());
            semesterField.setText(model.getValueAt(row, 6).toString());
        }
    }

    private Student getStudentFromFields(int id) {
        String roll = rollField.getText().trim();
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String course = courseField.getText().trim();
        int semester = Integer.parseInt(
            semesterField.getText().trim()
        );

        if (roll.isEmpty() || name.isEmpty() || course.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return new Student(
            id, roll, name, email, phone, course, semester
        );
    }

    private void clearFields() {
        rollField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        courseField.setText("");
        semesterField.setText("");
        searchField.setText("");

        selectedId = -1;
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
