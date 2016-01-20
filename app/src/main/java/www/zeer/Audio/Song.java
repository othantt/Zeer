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

import www.zeer.DeezerAPI.DeezerAPI;
import www.zeer.InitApplication;

/**
 * Created by root on 1/14/16.
 */
public class Song {
    private Integer _id;
    private String _name;

    public Song(int songID){
        this._id = songID;
        try {
            fetchSongInfo(this._id);
        } catch (JSONException e){};
    }

    private void fetchSongInfo(int songID) throws JSONException{
        String url = "http://www.deezer.com/ajax/gw-light.php?api_version=1.0&api_token=" + DeezerAPI.getAPIToken() + "&input=3";
        Log.e("fetchSongInfo", url);

        JSONArray JSONRequestParameters = new JSONArray("[{\"method\":\"song.getListData\",\"params\":{\"sng_ids\":[" + this._id.toString() + "]}}]");
        Log.e("fetchSongInfo", JSONRequestParameters.toString());

        JsonArrayRequest req = new JsonArrayRequest(
                Request.Method.POST,url, JSONRequestParameters,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("fetchSongInfo:response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("ERROR", "Error: " + error.getMessage());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                //headers.put("Host", "www.deezer.com");
                headers.put("Cookie", DeezerAPI.getSessionCookie()); // session cookie must be set here
                return headers;
            }
        };
        InitApplication.getInstance().getRequestQueue().add(req);
    }

    public int getID(){
        return this._id;
    }

    public String getName(){
        return this._name;
    }
}
