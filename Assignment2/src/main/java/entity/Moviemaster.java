/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jeshanpatel1510
 */
@Entity
@Table(name = "moviemaster", catalog = "assign", schema = "")
@NamedQueries({
    @NamedQuery(name = "Moviemaster.findAll", query = "SELECT m FROM Moviemaster m"),
    @NamedQuery(name = "Moviemaster.findByMovieId", query = "SELECT m FROM Moviemaster m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Moviemaster.findByMovieName", query = "SELECT m FROM Moviemaster m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "Moviemaster.findByReleaseDate", query = "SELECT m FROM Moviemaster m WHERE m.releaseDate = :releaseDate"),
    @NamedQuery(name = "Moviemaster.findByDuration", query = "SELECT m FROM Moviemaster m WHERE m.duration = :duration"),
    @NamedQuery(name = "Moviemaster.findByGenre", query = "SELECT m FROM Moviemaster m WHERE m.genre = :genre")})
public class Moviemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movieId")
    private Integer movieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "movieName")
    private String movieName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "releaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "genre")
    private String genre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private List<Movietheater> movietheaterList;

    public Moviemaster() {
    }

    public Moviemaster(Integer movieId) {
        this.movieId = movieId;
    }

    public Moviemaster(Integer movieId, String movieName, Date releaseDate, int duration, String genre) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genre = genre;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviemaster)) {
            return false;
        }
        Moviemaster other = (Moviemaster) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Moviemaster[ movieId=" + movieId + " ]";
    }
    
}
