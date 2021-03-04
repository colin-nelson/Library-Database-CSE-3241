import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Stores and provides functionality for information given by the user about
 * different types of media
 *
 * @author Jacob_Watson
 *
 */
public final class CheckPoint3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPoint3() {
    }

    /**
     * Adds a new artist to the artist list.
     *
     * @param artists
     *            the list of artists already entered
     * @param newArtist
     *            The new artist to add to the list
     */
    public static void addArtist(List<String> artists, String newArtist) {
        if (!newArtist.isEmpty()) {
            try {
                artists.add(newArtist);
            } catch (UnsupportedOperationException e) {
                System.err.println("This List doesnt support the add feature");
            } catch (NullPointerException e) {
                System.err.println("Null Value detected");
            }
        }
    }

    /**
     * Adds a new track to the track map.
     *
     * @param tracks
     *            the map of tracks already entered
     * @param newTrack
     *            The new track to add to the map
     * @param trackInfo
     *            The new info to add to the list
     */
    public static void addTrack(Map<String, List<String>> tracks,
            String newTrack, String artist, String trackLength) {
        List<String> trackInfo = new ArrayList<String>();
        trackInfo.add(artist);
        trackInfo.add(trackLength);
        if (!newTrack.isEmpty()) {

            try {
                tracks.put(newTrack, trackInfo);
            } catch (UnsupportedOperationException e) {
                System.err.println("This map doesnt support the put feature");
            } catch (NullPointerException e) {
                System.err.println("Null Value detected");
            }
        }
    }

    /**
     * Adds a new ordered media to the list of ordered media.
     *
     * @param orderedMedia
     *            Contains all info about all ordered media
     * @param newOrderedMedia
     *            Contains info about the new ordered media
     */
    public static void addOrderedMedia(List<List<String>> orderedMedia,
            String type, String copies, String price, String date) {
        List<String> newOrderedMedia = new ArrayList<String>();
        newOrderedMedia.add(type);
        newOrderedMedia.add(copies);
        newOrderedMedia.add(price);
        newOrderedMedia.add(date);
        try {
            orderedMedia.add(newOrderedMedia);
        } catch (UnsupportedOperationException e) {
            System.err.println("This List doesnt support the add feature");
        } catch (NullPointerException e) {
            System.err.println("Null Value detected");
        }
    }

    /**
     * Reads out info about a specific artist.
     *
     * @param artists
     *            Contains all info about all Artists
     * @param artist
     *            the artist being searched for
     * @param tracks
     *            the map of tracks already entered
     */
    public static void getArtistInfo(List<String> artists, String artist,
            Map<String, List<String>> tracks) {
        if (artists.contains(artist)) {
            System.out.println("Tracks made by" + artist);
            Iterator<String> iter = tracks.keySet().iterator();
            String trackName = iter.next();
            System.out.println("The tracks " + artist + " made:");
            while (iter.hasNext()) {
                if (tracks.get(trackName).contains(artist)) {
                    System.out.println(trackName);
                    trackName = iter.next();
                }
            }
            System.out.println(trackName);
        } else {
            System.out
                    .println(artist + " is not in the list of current artists");
        }
    }

    /**
     * Reads out info about a specific artist.
     *
     * @param track
     *            the track being searched for
     * @param tracks
     *            the map of tracks already entered
     */

    public static void getTrackInfo(Map<String, List<String>> tracks,
            String track) {
        if (tracks.containsKey(track)) {
            System.out.println("In the format of [artist, track length]:");
            System.out.println(tracks.get(track));
        } else {
            System.out.println("Track not found");

        }
    }

    /**
     * Prints all content from ordered media.
     *
     * @param orderedMedia
     *            Contains all info about all ordered media
     */

    public static void getOrderedMediaInfo(List<List<String>> orderedMedia) {
        Iterator<List<String>> iter = orderedMedia.iterator();
        List<String> media = iter.next();
        System.out.println(
                "In the format of [Type, # copies, price, ariveal date]");
        while (iter.hasNext()) {
            System.out.println(media);
            media = iter.next();

        }
        System.out.println(media);
    }

    /**
     * Replaces an artists name with a new name in the artists list and on all
     * tracks.
     *
     * @param artists
     *            Contains all info about all Artists
     * @param artist
     *            the artist being searched for
     * @param tracks
     *            the map of tracks already entered
     */

    public static void changeArtistInfo(List<String> artists, String artist,
            String replaceArtist, Map<String, List<String>> tracks) {
        if (artists.contains(artist)) {
            artists.remove(artist);
            artists.add(replaceArtist);
            Iterator<String> iter = tracks.keySet().iterator();
            String trackName = iter.next();
            while (iter.hasNext()) {
                if (tracks.get(trackName).contains(artist)) {
                    tracks.get(trackName).remove(0);
                    tracks.get(trackName).add(0, replaceArtist);
                    trackName = iter.next();
                }
            }
        } else {
            System.out
                    .println(artist + " is not in the list of current artists");
        }
    }

    /**
     * Deletes a given track from the list of tracks
     *
     * @param track
     *            The track to be deleted
     *
     * @param tracks
     *            the map of tracks already entered
     */

    public static void deleteTrackInfo(Map<String, List<String>> tracks,
            String track) {
        if (tracks.containsKey(track)) {
            tracks.remove(track);
        } else {
            System.out.println("No track by that name to delete");
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        List<String> artists = new ArrayList<String>();
        Map<String, List<String>> tracks = new HashMap<String, List<String>>();
        List<String> trackInfo = new ArrayList<String>();
        List<List<String>> orderedMedia = new ArrayList<List<String>>();
        String replaceArtist = "";
        String track = "";
        String artist = "";
        String trackLength = "";
        String type = "";
        String copies = "";
        String price = "";
        String date = "";
        int option = 0;
        while (option != 9) {
            System.out.println("Enter an integer corresponding to an option: ");
            System.out.println("1) Enter information for a new artist ");
            System.out.println("2) Enter information for a new track/song ");
            System.out.println(
                    "3) Enter information for a new ordered media item ");
            System.out.println("4) Retrive information about an artist ");
            System.out.println("5) Retrive information about a track ");
            System.out.println(
                    "6) Retrive information about an ordered media item ");
            System.out.println("7) Edit information about an artist ");
            System.out.println("8) Deleate an existing track ");
            System.out.println("9) Exit the program ");
            try {
                option = Integer.parseInt(in.readLine());
            } catch (IOException e) {
                System.err.println("Error reading from the console");
                return;
            } catch (NumberFormatException x) {
                System.err.println("Error: User must input a number");
                option = 0;
            }
            switch (option) {
                case 1:
                    try {
                        System.out.println("Enter the name of the new artist");
                        artist = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading from the console");
                    }
                    addArtist(artists, artist);
                    break;
                case 2:
                    try {
                        System.out.println("Enter the name of the new track");
                        track = in.readLine();
                        System.out.println(
                                "Enter the name of the artist of the new track");
                        artist = in.readLine();
                        System.out.println(
                                "Enter the length of the new of the new track");
                        trackLength = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading from the console");
                    }
                    addTrack(tracks, track, artist, trackLength);
                    trackInfo.clear();
                    break;
                case 3:
                    try {
                        System.out
                                .println("Enter the type of the ordered media");
                        type = in.readLine();
                        System.out.println(
                                "Enter the number of copies of the ordered media");
                        copies = in.readLine();
                        System.out.println(
                                "Enter the price of the ordered media");
                        price = in.readLine();
                        System.out.println(
                                "Enter the estamated date of arival of the ordered media");
                        date = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading from the console");
                    }
                    addOrderedMedia(orderedMedia, type, copies, price, date);
                    break;
                case 4:
                    System.out.println("Enter the artist to serch for");
                    try {
                        artist = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading from the console");
                    }
                    getArtistInfo(artists, artist, tracks);
                    break;
                case 5:
                    System.out.println("Enter the track to serch for");
                    try {
                        track = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading from the console");
                    }
                    getTrackInfo(tracks, track);
                    break;
                case 6:
                    getOrderedMediaInfo(orderedMedia);
                    break;
                case 7:
                    System.out.println(
                            "Enter the artist you want to change the name of");
                    try {
                        artist = in.readLine();
                        System.out.println(
                                "Enter the name you want to change it to");
                        replaceArtist = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading from the console");
                    }
                    changeArtistInfo(artists, artist, replaceArtist, tracks);
                    break;
                case 8:
                    System.out.println("Enter the track to delete");
                    try {
                        track = in.readLine();
                    } catch (IOException e) {
                        System.err.println("Error reading from the console");
                    }
                    deleteTrackInfo(tracks, track);
                    break;
                case 9:
                    return;
                default:
                    System.out
                            .println("Please enter an integer between 1 and 9");
            }
        }
    }
}