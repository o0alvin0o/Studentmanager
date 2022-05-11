package studentManager.view;

import studentManager.controller.StudentManagerController;
import studentManager.model.Student;
import studentManager.model.StudentManagerModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentManagerView extends JFrame {
    static int rowIndex;
    private StudentManagerModel studentManagerModel;
    // Button
    private JButton add_button = new JButton("Add");
    private JButton remove_button = new JButton("Remove");
    private JButton edit_button = new JButton("Edit");

    private JButton update_button = new JButton("Update");
    private JButton clear_button = new JButton("Clear");
    private JButton sortName_button = new JButton("SortByName");
    private JButton sortGPA_button = new JButton("SortByGPA");
    // Panel
    private JPanel function_panel = new JPanel(new FlowLayout());

    private JTextField name_field;
    private JTextField age_field;
    private JTextField id_field;
    private JTextField gpa_field;
    private JTextArea address_area;
    private DefaultTableModel tableModel;

    private JScrollPane scrollPane;

    private JTable table;
    public StudentManagerView() {
        studentManagerModel = new StudentManagerModel();
        this.init();
    }

    private void init() {

        // Init frame
        this.setTitle("Manager");
        this.setSize(1000,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        ActionListener ac = new StudentManagerController(this);

        // Create Label and field
        JLabel name_label = new JLabel("Name");
        JLabel age_label = new JLabel("Age");
        JLabel id_label = new JLabel("ID");
        JLabel gpa_label = new JLabel("GPA");
        JLabel address_label = new JLabel("Address");
        name_field = new JTextField(30);
        age_field = new JTextField(3);
        id_field = new JTextField(10);
        gpa_field = new JTextField(4);
        address_area = new JTextArea(3,10);

        // Set field border
        name_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        age_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        id_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gpa_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        address_area.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Adjust position of label and field
        name_label.setBounds(10,10,150,20);
        name_field.setBounds(90,10,150,20);
        age_label.setBounds(10,40,150,20);
        age_field.setBounds(90,40,30,20);
        id_label.setBounds(10,70,150,20);
        id_field.setBounds(90,70,150,20);
        gpa_label.setBounds(10,100,150,20);
        gpa_field.setBounds(90,100,150,20);
        address_label.setBounds(10,130,150,20);
        address_area.setBounds(90,130,150,80);

        //Add label and field
        this.add(name_label);
        this.add(name_field);
        this.add(age_label);
        this.add(age_field);
        this.add(id_label);
        this.add(id_field);
        this.add(gpa_label);
        this.add(gpa_field);
        this.add(address_label);
        this.add(address_area);

        // Adjust button position then add
        function_panel.setBounds(0,230,300,35);
        update_button.setBounds(160,270,80,25);
        function_panel.add(add_button);
        function_panel.add(remove_button);
        function_panel.add(edit_button);
        function_panel.add(clear_button);
        this.add(function_panel);
        this.add(update_button);

        sortName_button.setBounds(300,370,120,35);
        sortGPA_button.setBounds(420,370,120,35);
        this.add(sortName_button);
        this.add(sortGPA_button);

        // Action listener
        add_button.addActionListener(ac);
        remove_button.addActionListener(ac);
        clear_button.addActionListener(ac);
        edit_button.addActionListener(ac);
        update_button.addActionListener(ac);
        sortGPA_button.addActionListener(ac);
        sortName_button.addActionListener(ac);
        //Table data and listener

        tableModel = studentManagerModel.getTableModel();
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(false);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300,10,450,350);

        this.add(scrollPane);

        this.setVisible(true);
    }

    public void addStudent () {
        // name
        String name = name_field.getText();
        name_field.setText("");
        // id
        String stringId = id_field.getText();
        int id = -1;
        try {
            id = Integer.valueOf(id_field.getText());
        } catch (NumberFormatException exception) {
            if (stringId.length() != 0)
                JOptionPane.showMessageDialog(null,"ID is an integer number, you entered " + stringId);
        }
        id_field.setText("");
        // age
        String stringAge = age_field.getText();
        int age = -1;
        try {
            age = Integer.valueOf(age_field.getText());
        } catch (NumberFormatException exception) {
            if (stringId.length() != 0)
                JOptionPane.showMessageDialog(null,"Age is an integer number, you entered " + stringId);
        }
        age_field.setText("");
        String address = address_area.getText();
        address_area.setText("");

        // gpa
        String stringGpa = gpa_field.getText();
        float gpa = -1;
        try {
            gpa = Float.valueOf(gpa_field.getText());
        } catch (NumberFormatException exception) {
            if (stringId.length() != 0)
                JOptionPane.showMessageDialog(null,"GPA is a float number, you entered " + stringId);
            else gpa = 0;
        }
        gpa_field.setText("");
        studentManagerModel.addStudent(new Student(name,id,age,address,gpa));
    }

    public void removeStudent() {
        if (table.getSelectedRow() != -1) {
            tableModel.removeRow(table.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
        }
    }

    public void editStudent() {
        rowIndex  = table.getSelectedRow();
        name_field.setText(""+table.getValueAt(rowIndex, 1));
        age_field.setText(""+ table.getValueAt(rowIndex, 2));
        id_field.setText(""+table.getValueAt(rowIndex, 0));
        gpa_field.setText(""+table.getValueAt(rowIndex, 4));
        address_area.setText(""+table.getValueAt(rowIndex, 3));

    }

    public void clearAll() {
        studentManagerModel.clear();
    }

    public void sort(String name) {
        studentManagerModel.sortByName();
    }

    public void sort(int GPA) {
        studentManagerModel.sortByGPA();
    }

    public void Update() {
        // name
        String name = name_field.getText();
        name_field.setText("");
        // id
        String stringId = id_field.getText();
        int id = -1;
        try {
            id = Integer.valueOf(id_field.getText());
        } catch (NumberFormatException exception) {
            if (stringId.length() != 0)
                JOptionPane.showMessageDialog(null,"ID is an integer number, you entered " + stringId);
        }
        id_field.setText("");
        // age
        String stringAge = age_field.getText();
        int age = -1;
        try {
            age = Integer.valueOf(age_field.getText());
        } catch (NumberFormatException exception) {
            if (stringId.length() != 0)
                JOptionPane.showMessageDialog(null,"Age is an integer number, you entered " + stringId);
        }
        age_field.setText("");
        String address = address_area.getText();
        address_area.setText("");

        // gpa
        String stringGpa = gpa_field.getText();
        float gpa = -1;
        try {
            gpa = Float.valueOf(gpa_field.getText());
        } catch (NumberFormatException exception) {
            if (stringId.length() != 0)
                JOptionPane.showMessageDialog(null,"GPA is a float number, you entered " + stringId);
            else gpa = 0;
        }
        gpa_field.setText("");
        studentManagerModel.updateStudent(name,id,age,address,gpa,rowIndex);
        studentManagerModel.refreshData();

    }
}
