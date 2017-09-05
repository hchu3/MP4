package myapplication.hfad.com.mp4;

/**
 * Created by han on 7/27/17.
 */

public class Song {


    private String songTittle;
    private int File;

    public Song(String songTittle, int file) {
        this.songTittle = songTittle;
        File = file;
    }

    public String getSongTittle() {
        return songTittle;
    }

    public void setSongTittle(String songTittle) {
        this.songTittle = songTittle;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }





}
