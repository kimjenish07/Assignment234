/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJB;

import entity.Movietheater;
import entity.Theatermaster;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeshanpatel1510
 */
@Local
public interface MoviebeanLocal {
    List<Movietheater> getAllMovies();
    List<Theatermaster> getAllTheaters();
    void addMovie(Movietheater movie);
    void removeMovie(int movie);
    List<Movietheater> searchMovie(int theater);
}
