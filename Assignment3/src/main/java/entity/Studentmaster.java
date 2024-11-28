/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jeshanpatel1510
 */
@Entity
@Table(name = "studentmaster", catalog = "assign3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Studentmaster.findAll", query = "SELECT s FROM Studentmaster s"),
    @NamedQuery(name = "Studentmaster.findByStudentid", query = "SELECT s FROM Studentmaster s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "Studentmaster.findByStudentname", query = "SELECT s FROM Studentmaster s WHERE s.studentname = :studentname")})
public class Studentmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentid")
    private Integer studentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "studentname")
    private String studentname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentid")
    private Collection<Studentsubject> studentsubjectCollection;
    @JoinColumn(name = "courseid", referencedColumnName = "courseid")
    @ManyToOne(optional = false)
    private Course courseid;

    public Studentmaster() {
    }

    public Studentmaster(Integer studentid) {
        this.studentid = studentid;
    }

    public Studentmaster(Integer studentid, String studentname) {
        this.studentid = studentid;
        this.studentname = studentname;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Collection<Studentsubject> getStudentsubjectCollection() {
        return studentsubjectCollection;
    }

    public void setStudentsubjectCollection(Collection<Studentsubject> studentsubjectCollection) {
        this.studentsubjectCollection = studentsubjectCollection;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentmaster)) {
            return false;
        }
        Studentmaster other = (Studentmaster) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Studentmaster[ studentid=" + studentid + " ]";
    }
    
}
