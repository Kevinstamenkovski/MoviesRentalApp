package app.netlify.stamenkovskikevin;

import java.util.ArrayList;
public class Movies {
    private String title;
    private int releaseDate;
    private String movieGenre;
    public Movies(String title, int releaseDate, String movieGenre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.movieGenre = movieGenre;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }


}

