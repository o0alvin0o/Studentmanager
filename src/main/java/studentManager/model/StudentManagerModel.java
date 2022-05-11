package studentManager.model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class StudentManagerModel {
    public static final short NAME = 1, AGE = 2, ADDRESS = 3, GPA = 4;
    private ArrayList<Student> slist = new ArrayList<>();
    final static String[] col = {"ID", "Name","Age","Address","GPA"};
    private DefaultTableModel tableModel = new DefaultTableModel(col,0);

    private int currentIndex = 0;
    public StudentManagerModel() {
    }

    public void addStudent (Student student) {
        slist.add(student);
        this.addData();
    }


    public void sortByName() {
        if (slist.size() > 0) {
            Collections.sort(slist, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }

        tableModel.setRowCount(0);
        for (int i = 0; i < slist.size(); i++) {
            int id = slist.get(i).getId();
            int age = slist.get(i).getAge();
            String name = slist.get(i).getName();
            float gpa = slist.get(i).getGrade();
            String address = slist.get(i).getAddress();

            Object[] data = {id, name, age, address, gpa};
            tableModel.addRow(data);
        }

    }

    public void sortByGPA() {

        if (slist.size() > 0) {
            Collections.sort(slist, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o1.getGrade(), o2.getGrade());
                }
            });
        }
        tableModel.setRowCount(0);
        for (int i = 0; i < slist.size(); i++) {
            int id = slist.get(i).getId();
            int age = slist.get(i).getAge();
            String name = slist.get(i).getName();
            float gpa = slist.get(i).getGrade();
            String address = slist.get(i).getAddress();

            Object[] data = {id, name, age, address, gpa};
            tableModel.addRow(data);
        }
    }

    public void clear() {
        slist.clear();
        tableModel.setRowCount(0);
        currentIndex = 0;
    }

    public void edit(int index,short field) {
        switch (field) {
            case ADDRESS: {

            } break;

            case AGE: {

            } break;

            case NAME: {

            } break;

            case GPA: {

            } break;
            default: break;
        }
    }

    public void addData() {

        for (int i = currentIndex; i < slist.size(); i++) {
            int id = slist.get(i).getId();
            int age = slist.get(i).getAge();
            String name = slist.get(i).getName();
            float gpa = slist.get(i).getGrade();
            String address = slist.get(i).getAddress();

            Object[] data = {id, name, age, address, gpa};
            tableModel.addRow(data);
        }
        currentIndex++;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void refreshData() {
        tableModel.setRowCount(0);
        for (int i = 0; i < slist.size(); i++) {
            int id = slist.get(i).getId();
            int age = slist.get(i).getAge();
            String name = slist.get(i).getName();
            float gpa = slist.get(i).getGrade();
            String address = slist.get(i).getAddress();

            Object[] data = {id, name, age, address, gpa};
            tableModel.addRow(data);
        }
    }

    public void updateStudent(String name, int id, int age, String address, float gpa, int index) {
        slist.get(index).setAddress(address);
        slist.get(index).setAge(age);
        slist.get(index).setGrade(gpa);
        slist.get(index).setId(id);
        slist.get(index).setName(name);
    }
}
