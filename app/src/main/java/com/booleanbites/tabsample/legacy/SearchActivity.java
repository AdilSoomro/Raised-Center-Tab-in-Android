package com.booleanbites.tabsample.legacy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.booleanbites.tabsample.R;

/**
 * @author Adil Soomro
 *
 */
public class SearchActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_actvity);
        
    }
    public void doSearch(View s)
    {
    	Toast.makeText(this, "I lied, I love KUNG FUuuuuuuuuUUuuu...!!", Toast.LENGTH_LONG).show();
    }
}
