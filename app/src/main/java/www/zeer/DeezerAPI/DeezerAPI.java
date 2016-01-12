package www.zeer.DeezerAPI;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import www.zeer.InitApplication;

/**
 * Created by root on 1/12/16.
 */
public class DeezerAPI {
    private String _APIToken; // the temporary API token

    public DeezerAPI(){
        _APIToken = "";
    }

    /* Fetch and updates the temporary API token */
    public void updateAPIToken(){
        Log.d("updateAPIToken()", "Updating temporary API token.");
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.deezer.com/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // First, we extract the line containing the token from the whole webpage
                        String tokenLineStartingPattern = "checkForm = '";
                        Integer tokenLinePosition = response.indexOf(tokenLineStartingPattern);
                        String tokenLine = response.substring(tokenLinePosition, tokenLinePosition+47);

                        // Second, we extract the 32 leters and numbers of the token from the line containing it
                        _APIToken = tokenLine.substring(tokenLine.indexOf("checkForm = '")+13, tokenLine.indexOf("';"));
                        Log.d("Deezer API token", "(" + _APIToken + ")");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("updateAPIToken()", "Error fetching API token!");
            }
        });
        // Add the request to the RequestQueue.
        InitApplication.getInstance().getRequestQueue().add(stringRequest);
    }

    /* Accessor */
    public String getAPIToken(){
        return this._APIToken;
    }


}
