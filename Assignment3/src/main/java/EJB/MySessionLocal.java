/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJB;

import entity.Studentmaster;
import entity.Studentsubject;
import entity.Subject;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeshanpatel1510
 */
@Local
public interface MySessionLocal {
    List<Studentsubject> getAllStudent();
    List<Subject> getAllSubjects();
    void addStudent(Studentsubject stud);
    void addSubject(Subject sub);
    void removeStudent(int stud);
    List<Studentsubject> searchStudent(int sub);
}
