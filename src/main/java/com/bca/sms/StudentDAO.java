package com.bca.sms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add student
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students "
                + "(roll_no, full_name, email, phone, course, semester) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPhone());
            ps.setString(5, s.getCourse());
            ps.setInt(6, s.getSemester());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // View all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("roll_no"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("course"),
                    rs.getInt("semester")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Update student
    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET roll_no=?, full_name=?, "
                + "email=?, phone=?, course=?, semester=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPhone());
            ps.setString(5, s.getCourse());
            ps.setInt(6, s.getSemester());
            ps.setInt(7, s.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete student
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Search students
    public List<Student> searchStudents(String keyword) {
        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM students "
                + "WHERE roll_no LIKE ? OR full_name LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("roll_no"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("course"),
                        rs.getInt("semester")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
