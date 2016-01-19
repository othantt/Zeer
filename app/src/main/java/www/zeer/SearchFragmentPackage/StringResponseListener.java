package www.zeer.SearchFragmentPackage;

import android.util.Log;

import com.android.volley.Response;

/**
 * Created by othmane39 on 15/01/16.
 */
public class StringResponseListener implements Response.Listener<String> {

    private String _APIToken;

    @Override
    public void onResponse(String response) {
        // First, we extract the line containing the token from the whole webpage
        String tokenLineStartingPattern = "checkForm = '";
        Integer tokenLinePosition = response.indexOf(tokenLineStartingPattern);
        String tokenLine = response.substring(tokenLinePosition, tokenLinePosition+47);

        // Second, we extract the 32 letters and numbers of the token from the line containing it
        _APIToken = tokenLine.substring(tokenLine.indexOf("checkForm = '")+13, tokenLine.indexOf("';"));
        Log.d("Deezer API token", "(" + _APIToken + ")");
    }
}
