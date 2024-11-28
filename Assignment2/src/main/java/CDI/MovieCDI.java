/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDI;

import Client.MyClient;
import entity.Movietheater;
import entity.Theatermaster;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.GenerationType;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jeshanpatel1510
 */
@Named(value = "movieCDI")
@RequestScoped
public class MovieCDI {

    @Inject MyClient cl;
    Response rs;
    List<Movietheater> movies;
    GenericType<List<Movietheater>> gmovies;
    List<Theatermaster> theaters;
    GenericType<List<Theatermaster>> gtheaters;
    
    public MovieCDI() {
        movies = new ArrayList<>();
        theaters = new ArrayList<>();
        gmovies = new GenericType<List<Movietheater>>(){};
        gtheaters = new GenericType<List<Theatermaster>>(){};
    }

    public List<Movietheater> getMovies() {
        rs = cl.getAllMovies(Response.class);
        movies = rs.readEntity(gmovies);
        return movies;
    }

    public void setMovies(List<Movietheater> movies) {
        this.movies = movies;
    }

    public List<Theatermaster> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theatermaster> theaters) {
        this.theaters = theaters;
    }
    
    
}
