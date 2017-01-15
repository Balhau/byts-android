package net.balhau.android.byts.adaptors.domain.yts;

/**
 * Created by balhau on 1/14/17.
 */

public class YtsEntry {

    private String imageURL;
    private String description;
    private YtsEntryResource imdb;
    private YtsEntryResource rottenTomatoesCritics;
    private YtsEntryResource getRottenTomatoesAudience;
    private int likes;
    private int year;

    public YtsEntry(){}

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public YtsEntryResource getImdb() {
        return imdb;
    }

    public void setImdb(YtsEntryResource imdb) {
        this.imdb = imdb;
    }

    public YtsEntryResource getRottenTomatoesCritics() {
        return rottenTomatoesCritics;
    }

    public void setRottenTomatoesCritics(YtsEntryResource rottenTomatoesCritics) {
        this.rottenTomatoesCritics = rottenTomatoesCritics;
    }

    public YtsEntryResource getGetRottenTomatoesAudience() {
        return getRottenTomatoesAudience;
    }

    public void setGetRottenTomatoesAudience(YtsEntryResource getRottenTomatoesAudience) {
        this.getRottenTomatoesAudience = getRottenTomatoesAudience;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
