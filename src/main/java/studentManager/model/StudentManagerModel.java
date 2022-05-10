package studentManager.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class StudentManagerModel {
    public static final short NAME = 1, AGE = 2, ADDRESS = 3, GPA = 4;
    private ArrayList<Student> slist = new ArrayList<>();

    public StudentManagerModel() {
    }

    public void addStudent (Student student) {
        slist.add(student);
    }

    public void removeStudent(Student student) {
        slist.remove(student);
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
    }

    public void clear() {
        slist.clear();
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
}
