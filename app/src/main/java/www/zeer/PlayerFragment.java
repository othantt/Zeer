package www.zeer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by othmane39 on 12/01/16.
 */
public class PlayerFragment extends Fragment {

    public static PlayerFragment newInstance() {

        Bundle args = new Bundle();
        args.putString("FragName", PlayerFragment.class.getName());

        PlayerFragment fragment = new PlayerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.player_fragment, container, false);
        return v;
    }
}
