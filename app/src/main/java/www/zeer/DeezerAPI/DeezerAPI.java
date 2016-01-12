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
                        // Display the first 500 characters of the response string.
                        //Log.d("void", "Response is: " + response);
                        String line = "var checkForm = '00e4ab5e9c3b3755b87d83fd0958f95b';";
                        //Log.d("Test regexp", line.split("heck"));
                        String leftDelimiter = "var check";
                        String rightDelimiter = "m = '";
                        Integer leftDelimiterPos = response.indexOf(leftDelimiter);
                        Integer rightDelimiterPos = response.indexOf(rightDelimiter);
                        Log.d("Left pos", leftDelimiterPos.toString());
                        Log.d("Right pos", rightDelimiterPos.toString());
                        Log.d("Substring", "(" + response.substring(leftDelimiterPos, rightDelimiterPos) + ")");
                        //_APIToken = response.substring(response.indexOf("checkForm"), response.indexOf("Form"));
                        //Log.d("Token", "(" + _APIToken + ")");
                        //Log.d("Response lenght", "(" + response.length()+")");
                        //_APIToken = response.substring(response.indexOf("checkForm = '"), response.indexOf("'"));
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
