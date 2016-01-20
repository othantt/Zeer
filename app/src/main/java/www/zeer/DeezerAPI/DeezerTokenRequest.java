package www.zeer.DeezerAPI;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.Map;

/**
 * Created by root on 20/01/16.
 */
public class DeezerTokenRequest extends StringRequest{

    String cookie_session;

    public DeezerTokenRequest(int method, String url, Response.Listener listener, Response.ErrorListener Errorlistener){
        super(method, url, listener, Errorlistener);
    }


    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        Response r = super.parseNetworkResponse(response);
        Map<String, String> responseHeaders = response.headers;
        cookie_session = responseHeaders.get("Set-Cookie");
        DeezerAPI.setCookies(cookie_session);
        Log.e("COOKI", cookie_session +"    cook" );
        return r;
    }

}
