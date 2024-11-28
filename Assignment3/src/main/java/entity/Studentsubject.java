/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jeshanpatel1510
 */
@Entity
@Table(name = "studentsubject", catalog = "assign3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Studentsubject.findAll", query = "SELECT s FROM Studentsubject s"),
    @NamedQuery(name = "Studentsubject.findByMasterid", query = "SELECT s FROM Studentsubject s WHERE s.masterid = :masterid")})
public class Studentsubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "masterid")
    private Integer masterid;
    @JoinColumn(name = "subjectid", referencedColumnName = "subjectid")
    @ManyToOne(optional = false)
    private Subject subjectid;
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    @ManyToOne(optional = false)
    private Studentmaster studentid;

    public Studentsubject() {
    }

    public Studentsubject(Integer masterid) {
        this.masterid = masterid;
    }

    public Integer getMasterid() {
        return masterid;
    }

    public void setMasterid(Integer masterid) {
        this.masterid = masterid;
    }

    public Subject getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Subject subjectid) {
        this.subjectid = subjectid;
    }

    public Studentmaster getStudentid() {
        return studentid;
    }

    public void setStudentid(Studentmaster studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masterid != null ? masterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentsubject)) {
            return false;
        }
        Studentsubject other = (Studentsubject) object;
        if ((this.masterid == null && other.masterid != null) || (this.masterid != null && !this.masterid.equals(other.masterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Studentsubject[ masterid=" + masterid + " ]";
    }
    
}
