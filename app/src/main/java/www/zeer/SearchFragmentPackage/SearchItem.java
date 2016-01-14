package www.zeer.SearchFragmentPackage;

/**
 * Created by othmane39 on 14/01/16.
 */
public class SearchItem {
    private String _song_name;
    private String _album_name;
    private String _artist_name;
    private String _image_link;

   public SearchItem(String songName, String albumName, String artistName, String image_link){
       _song_name = songName;
       _album_name = albumName;
       _artist_name = artistName;
       _image_link = image_link;
   }

    public String get_song_name() {
        return _song_name;
    }

    public String get_album_name() {
        return _album_name;
    }

    public String get_artist_name(){
        return _artist_name;
    }

    public String get_image_link() {
        return _image_link;
    }

    @Override
    public String toString() {
        return "SearchItem{" +
                "_song_name='" + _song_name + '\'' +
                ", _album_name='" + _album_name + '\'' +
                ", _artist_name='" + _artist_name + '\'' +
                ", _image_link='" + _image_link + '\'' +
                '}';
    }
}
