package www.zeer.Audio;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonArrayRequest;
import com.android.volley.request.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.ErrorListener;

import www.zeer.DeezerAPI.DeezerAPI;
import www.zeer.InitApplication;

/**
 * Created by root on 1/14/16.
 */
public class Song implements Response.Listener<JSONObject>, Response.ErrorListener{
    private int _id;
    private String _name;

    public Song(int songID){
        this._id = songID;
        fetchSongInfo(this._id);
    }

    private void fetchSongInfo(int songID){
        String url = "http://www.deezer.com/ajax/gw-light.php?api_version=1.0&api_token=" + DeezerAPI.getAPIToken() + "&input=3";
        Log.e("fetchSongInfo", url);

        HashMap<String, Integer> methodParameters = new HashMap<String, Integer>();
        methodParameters.put("sng_ids", songID);

        HashMap<String, String> postData = new HashMap<String, String>();
        postData.put("method", "song.getListData");
        postData.put("params", methodParameters.toString());

        JSONObject JSONRequestParameters = new JSONObject(postData);
        Log.e("fetchSongInfo", JSONRequestParameters.toString());




        JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.POST,url, JSONRequestParameters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TEST", response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ERROR", "Error: " + error.getMessage());

            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        InitApplication.getInstance().getRequestQueue().add(req);
        Log.e("song", "request added");
    }

    @Override
    public void onResponse(JSONObject response){
        Log.e("RESP", response.toString());
    }

    @Override
    public void onErrorResponse(VolleyError error){

    }

    public int getID(){
        return this._id;
    }

    public String getName(){
        return this._name;
    }
}
