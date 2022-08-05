package persistence;

import MusicUtil.Playlist;

import java.io.*;

/**
 * PersistenceService implements persistence for playlists, so that playlists created by a user
 * are stored and will be available the next time the user logs in.
 *
 * @author Jennifer Xi
 * @version 1.0
 * @since 2022-08-03
 */

public class PersistenceService {
    private static PersistenceService persistenceService;

    private PersistenceService(){}

    /**
     * Implements the Singleton design pattern to ensure that this is the only point of access
     * to the persistence service for areas in the program that use it
     *
     * @return persistenceService instance
     */
    public static PersistenceService getPersistenceService(){
        if(persistenceService==null){
            persistenceService = new PersistenceService();
        }
        return persistenceService;
    }

    /**
     * Persists playlists as objects into the file system and uses the attribute
     * name as the file name.
     *
     * @param playlist object
     */

    public void persistPlayList(Playlist playlist){
        try {
            FileOutputStream f = new FileOutputStream(new File(playlist.getName()));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(playlist);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file:"+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error initializing stream:"+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Get persisted playlist by the playlist name from the file system
     *
     * @param name playlist name
     * @return playlist object
     */

    public Playlist getPlayListByName(String name){
        try {
            FileInputStream finput = new FileInputStream(new File(name));
            ObjectInputStream oinput = new ObjectInputStream(finput);

            Playlist playlist = (Playlist) oinput.readObject();

            oinput.close();
            finput.close();
            return playlist;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file:"+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error initializing stream:"+e.getMessage());
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find class:"+e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
