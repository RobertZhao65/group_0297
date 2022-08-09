 package MusicUtil;

import Commands.CommandController;
import Driver.AccountManager;
import Driver.Program;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.io.IOException;
import java.util.*;

 /**
  * Manages songs
  */

 public class SongManager {
    private static ArrayList<Song> allSongs = new ArrayList<>();
    private static Hashtable<Integer, Song> songMap = new Hashtable<>();
    private static HashMap <String, List<Song> > libraryMap = new HashMap<>();
    private static Integer songCount = 0;
    private File songFile = new File("phase2/Music/songs");

     /**
      * Add song to the list containing all songs
      *
      * @param song song to be added
      */
    public static void addSong(Song song){
        song.setId(songCount);
        allSongs.add(song);
        songMap.put(songCount, song);
        songCount++;
    }

     /**
      * Get all songs
      *
      * @return the list containing all songs
      */
    public List<Song> getAllSongs(){
        return allSongs;
    }

     /**
      * Add or Remove song to music library
      *
      * @param songIndex the index of song in the library
      * @param libraryName name of the library
      * @param command 0 represents to remove the index of song in the library and
      *                1 represents to add the index of song in the library
      */
    public static void editSongToLibrary(Integer songIndex, String libraryName, Integer command){
        if (command==0 || checkIfSongExists(songIndex,libraryName)){
            libraryMap.get(libraryName).remove(songMap.get(songIndex));
        } else if (command==1 || !checkIfSongExists(songIndex, libraryName)){
            libraryMap.get(libraryName).add(songMap.get(songIndex));
        }
    }

//     /**
//      * Add song to music library
//      *
//      * @param songIndex the index of song in the library
//      * @param libraryName name of library
//      */
//    public static void addSongToLibrary(Integer songIndex, String libraryName){
//        boolean isExist = checkIfSongExists(songIndex, libraryName);
//        if(!isExist) {
//            libraryMap.get(libraryName).add(songMap.get(songIndex));
//        }
//    }
//
//     /**
//      * Remove song from music library
//      *
//      * @param songIndex the index of song in the library
//      * @param libraryName name of library
//      */
//     public static void removeSongFromLibrary(Integer songIndex, String libraryName){
//         boolean isExist = checkIfSongExists(songIndex, libraryName);
//         if(isExist) {
//             libraryMap.get(libraryName).remove(songMap.get(songIndex));
//         }
//     }

     /**
      * Check whether song exists
      *
      * @param songIndex the index of song in the library
      * @param libraryName name of library
      * @return true if song exists
      */
     public static boolean checkIfSongExists(Integer songIndex, String libraryName) {
         List<Song> songList = libraryMap.get(libraryName);
         if(songList==null) {
             Library newLibrary = new Library();
             newLibrary.setName(libraryName);
             songList= new ArrayList<>();
             libraryMap.put(libraryName, songList);
         }
         boolean isExist =false;
         for(Song song: songList){
             if (song.getId() == songIndex) {
                 isExist = true;
                 break;
             }
         }
         return isExist;
     }

     /**
      * Get songs from music library
      *
      * @param library name of the library
      * @return the list of songs from that library
      */
     public static List<Song> getSongsFromLibrary(String library){
        return libraryMap.get(library);
     }


     public void initializeSongs() throws Exception{
        try{
            for(File file : Objects.requireNonNull(songFile.listFiles())){
                List<String> info = getInfo(new Mp3File(file));
                Song song = new Song(info.get(0), info.get(1), info.get(2), info.get(3), file.getPath());
                addSong(song);
            }

        }
        catch(NullPointerException e){
            System.out.println("song file empty...");
        }
     }

     private List<String> getInfo(Mp3File file){
        List<String> info = new ArrayList<>();
        if(file.hasId3v2Tag()){
            ID3v2 tag = file.getId3v2Tag();
            info.add(tag.getTitle());
            info.add(tag.getAlbum());
            info.add(tag.getArtist());
            info.add(tag.getGenreDescription());
        }
        return info;
     }

     // for testing purposes
     public static void main(String[] args) throws IOException {
        Song song1 = new Song("song1");
        Song song2 = new Song("song2");
        Song song3 = new Song("song3");
        SongManager.addSong(song1);
        SongManager.addSong(song2);
         SongManager.addSong(song3);
         String libraryName = "library 1";
         SongManager.editSongToLibrary(song1.getId(), libraryName,1);
         SongManager.editSongToLibrary(song2.getId(), libraryName,1);
         SongManager.editSongToLibrary(song3.getId(), libraryName,1);
         for(Song song:SongManager.getSongsFromLibrary(libraryName)){
             System.out.println("Song name:"+ song.getName());
         }
         SongManager.editSongToLibrary(song3.getId(), libraryName,0);
         for(Song song:SongManager.getSongsFromLibrary(libraryName)){
             System.out.println("Song name:"+ song.getName());
         }
     }


}
