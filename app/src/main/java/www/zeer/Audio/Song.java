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

import www.zeer.DeezerAPI.CrypterTool;
import www.zeer.DeezerAPI.DeezerAPI;
import www.zeer.InitApplication;

/**
 * Created by root on 1/14/16.
 */
public class Song {
    private String _id;
    private String _md5;
    private String _title;
    private String _mediaVersion;
    private String _quality;
    private String _fileSize;

    public Song(String songID){
        try {
            fetchSongInfo(songID);
        } catch (JSONException e){

        };
    }

    private void fetchSongInfo(final String songID) throws JSONException{
        String url = "http://www.deezer.com/ajax/gw-light.php?api_version=1.0&api_token=" + DeezerAPI.getAPIToken() + "&input=3";
        Log.e("fetchSongInfo", url);

        JSONArray JSONRequestParameters = new JSONArray("[{\"method\":\"song.getListData\",\"params\":{\"sng_ids\":[" + songID.toString() + "]}}]");
        Log.e("fetchSongInfo", JSONRequestParameters.toString());

        JsonArrayRequest req = new JsonArrayRequest(
                Request.Method.POST,url, JSONRequestParameters,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("fetchSongInfo:response", response.toString());
                        try {
                            //Log.e("parsed", response.getJSONObject(0).get("results").toString());
                            JSONObject root = response.getJSONObject(0);
                            Log.e("root", root.toString());
                            Object results = root.get("results");
                            Log.e("results" , ((JSONObject)results).toString());
                            Object data = ((JSONObject) results).get("data");
                            Log.e("data", data.toString());
                            JSONObject datas = ((JSONArray)data).getJSONObject(0);
                            Log.e("datas", datas.toString());

                            _id = songID.toString();
                            _md5 = datas.getString("MD5_ORIGIN");
                            _title = datas.getString("SNG_TITLE");
                            _mediaVersion = datas.getString("MEDIA_VERSION");

                            if(datas.getString("FILESIZE_MP3_320") != "0")
                            {
                                _quality = "3";
                                _fileSize = datas.getString("FILESIZE_MP3_320");
                            }
                            else
                            {
                                _quality = "1";
                                _fileSize = datas.getString("FILESIZE_MP3_128");
                            }

                            Log.e("MD5", _md5);
                            Log.e("SNG_TITLE", _title);

                            Log.e("songLinkReceived", DeezerAPI.getSongDownloadURL(_id, _quality, _md5, _mediaVersion));
                        } catch (JSONException e){
                            Log.e("JSON parse", "Error parsing JSON");
                            e.printStackTrace();
                        }
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
                headers.put("Cookie", DeezerAPI.getSessionCookie()); // session cookie must be set here
                Log.e("getHeaders()", headers.toString());
                return headers;
            }
        };
        InitApplication.getInstance().getRequestQueue().add(req);
    }

    public String getID(){
        return this._id;
    }

    public String getTitle(){
        return _title;
    }
}
