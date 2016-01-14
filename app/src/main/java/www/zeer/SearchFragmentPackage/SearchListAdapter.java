package www.zeer.SearchFragmentPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import www.zeer.R;
import www.zeer.SearchFragment;

/**
 * Created by othmane39 on 14/01/16.
 */
public class SearchListAdapter extends BaseAdapter {

    SearchItem[] _search_items;
    private Context _context;

    private static LayoutInflater inflater=null;

    public SearchListAdapter(Context context, SearchItem search_items[]){
        _context = context;
        _search_items = search_items;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){ //Nb of elements (je pense)
        return _search_items.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder h = new Holder();
        final View row_view = inflater.inflate(R.layout.search_frag_list_item, null);
        h.song = (TextView) row_view.findViewById(R.id.song_name);
        h.album_artist = (TextView) row_view.findViewById(R.id.album_artist_name);
        h.song.setText(_search_items[position].get_song_name());
        h.album_artist.setText(new String(_search_items[position].get_album_name() + " - " + _search_items[position].get_artist_name()));

        row_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(_context, _search_items[position].toString(), Toast.LENGTH_LONG).show();
            }
        });


        return row_view;
    }


}
