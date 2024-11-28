/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJB;

import entity.Moviemaster;
import entity.Movietheater;
import entity.Theatermaster;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeshanpatel1510
 */
@Stateless
public class Moviebean implements MoviebeanLocal {
    
    @PersistenceContext(unitName = "mypu")
    EntityManager em;

    @Override
    public List<Movietheater> getAllMovies() {
        return em.createNamedQuery("Movietheater.findAll").getResultList();
    }
    @Override
    public List<Theatermaster> getAllTheaters() {
        return em.createNamedQuery("Theatermaster.findAll").getResultList();
    }

    @Override
    public void addMovie(Movietheater movie) {
        Moviemaster movies = em.find(Moviemaster.class, movie.getMovieId().getMovieId());
        Theatermaster theater = em.find(Theatermaster.class, movie.getTheaterId().getTheaterId());
        movies.getMovietheaterList().add(movie);
        theater.getMovietheaterList().add(movie);
        em.merge(movies);
        em.merge(theater);
        em.persist(movie);
    }

    @Override
    public void removeMovie(int movie) {
        Movietheater movietheater = em.find(Movietheater.class, movie);
        em.remove(movietheater);
    }

    @Override
    public List<Movietheater> searchMovie(int theater) {
        return em.createQuery("SELECT m FROM Movietheater m WHERE m.theaterId.theaterId = :tid").setParameter("tid", theater).getResultList();
    }

    
}
