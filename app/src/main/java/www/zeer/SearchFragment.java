package www.zeer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import www.zeer.SearchFragmentPackage.SearchItem;
import www.zeer.SearchFragmentPackage.SearchListAdapter;

/**
 * Created by othmane39 on 12/01/16.
 */
public class SearchFragment extends Fragment {

    private ListView search_list;
    private SearchItem[] search_result_p;



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

        search_result_p = new SearchItem[3];

        search_result_p[0] = new SearchItem("Khaled", "Ya Chaba", "Bilal", "Speed");
        search_result_p[1] = new SearchItem("Sploux", "Stoune", "Halazoune", "Image");
        search_result_p[2] = new SearchItem("Cheb Zehouani", "Sarda", "Dawi Khawi", "Image");

        search_list = (ListView) v.findViewById(R.id.search_list_view);
        search_list.setAdapter(new SearchListAdapter(getContext(), search_result_p));
        return v;
    }





}
