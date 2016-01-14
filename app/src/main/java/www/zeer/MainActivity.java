package www.zeer;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import www.zeer.Audio.Song;
import www.zeer.DeezerAPI.DeezerAPI;

public class MainActivity extends FragmentActivity {

    MainActivityPagerAdapter mMainActivityPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainActivityPagerAdapter =
                new MainActivityPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(mMainActivityPagerAdapter);

        Song testSong = new Song(94488788);
        testSong.getID();
    }
}
