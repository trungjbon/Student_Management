package view;

import controller.StudentManagementController;
import model.BirthPlace;
import model.Student;
import model.StudentManagementModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StudentManagementView extends JFrame {

    private StudentManagementModel studentManagementModel;
    private JTextField jTextFieldID;
    private JTextField jTextFieldName;
    private JTextField jTextFieldSubject1;
    private JTextField jTextFieldSubject2;
    private JTextField jTextFieldDate;
    private JTextField jTextFieldSubject3;
    private ButtonGroup buttonGroupGender;
    private JComboBox jComboBoxProvinceInInfo;
    private JTable jTable;
    private JRadioButton jRadioButtonMale;
    private JRadioButton jRadioButtonFemale;
    private JComboBox jComboBoxProvinceInFillter;
    private JTextField jTextFieldIdInFillter;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public StudentManagementView() {
        this.studentManagementModel = new StudentManagementModel();
        init();
    }

    private void init() {
        this.setTitle("Student Management");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Icon
        URL urlJava = StudentManagementView.class.getResource("Java-icon.png");
        Image image = Toolkit.getDefaultToolkit().createImage(urlJava);
        this.setIconImage(image);

        // ActionListener
        ActionListener actionListener = new StudentManagementController(this);

        // JMenuBar
        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenuFile = new JMenu("File");
        JMenuItem jMenuItemOpen = new JMenuItem("Open");
        jMenuItemOpen.addActionListener(actionListener);
        JMenuItem jMenuItemSave = new JMenuItem("Save");
        jMenuItemSave.addActionListener(actionListener);
        JSeparator jSeparator = new JSeparator();
        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.addActionListener(actionListener);

        jMenuFile.add(jMenuItemOpen);
        jMenuFile.add(jMenuItemSave);
        jMenuFile.add(jSeparator);
        jMenuFile.add(jMenuItemExit);

        JMenu jMenuAbout = new JMenu("About");
        JMenuItem jMenuItemAboutMe = new JMenuItem("About Me");
        jMenuItemAboutMe.addActionListener(actionListener);

        jMenuAbout.add(jMenuItemAboutMe);

        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuAbout);

        this.add(jMenuBar, BorderLayout.NORTH);


        // jPanelMain
        JPanel jPanelMain = new JPanel();
        jPanelMain.setLayout(new BorderLayout());


        // jPanelAbove
        JPanel jPanelAbove = new JPanel();
        jPanelAbove.setLayout(new BorderLayout());
        JLabel jLabelStudentFillter = new JLabel("Student Fillter");
        jLabelStudentFillter.setFont(new Font("Arial", Font.BOLD, 18));
        jPanelAbove.add(jLabelStudentFillter, BorderLayout.NORTH);

        JPanel jPanelStudentFillter = new JPanel();
        jPanelStudentFillter.setLayout(new GridLayout(1, 6));
        jPanelStudentFillter.add(new JLabel("BirthPlace:"));

        jComboBoxProvinceInFillter = new JComboBox();
        List<BirthPlace> birthPlaceList = BirthPlace.getProvinceList();
        jComboBoxProvinceInFillter.addItem("");
        for (BirthPlace birthPlace : birthPlaceList) {
            jComboBoxProvinceInFillter.addItem(birthPlace.getBirthPlaceName());
        }
        jPanelStudentFillter.add(jComboBoxProvinceInFillter);

        jPanelStudentFillter.add(new JLabel("StudentID:"));

        jTextFieldIdInFillter = new JTextField();
        jPanelStudentFillter.add(jTextFieldIdInFillter);

        JButton jButtonSearch = new JButton("Search");
        jButtonSearch.addActionListener(actionListener);
        jPanelStudentFillter.add(jButtonSearch);

        JButton jButtonCancelSearch = new JButton("Cancel Search");
        jButtonCancelSearch.addActionListener(actionListener);
        jPanelStudentFillter.add(jButtonCancelSearch);

        jPanelAbove.add(jPanelStudentFillter, BorderLayout.CENTER);

        jPanelAbove.add(new JSeparator(), BorderLayout.SOUTH);

        jPanelMain.add(jPanelAbove, BorderLayout.NORTH);


        // jPanelBetween
        JPanel jPanelBetween = new JPanel();
        jPanelBetween.setLayout(new BorderLayout());
        JLabel jLabelStudentList = new JLabel("Student List");
        jLabelStudentList.setFont(new Font("Arial", Font.BOLD, 18));
        jPanelBetween.add(jLabelStudentList, BorderLayout.NORTH);

        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ID", "Name", "Place", "Date", "Gender", "Subject 1",
                        "Subject 2", "Subject 3"
                }
        ));

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jPanelBetween.add(jScrollPane, BorderLayout.CENTER);

        jPanelBetween.add(new JSeparator(), BorderLayout.SOUTH);

        jPanelMain.add(jPanelBetween, BorderLayout.CENTER);


        // jPanelBelow
        JPanel jPanelBelow = new JPanel();
        jPanelBelow.setLayout(new BorderLayout());
        JLabel jLabelStudentInformation = new JLabel("Student Information");
        jLabelStudentInformation.setFont(new Font("Arial", Font.BOLD, 18));
        jPanelBelow.add(jLabelStudentInformation, BorderLayout.NORTH);

        JPanel jPanelBoard = new JPanel();
        jPanelBoard.setLayout(new GridLayout(4, 4));
        jPanelBoard.add(new JLabel("ID"));
        jTextFieldID = new JTextField();
        jPanelBoard.add(jTextFieldID);
        jPanelBoard.add(new JLabel("Gender"));

        JPanel jPanelGender = new JPanel();
        jPanelGender.setLayout(new GridLayout(1, 2));
        jRadioButtonMale = new JRadioButton("Male");
        jRadioButtonFemale = new JRadioButton("Female");
        buttonGroupGender = new ButtonGroup();
        buttonGroupGender.add(jRadioButtonMale);
        buttonGroupGender.add(jRadioButtonFemale);
        jPanelGender.add(jRadioButtonMale);
        jPanelGender.add(jRadioButtonFemale);
        jPanelBoard.add(jPanelGender);

        jPanelBoard.add(new JLabel("Name"));
        jTextFieldName = new JTextField();
        jPanelBoard.add(jTextFieldName);
        jPanelBoard.add(new JLabel("Subject 1"));
        jTextFieldSubject1 = new JTextField();
        jPanelBoard.add(jTextFieldSubject1);
        jPanelBoard.add(new JLabel("BirthPlace"));

        jComboBoxProvinceInInfo = new JComboBox();
        jComboBoxProvinceInInfo.addItem("");
        for (BirthPlace birthPlace : birthPlaceList) {
            jComboBoxProvinceInInfo.addItem(birthPlace.getBirthPlaceName());
        }
        jPanelBoard.add(jComboBoxProvinceInInfo);

        jPanelBoard.add(new JLabel("Subject 2"));
        jTextFieldSubject2 = new JTextField();
        jPanelBoard.add(jTextFieldSubject2);
        jPanelBoard.add(new JLabel("Date"));
        jTextFieldDate = new JTextField();
        jPanelBoard.add(jTextFieldDate);
        jPanelBoard.add(new JLabel("Subject 3"));
        jTextFieldSubject3 = new JTextField();
        jPanelBoard.add(jTextFieldSubject3);

        jPanelBelow.add(jPanelBoard, BorderLayout.CENTER);
        jPanelBelow.add(new JSeparator(), BorderLayout.SOUTH);

        jPanelMain.add(jPanelBelow, BorderLayout.SOUTH);

        this.add(jPanelMain, BorderLayout.CENTER);

        // jPanelButton
        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new GridLayout(1, 5));

        JButton jButtonInsert = new JButton("Insert");
        jPanelButton.add(jButtonInsert);
        jButtonInsert.addActionListener(actionListener);

        JButton jButtonDelete = new JButton("Delete");
        jPanelButton.add(jButtonDelete);
        jButtonDelete.addActionListener(actionListener);

        JButton jButtonEdit = new JButton("Edit");
        jPanelButton.add(jButtonEdit);
        jButtonEdit.addActionListener(actionListener);

        JButton jButtonOk = new JButton("Ok");
        jPanelButton.add(jButtonOk);
        jButtonOk.addActionListener(actionListener);

        JButton jButtonCancel = new JButton("Cancel");
        jPanelButton.add(jButtonCancel);
        jButtonCancel.addActionListener(actionListener);

        this.add(jPanelButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void deleteForm() {
        this.jTextFieldID.setText("");
        this.jTextFieldName.setText("");
        this.jTextFieldDate.setText("");
        this.jTextFieldSubject1.setText("");
        this.jTextFieldSubject2.setText("");
        this.jTextFieldSubject3.setText("");
        this.jComboBoxProvinceInInfo.setSelectedIndex(-1);
        this.buttonGroupGender.clearSelection();
    }

    public void insertOrEditStudent() {
        if (jTextFieldName.getText().equals("")
                || jComboBoxProvinceInInfo.getSelectedItem().equals("")
                || (jRadioButtonMale.isSelected() == false && jRadioButtonFemale.isSelected() == false)) {
            JOptionPane.showMessageDialog(this, "Wrong data input");
            return;
        }

        Student student = getStudentFromInfo();

        if (student.getSubjectScore1() < 0 || student.getSubjectScore1() > 10
                || student.getSubjectScore2() < 0 || student.getSubjectScore2() > 10
                || student.getSubjectScore3() < 0 || student.getSubjectScore3() > 10) {
            JOptionPane.showMessageDialog(this, "Wrong data input");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        if (!this.studentManagementModel.existID(student)) {
            this.studentManagementModel.insert(student);
            System.out.println(student);
            this.addOneStudentIntoTable(student, model);
        } else {
            this.studentManagementModel.edit(student);
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String iD = model.getValueAt(i, 0).toString();
                if (iD.equals(student.getStudentID() + "")) {
                    model.setValueAt(student.getStudentID() + "", i, 0);
                    model.setValueAt(student.getStudentName(), i, 1);
                    model.setValueAt(student.getStudentCountryside().getBirthPlaceName(), i, 2);
                    model.setValueAt(dateFormat.format(student.getStudentDateOfBirth()), i, 3);
                    model.setValueAt(student.isStudentGender() ? "Male" : "Female", i, 4);
                    model.setValueAt(student.getSubjectScore1() + "", i, 5);
                    model.setValueAt(student.getSubjectScore2() + "", i, 6);
                    model.setValueAt(student.getSubjectScore3() + "", i, 7);
                    break;
                }
            }
        }
    }


    public void showInfoStudent() {
        Student student = getStudentFromTable();

        this.jTextFieldID.setText(student.getStudentID() + "");
        this.jTextFieldName.setText(student.getStudentName());
        this.jComboBoxProvinceInInfo.setSelectedItem(student.getStudentCountryside().getBirthPlaceName());
        this.jTextFieldDate.setText(dateFormat.format(student.getStudentDateOfBirth()));
        if (student.isStudentGender()) {
            jRadioButtonMale.setSelected(true);
        } else {
            jRadioButtonFemale.setSelected(true);
        }
        this.jTextFieldSubject1.setText(student.getSubjectScore1() + "");
        this.jTextFieldSubject2.setText(student.getSubjectScore2() + "");
        this.jTextFieldSubject3.setText(student.getSubjectScore3() + "");
    }

    public void deleteStudent() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int selectedRow = jTable.getSelectedRow();

        int choose = JOptionPane.showConfirmDialog(this, "Are you sure delete?");
        if (choose == JOptionPane.YES_OPTION) {
            Student student = getStudentFromTable();
            this.studentManagementModel.delete(student);
            model.removeRow(selectedRow);
        }
    }

    public Student getStudentFromTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int selectedRow = jTable.getSelectedRow();

        int studentID = Integer.valueOf(model.getValueAt(selectedRow, 0).toString());
        String studentName = model.getValueAt(selectedRow, 1).toString();
        String provinceName = model.getValueAt(selectedRow, 2).toString();
        int provinceID = BirthPlace.getProvinceIDByName(provinceName);
        BirthPlace studentCountryside = new BirthPlace(provinceID, provinceName);
        Date studentDateOfBirth = null;
        try {
            studentDateOfBirth = dateFormat.parse(model.getValueAt(selectedRow, 3).toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String chooseGender = model.getValueAt(selectedRow, 4).toString();
        boolean studentGender = chooseGender.equals("Male") ? true : false;
        double subjectScore1 = Double.valueOf(model.getValueAt(selectedRow, 5).toString());
        double subjectScore2 = Double.valueOf(model.getValueAt(selectedRow, 6).toString());
        double subjectScore3 = Double.valueOf(model.getValueAt(selectedRow, 7).toString());

        return new Student(studentID, studentName, studentCountryside, studentDateOfBirth,
                studentGender, subjectScore1, subjectScore2, subjectScore3);
    }

    public Student getStudentFromInfo() {
        int studentID = Integer.valueOf(this.jTextFieldID.getText());
        String studentName = this.jTextFieldName.getText();
        String provinceName = this.jComboBoxProvinceInInfo.getSelectedItem() + "";
        int provinceID = BirthPlace.getProvinceIDByName(provinceName);
        BirthPlace studentCountryside = new BirthPlace(provinceID, provinceName);
        Date studentDateOfBirth = null;
        try {
            studentDateOfBirth = dateFormat.parse(this.jTextFieldDate.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Enter date in format dd/MM/yyyy");
            throw new RuntimeException(e);
        }

        boolean studentGender = this.jRadioButtonMale.isSelected() ? true : false;
        double subjectScore1 = Double.valueOf(this.jTextFieldSubject1.getText());
        double subjectScore2 = Double.valueOf(this.jTextFieldSubject2.getText());
        double subjectScore3 = Double.valueOf(this.jTextFieldSubject3.getText());

        return new Student(studentID, studentName, studentCountryside, studentDateOfBirth,
                studentGender, subjectScore1, subjectScore2, subjectScore3);
    }

    public void searchStudent() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int rowCount = model.getRowCount();

        String provinceName = this.jComboBoxProvinceInFillter.getSelectedItem() + "";
        if (!provinceName.equals("")) {
            for (int i = 0; i < rowCount; i++) {
                if (!model.getValueAt(i, 2).equals(provinceName)) {
                    model.removeRow(i);
                    rowCount = model.getRowCount();
                    i--;
                }
            }
        }

        String studentID = this.jTextFieldIdInFillter.getText();
        if (!studentID.equals("")) {
            for (int i = 0; i < rowCount; i++) {
                if (!model.getValueAt(i, 0).equals(studentID)) {
                    model.removeRow(i);
                    rowCount = model.getRowCount();
                    i--;
                }
            }
        }
    }

    public void dataReload() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int rowCount = model.getRowCount();

        while (rowCount != 0) {
            model.removeRow(0);
            rowCount = model.getRowCount();
        }

        for (int i = 0; i < studentManagementModel.getStudentList().size(); i++) {
            this.addOneStudentIntoTable(studentManagementModel.getStudentList().get(i), model);
        }

    }

    private void addOneStudentIntoTable(Student student, DefaultTableModel model) {
        model.addRow(
                new Object[]{
                        student.getStudentID() + "",
                        student.getStudentName(),
                        student.getStudentCountryside().getBirthPlaceName(),
                        dateFormat.format(student.getStudentDateOfBirth()),
                        (student.isStudentGender() ? "Male" : "Female"),
                        student.getSubjectScore1() + "",
                        student.getSubjectScore2() + "",
                        student.getSubjectScore3() + ""
                });
    }

    public void showAboutMe() {
        JOptionPane.showMessageDialog(this,
                "Student Management software 1.0");
    }

    public void exitProgram() {
        int choose = JOptionPane.showConfirmDialog(this,
                "Are you sure exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void saveFileData() {
        if (this.studentManagementModel.getFileName().length() > 0) {
            saveFile(this.studentManagementModel.getFileName());
        } else {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                saveFile(file.getAbsolutePath());
            }
        }
    }

    public void openFileData() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            openFile(file.getAbsolutePath());
            dataReload();
        }
    }

    private void openFile(String path) {
        try {
            this.studentManagementModel.setFileName(path);
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Student> studentList = new ArrayList<>();
            studentList = (List<Student>) ois.readObject();

            this.studentManagementModel.setStudentList(studentList);
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveFile(String path) {
        try {
            this.studentManagementModel.setFileName(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.studentManagementModel.getStudentList());
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
