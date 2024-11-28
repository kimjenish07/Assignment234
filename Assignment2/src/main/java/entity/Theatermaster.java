/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "theatermaster", catalog = "assign", schema = "")
@NamedQueries({
    @NamedQuery(name = "Theatermaster.findAll", query = "SELECT t FROM Theatermaster t"),
    @NamedQuery(name = "Theatermaster.findByTheaterId", query = "SELECT t FROM Theatermaster t WHERE t.theaterId = :theaterId"),
    @NamedQuery(name = "Theatermaster.findByTheaterName", query = "SELECT t FROM Theatermaster t WHERE t.theaterName = :theaterName"),
    @NamedQuery(name = "Theatermaster.findByCity", query = "SELECT t FROM Theatermaster t WHERE t.city = :city"),
    @NamedQuery(name = "Theatermaster.findByState", query = "SELECT t FROM Theatermaster t WHERE t.state = :state"),
    @NamedQuery(name = "Theatermaster.findByLocation", query = "SELECT t FROM Theatermaster t WHERE t.location = :location")})
public class Theatermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "theaterId")
    private Integer theaterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "theaterName")
    private String theaterName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theaterId")
    private List<Movietheater> movietheaterList;

    public Theatermaster() {
    }

    public Theatermaster(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public Theatermaster(Integer theaterId, String theaterName, String city, String state, String location) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.city = city;
        this.state = state;
        this.location = location;
    }

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Movietheater> getMovietheaterList() {
        return movietheaterList;
    }

    public void setMovietheaterList(List<Movietheater> movietheaterList) {
        this.movietheaterList = movietheaterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theatermaster)) {
            return false;
        }
        Theatermaster other = (Theatermaster) object;
        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theatermaster[ theaterId=" + theaterId + " ]";
    }
    
}
