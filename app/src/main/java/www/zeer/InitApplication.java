package www.zeer;

import android.app.Application;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by root on 1/12/16.
 */
public class InitApplication extends Application{
    private static InitApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Log.e("void", "Response is: ONCREATE" );
    }

    public static synchronized InitApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        Log.e("void", "Response is: REQQUE");
        return Volley.newRequestQueue(getApplicationContext());
    }
}
