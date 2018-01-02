package myapplication.hfad.com.mp4;

/**
 * Created by han on 7/27/17.
 */


public class Song {


    private String songTittle;
    private int fileId ;

    
    public Song(String songTittle, int file) {
        this.songTittle = songTittle;
        fileId = file;
    }

    // string songTittle
    public String getSongTittle() {
        return songTittle;
    }

    public void setSongTittle(String songTittle) {
        this.songTittle = songTittle;
    }

    // int file
    public int getFile() {
        return fileId ;
    }

    public void setFile(int file) {
        fileId  = file;
    }





}
