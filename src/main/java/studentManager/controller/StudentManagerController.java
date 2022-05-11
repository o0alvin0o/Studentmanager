package studentManager.controller;

import studentManager.view.StudentManagerView;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagerController implements ActionListener {
    final static String NAME = "NAME";
    final static int GPA = 1;
    private StudentManagerView smv;

    public StudentManagerController(StudentManagerView smv) {
        this.smv = smv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":
                smv.addStudent();
                break;
            case "Remove":
                smv.removeStudent();
                break;
            case "Edit":
                smv.editStudent();
                break;
            case "Update":
                smv.Update();
                break;
            case "Clear":
                smv.clearAll();
                break;
            case "SortByName":
                smv.sort(NAME);
                break;
            case "SortByGPA":
                smv.sort(GPA);
                break;
            default :
                break;
        }
    }

}