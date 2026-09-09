package WatchListInClass;

public class Main {
    public static void main(String[] args) {

        // Note: declared as the interface type, not the concrete class.
        WatchListInterface watchlist = new WatchList();

        watchlist.addMovie("The Matrix");
        watchlist.addMovie("Spirited Away");
        watchlist.addMovie("Blade Runner");

        // Expected: 3 movies listed, in the order added above
        watchlist.printWatchList();

        // Expected: replaces index 1 with "Spirited Away (1997)"
        watchlist.updateMovie(1, "Spirited Away (1997)");

        // Expected: True, since we just updated that index.
        boolean contains =watchlist.containsMovie("Spirited Away (1997)");
        System.out.println("Contains Spirited Away (1997)? " + contains);

        //Expected: False, since we replaced that movie title with a new one.
        contains = watchlist.containsMovie("Spirited Away");
        System.out.println("Contains Spirited Away? " + contains);

        // Expected: removes "The Matrix", returns true
        boolean removed = watchlist.removeMovie("The Matrix");
        System.out.println("Removed The Matrix? " + removed);

        // Expected: 2 movies remaining
        watchlist.printWatchList();
    }
}
