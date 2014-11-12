package edu.yale.cpsc112_lesson3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import android.os.StrictMode;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	    	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    	StrictMode.setThreadPolicy(policy); 

        super.onCreate(savedInstanceState);
        //Set the initial view of the app to be the stuff we created in activity_main.xml
		setContentView(R.layout.activity_main);
		
		//make WebView be the place where our program will output the image
		WebView webview = (WebView) findViewById(R.id.webView1);
		webview.loadUrl(CPSC112.getCatGif());

//    	CPSC112.processSalary(v.getText().toString());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}