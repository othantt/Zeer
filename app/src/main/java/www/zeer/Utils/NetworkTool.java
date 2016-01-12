package www.zeer.Utils;

import android.app.Application;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import www.zeer.InitApplication;

/**
 * Created by root on 1/12/16.
 */
public class NetworkTool {
    public NetworkTool(){
    }

    public String makeGETRequest(String url) {
        String result;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("void", "Response is: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("void", "That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        InitApplication.getInstance().getRequestQueue().add(stringRequest);
        return "";
    }
}
