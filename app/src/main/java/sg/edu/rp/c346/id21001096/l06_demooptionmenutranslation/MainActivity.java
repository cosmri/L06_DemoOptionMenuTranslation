package sg.edu.rp.c346.id21001096.l06_demooptionmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //other working code

        tvTranslatedText = findViewById(R.id.tvTranslatedText);
        tvTranslatedText2 = findViewById(R.id.tvTranslatedText2);
        registerForContextMenu(tvTranslatedText);//detect a long click //event handler //Trigger and listen to menu, under oncreate
        registerForContextMenu(tvTranslatedText2);


    }




    //handling menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, //not inside onCreate, a sibling
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");

        if(v == tvTranslatedText) {
            wordClicked = "hello";

        }

        else if(v == tvTranslatedText2) {
            wordClicked = "bye";
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            tvTranslatedText.setText("Hello");
            tvTranslatedText2.setText("Bye");

            return true; //menu item successfully handled
            //
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            tvTranslatedText.setText("Ciao");
            tvTranslatedText2.setText("Addio");

            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


}