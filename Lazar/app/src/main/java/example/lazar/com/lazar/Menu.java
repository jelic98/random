package example.lazar.com.lazar;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lazar on 02.01.2015.
 */
public class Menu extends ListActivity {

    String classes[] = {"MainActivity", "TextPlay", "Vragolan", "Email", "Camera",
            "Data", "example6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            Class ourClass = Class.forName("example.lazar.com.lazar." + cheese);
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()) {
           case R.id.action_about:

               Intent i = new Intent("com.thenewboston.travis.ABOUT");
               startActivity(i);

               break;
           case R.id.action_settings:
               Intent j = new Intent("com.thenewboston.travis.PREFS");
               startActivity(j);
               break;
           case R.id.exit:
               finish();
               break;
       }
       return false;
    }
}