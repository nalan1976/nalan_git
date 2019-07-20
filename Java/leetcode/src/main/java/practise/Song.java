package practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        Set<Song> set = new HashSet<>();
        set.add(this);

        Song next = this.nextSong;

        while (next != null){
            if(set.contains(next)) return true;
            set.add(next);
            next  = next.nextSong;
        }

        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
