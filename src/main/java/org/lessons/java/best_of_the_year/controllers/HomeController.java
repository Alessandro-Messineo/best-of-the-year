package org.lessons.java.best_of_the_year.controllers;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Alessandro");
        return "home";
    }

    private Movie[] getBestMovies() {
        return new Movie[] {
                new Movie(1, "Harry Potter"),
                new Movie(2, "La città incantata"),
                new Movie(3, "Star Wars"),
                new Movie(4, "Pulp Fiction"),
                new Movie(5, "Parasite")
        };
    }

    private Song[] getBestSongs() {
        return new Song[] {
                new Song(1, "Rosenrot"),
                new Song(2, "Toxicity"),
                new Song(3, "Radio"),
                new Song(4, "Adieu"),
                new Song(5, "Hunting Soul")
        };
    }

    @GetMapping("/movies")
    public String movies(Model model) {

        Movie[] movies = getBestMovies();
        String titoli = "";

        for (int i = 0; i < movies.length; i++) {
            titoli += movies[i].getTitolo();
            if (i < movies.length - 1) {
                titoli += ", ";
            }
        }

        model.addAttribute("titles", titoli);

        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {

        Song[] songs = getBestSongs();
        String titoli = "";

        for (int i = 0; i < songs.length; i++) {
            titoli += songs[i].getTitolo();
            if (i < songs.length - 1) {
                titoli += ", ";
            }
        }

        model.addAttribute("titles", titoli);
        
        return "songs";
    }

}
