package www.zeer.DeezerAPI;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;

import www.zeer.InitApplication;
import www.zeer.StartLoading;

/**
 * Created by root on 1/12/16.
 */
public class DeezerAPI {
    private static String _APIToken ; // the temporary API token

    /* Fetch and updates the temporary API token */
    public static void updateAPIToken(StartLoading start){
        Log.d("updateAPIToken()", "Updating temporary API token.");
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.deezer.com/",
                start, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("updateAPIToken()", "Error fetching API token!");
            }
        });
        // Add the request to the RequestQueue.
        InitApplication.getInstance().getRequestQueue().add(stringRequest);
    }

    public static String getAPIToken(){
        return _APIToken;
    }

    public static void setAPIToken(String token) {
        _APIToken = token;
    }
}
