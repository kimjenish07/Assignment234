/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author jeshanpatel1510
 */
@Entity
@Table(name = "movietheater", catalog = "assign", schema = "")
@NamedQueries({
    @NamedQuery(name = "Movietheater.findAll", query = "SELECT m FROM Movietheater m"),
    @NamedQuery(name = "Movietheater.findByMasterid", query = "SELECT m FROM Movietheater m WHERE m.masterid = :masterid"),
    @NamedQuery(name = "Movietheater.findByShowTime", query = "SELECT m FROM Movietheater m WHERE m.showTime = :showTime"),
    @NamedQuery(name = "Movietheater.findByTicketPrice", query = "SELECT m FROM Movietheater m WHERE m.ticketPrice = :ticketPrice")})
public class Movietheater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "masterid")
    private Integer masterid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showTime")
    private int showTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticketPrice")
    private int ticketPrice;
    @JoinColumn(name = "movieId", referencedColumnName = "movieId")
    @ManyToOne(optional = false)
    @JsonbTransient
    private Moviemaster movieId;
    @JoinColumn(name = "theaterId", referencedColumnName = "theaterId")
    @ManyToOne(optional = false)
    @JsonbTransient
    private Theatermaster theaterId;

    public Movietheater() {
    }

    public Movietheater(Integer masterid) {
        this.masterid = masterid;
    }

    public Movietheater(Integer masterid, int showTime, int ticketPrice) {
        this.masterid = masterid;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
    }

    public Integer getMasterid() {
        return masterid;
    }

    public void setMasterid(Integer masterid) {
        this.masterid = masterid;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Moviemaster getMovieId() {
        return movieId;
    }

    public void setMovieId(Moviemaster movieId) {
        this.movieId = movieId;
    }

    public Theatermaster getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Theatermaster theaterId) {
        this.theaterId = theaterId;
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
        if (!(object instanceof Movietheater)) {
            return false;
        }
        Movietheater other = (Movietheater) object;
        if ((this.masterid == null && other.masterid != null) || (this.masterid != null && !this.masterid.equals(other.masterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movietheater[ masterid=" + masterid + " ]";
    }
    
}
