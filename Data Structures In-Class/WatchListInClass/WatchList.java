package WatchListInClass;
import java.util.ArrayList;

public class WatchList implements WatchListInterface {
    private ArrayList<String> movies;

    //Instantiates the movies ArrayList to an empty list.
    public WatchList() {
        movies = new ArrayList<String>();
    }

    //Takes a String title and returns nothing. Single line, add title to the end of the list.
    public void addMovie(String title) {
        movies.add(title);
    }
    //Removes a movie by title. Returns true if it was removed, false if the movie wasn't found.
    public boolean removeMovie(String title) {
        return movies.remove(title);
    }
    //Updates a movie using the ArrayList.set meothod.
    //Replaces the old title at the index with the new title.
    //Could return the old title via the set method, but we don't need to implement that.
    public void updateMovie(int index, String newTitle) {
        movies.set(index, newTitle);
    }
    //Gets the movie using the ArrayList.get method.
    public String getMovie(int index) {
        return movies.get(index);
    }
    //Uses the ArrayList.size method to return the # of movvies in the list, rather than coding an iteration loop.
    public int getSize() {
        return movies.size();
    }
    //Prints the watchlist in the format index: title, one per line.
    //Uses getSize & getMovie methods we created.
    public void printWatchList() {
        for (int i= 0; i < getSize(); i++) {
            System.out.println(i+": "+getMovie(i));
        }
    }
    public boolean containsMovie(String title) {
        return movies.contains(title);
    }
} 

