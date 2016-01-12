package www.zeer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by othmane39 on 12/01/16.
 */
public class SearchFragment extends Fragment {

    public static SearchFragment newInstance() {

        Bundle args = new Bundle();
        args.putString("FragName", SearchFragment.class.getName());

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment, container, false);
        return v;
    }





}
