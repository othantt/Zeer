package www.zeer;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.VolleyTickle;

import www.zeer.DeezerAPI.DeezerAPI;

public class StartLoading extends FragmentActivity implements Response.Listener{

    private Context _contex;

    public StartLoading(){
        super();
        _contex = this;
    }
    public StartLoading(Context c){
        super();
        _contex = c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_loading);

        DeezerAPI.updateAPIToken(this);

        //Intent i = new Intent(this, MainActivity.class);
        //startActivity(i);
    }

    @Override
    public void onResponse(Object response) {


        Log.e("updateAPIToken", "200");
        String tokenLineStartingPattern = "checkForm = '";
        Integer tokenLinePosition = ((String) response).indexOf(tokenLineStartingPattern);
        String tokenLine = ((String) response).substring(tokenLinePosition, tokenLinePosition + 47);
        // Second, we extract the 32 letters and numbers of the token from the line containing it
        DeezerAPI.setAPIToken(tokenLine.substring(tokenLine.indexOf("checkForm = '") + 13, tokenLine.indexOf("';")));
        Log.d("Deezer API token", "(" + DeezerAPI.getAPIToken() + ")");


        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
