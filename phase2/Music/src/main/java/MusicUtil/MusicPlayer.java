package MusicUtil;
import jaco.mp3.player.MP3Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class MusicPlayer{
    private Playlist currPlaylist;
    private List<Song> currQueue;
    private Song currSong;
    public int currIndex = 0;
    private boolean repeat = false;
    private MP3Player player;

    public void startPlayback(Playlist playlist){
        currQueue = playlist.getMusics();
        do{
            while(currIndex < playlist.getMusics().size()){
                currSong = currQueue.get(currIndex);
                File file = new File(currSong.getFilepath());
                player = new MP3Player(file);
                player.play();
                while(!player.isStopped()){
                    continue;
                }
                currIndex++;
            }
        }
        while(repeat);
    }

    public void skipForward(){
        if(currIndex == currQueue.size() - 1){
            currIndex = -1;
            player.stop();
        }
        else{
            player.stop();
        }
    }

    public void skipBackward(){
        if(currIndex == 0){
            currIndex = currQueue.size() - 2;
            player.stop();
        }
        else{
            currIndex--;
            currIndex--;
            player.stop();
        }
    }

    public void togglePause(){
        if(player.isPaused()){
            player.play();
        }
        else{
            player.pause();
        }
    }

    public void toggleRepeat(){
        repeat = !repeat;
    }

    public String currentlyPlaying(){
        return currSong.artistTitleAlbum();
    }

    public boolean isPaused(){
        return player.isPaused();
    }

    public void shuffle(){
        Collections.shuffle(currQueue);
        currIndex = -1;
        player.stop();
    }

    public String displayQueue(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < currQueue.size(); i++) {
            if(i == currIndex){
                result.append(currQueue.get(i).artistTitleAlbum()).append(" <- you are here \n");
            }
            else{
                result.append(currQueue.get(i).artistTitleAlbum()).append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CustomPlaylist p = new CustomPlaylist("test", "ben");
        Song s1 = new Song("Pay No Mind", "Adventure (Deluxe)", "Madeon", "EDM", "songs/05 - Pay No Mind.mp3");
        Song s2 = new Song("Untitled world", "Untitled world", "ReoNa", "JPop", "songs/ReoNa - Untitled world.mp3");
        Song s3 = new Song("Lemon", "Lemon", "Kenshi Yonezu", "JPop", "songs/Kenshi Yonezu - Lemon.mp3");
        ArrayList<Song> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        p.add(list);
        Scanner in = new Scanner(System.in);
        String input = "";
        MusicPlayer player = new MusicPlayer();

        Runnable task = () -> {
            player.startPlayback(p);
        };
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("ohno");
        while(!input.equals("stop")){
            input = in.nextLine();
            if(input.equals("ff")){
                player.skipForward();
            }
            if(input.equals("bb")){
                player.skipBackward();
            }
            if(input.equals("what")){
                System.out.println(player.currentlyPlaying());
            }
            if(input.equals("r")){
                player.toggleRepeat();
            }
            if(input.equals("p")){
                player.togglePause();
            }
            if(input.equals("q")){
                System.out.println(player.displayQueue());
            }
            if(input.equals("s")){
                player.shuffle();
            }
            System.out.println(player.currIndex);
        }
    }
}
