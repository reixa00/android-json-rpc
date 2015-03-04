package com.axier.jsonrpc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.axier.jsonrpclibray.JSONRPCClient;
import com.axier.jsonrpclibray.JSONRPCException;
import com.axier.jsonrpclibray.JSONRPCParams;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONRPCClient client = JSONRPCClient.create("https://raw.githubusercontent.com/axierjhtjz/android-json-rpc/master/response.json", JSONRPCParams.Versions.VERSION_2);
                client.setConnectionTimeout(2000);
                client.setSoTimeout(2000);
                try {
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("user", "myuser");
                    jsonObj.put("password", "mypassword");
                    JSONObject responseObj = client.callJSONObject("login", jsonObj);
                    Log.d("MainActivity", responseObj.toString());
                } catch (JSONRPCException rpcEx) {
                    rpcEx.printStackTrace();
                } catch (JSONException jsEx) {
                    jsEx.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
