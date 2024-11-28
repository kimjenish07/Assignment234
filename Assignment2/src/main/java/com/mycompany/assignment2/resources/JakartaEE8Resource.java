package com.mycompany.assignment2.resources;

import EJB.MoviebeanLocal;
import entity.Movietheater;
import entity.Theatermaster;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    @EJB MoviebeanLocal ejb;
    
    @GET
    @Path("/movies")
    @Produces("application/json")
    public List<Movietheater> getAllMovies(){
        return ejb.getAllMovies();
    }
    
    @GET
    @Path("/theaters")
    @Produces("application/json")
    public List<Theatermaster> getAllTheaters(){
        return ejb.getAllTheaters();
    }    
    
    @GET
    @Path("/movies/search/{theaterid}")
    @Produces("application/json")
    public List<Movietheater> searchMovies(@PathParam("theaterid") int theaterid){
        return ejb.searchMovie(theaterid);
    }

    @POST
    @Path("/movies/add")
    @Consumes("application/json")
    public void addMovie(Movietheater movietheater){
        ejb.addMovie(movietheater);
    }

    @DELETE
    @Path("/movies/delete/{movieid}")
    public void deleteMovie(int movieid){
        ejb.removeMovie(movieid);
    }    
}