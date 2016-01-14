package www.zeer.Audio;

import android.util.Log;

import www.zeer.DeezerAPI.DeezerAPI;

/**
 * Created by root on 1/14/16.
 */
public class Song {
    private int _id;
    private String _name;

    public Song(int songID){
        this._id = songID;
        fetchSongInfo(this._id);
    }

    private void fetchSongInfo(int songID){
        String url = "http://www.deezer.com/ajax/gw-light.php?api_version=1.0&api_token=" + DeezerAPI.getAPIToken() + "&input=3";
        Log.d("fetchSongInfo", url);
    }

    public int getID(){
        return this._id;
    }

    public String getName(){
        return this._name;
    }
}
