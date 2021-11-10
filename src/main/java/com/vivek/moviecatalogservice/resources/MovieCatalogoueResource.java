package com.vivek.moviecatalogservice.resources;

import com.vivek.moviecatalogservice.models.CatalogItem;
import com.vivek.moviecatalogservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogoueResource {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.movie.url}")
    String movieUrl;

    @Value("${api.movie.port}")
    String movieUrlPort;

    @RequestMapping("/{userId}")
    public ResponseEntity<String> getCatalog(@PathVariable("userId") String userId){

        String fullUrl = movieUrl+":"+movieUrlPort+"/movie/"+userId;

        Movie movie = null;
        try {
            movie = restTemplate.getForObject(fullUrl,Movie.class);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
        }

//        return Collections.singletonList(
//                new CatalogItem("Avengers","a supe star movies which saves the world",5)
//        );
        return new ResponseEntity<String>(movie.getMovieName(),HttpStatus.OK);
    }
}
