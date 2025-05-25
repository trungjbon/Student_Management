package controller;


import view.StudentManagementView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementController implements ActionListener {
    private StudentManagementView studentManagementView;

    public StudentManagementController(StudentManagementView studentManagementView) {
        this.studentManagementView = studentManagementView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        JOptionPane.showMessageDialog(studentManagementView, actionCommand);
        if (actionCommand.equals("Insert")) {
            this.studentManagementView.deleteForm();
        } else if (actionCommand.equals("Ok")) {
            try {
                this.studentManagementView.insertOrEditStudent();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.studentManagementView,
                        "Wrong data input");
                exception.printStackTrace();
            }
        } else if (actionCommand.equals("Edit")) {
            this.studentManagementView.showInfoStudent();
        } else if (actionCommand.equals("Delete")) {
            this.studentManagementView.deleteStudent();
        } else if (actionCommand.equals("Cancel")) {
            this.studentManagementView.deleteForm();
        } else if (actionCommand.equals("Search")) {
            this.studentManagementView.searchStudent();
        } else if (actionCommand.equals("Cancel Search")) {
            this.studentManagementView.dataReload();
        } else if (actionCommand.equals("About Me")) {
            this.studentManagementView.showAboutMe();
        } else if (actionCommand.equals("Exit")) {
            this.studentManagementView.exitProgram();
        } else if (actionCommand.equals("Save")) {
            this.studentManagementView.saveFileData();
        } else if (actionCommand.equals("Open")) {
            this.studentManagementView.openFileData();
        }
    }
}
