/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJB;

import entity.Studentsubject;
import entity.Subject;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeshanpatel1510
 */
@Stateless
public class MySession implements MySessionLocal {
    @PersistenceContext(unitName = "mypu")
    EntityManager em;
    
    @Override
    public List<Studentsubject> getAllStudent() {
        return em.createNamedQuery("Studentmaster.findAll").getResultList();
    }

    @Override
    public List<Subject> getAllSubjects() {
        return em.createNamedQuery("Studentsubject.findAll").getResultList();
    }

    @Override
    public void addStudent(Studentsubject stud) {
       
    }

    @Override
    public void addSubject(Subject sub) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeStudent(int stud) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Studentsubject> searchStudent(int sub) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
