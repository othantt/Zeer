package www.zeer;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;

/**
 * Created by othmane39 on 12/01/16.
 */
public class MainActivityPagerAdapter extends FragmentPagerAdapter {

    private static int FRAG_NUM = 3;
    public MainActivityPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount(){
        return FRAG_NUM;
    }

    @Override
    public Fragment getItem(int position){

        Log.e("POS", ""+position);
        if(position == 1)
            return SearchFragment.newInstance();
        else if(position == 0)
            return PlayerFragment.newInstance();
        else if(position == 2)
            return MusicLibraryFragment.newInstance();
        return null;
    }

}
