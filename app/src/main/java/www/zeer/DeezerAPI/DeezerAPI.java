package www.zeer.DeezerAPI;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;

import www.zeer.InitApplication;
import www.zeer.MainActivity;
import www.zeer.StartLoading;

/**
 * Created by root on 1/12/16.
 */
public class DeezerAPI {
    private static String _APIToken ;
    //private StartLoading start;// the temporary API token
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

        /*
        RequestTickle mRequestTickle = VolleyTickle.newRequestTickle(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.deezer.com/", null, null);
        mRequestTickle.add(stringRequest);
        NetworkResponse networkResponse = mRequestTickle.start();

        if (networkResponse.statusCode == 200) {
            Log.e("updateAPIToken", "200");
            String response = VolleyTickle.parseResponse(networkResponse);
            String tokenLineStartingPattern = "checkForm = '";
            Integer tokenLinePosition = response.indexOf(tokenLineStartingPattern);
            String tokenLine = response.substring(tokenLinePosition, tokenLinePosition+47);

            // Second, we extract the 32 letters and numbers of the token from the line containing it
            DeezerAPI.setAPIToken(tokenLine.substring(tokenLine.indexOf("checkForm = '")+13, tokenLine.indexOf("';")));
            Log.d("Deezer API token", "(" + DeezerAPI.getAPIToken() + ")");
        }
        else{
            Log.e("updateAPIToken", "not 200");
        }
        */
    }

    /* Accessor */


    public static String getAPIToken(){
        return _APIToken;
    }

    public static void setAPIToken(String token) {
        _APIToken = token;
    }
}
