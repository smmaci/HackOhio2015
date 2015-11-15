package io.github.smmaci.godm;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class DiceRoller extends AppCompatActivity {

    //public dice_roller_click_listener myFabListener = new dice_roller_click_listener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NumberPicker getNum = (NumberPicker)findViewById(R.id.dice_roller_sides);
                int numSides = getNum.getValue();//determine number of sides on die

                getNum = (NumberPicker)findViewById(R.id.dice_roller_numDice);
                int numDice = getNum.getValue();//determine number of dice to roll

                int roll = 0;
                for(int i = 0; i < numDice; i++) {
                    Random r = new Random();
                    roll += r.nextInt(numSides - 1) + 1;//get roll
                }//add rolls 'sides' times

                TextView resultsTextView = (TextView)findViewById(R.id.resultView);
                resultsTextView.setText("Result: "+roll);
            }
        });


        NumberPicker numDice = (NumberPicker)findViewById(R.id.dice_roller_numDice);
        numDice.setMaxValue(100);
        numDice.setMinValue(0);
        numDice.setEnabled(true);

        NumberPicker sides = (NumberPicker)findViewById(R.id.dice_roller_sides);
        sides.setMaxValue(100);
        sides.setMinValue(2);
        sides.setEnabled(true);


    }

//    public static class dice_roller_click_listener implements DialogInterface.OnClickListener{
//        public void onClick(DialogInterface dialogInterface, int num)
//        {
//
//        }
//        public dice_roller_click_listener(){
//
//        }
//        NumberPicker getNum = (NumberPicker)findViewById(R.id.dice_roller_sides);
//        int numSides = getNum.getValue();//determine number of sides on die
//
//        getNum = (NumberPicker)findViewById(R.id.dice_roller_numDice);
//        int numDice = getNum.getValue();//determine number of dice to roll
//
//        Random r = new Random();
//        int roll = r.nextInt(numSides - 1)+1;
//    }
//    public void fabClick(){
//        NumberPicker getNum = (NumberPicker)findViewById(R.id.dice_roller_sides);
//        int numSides = getNum.getValue();//determine number of sides on die
//
//        getNum = (NumberPicker)findViewById(R.id.dice_roller_numDice);
//        int numDice = getNum.getValue();//determine number of dice to roll
//
//        int roll = 0;
//        for(int i = 0; i < numSides; i++) {
//            Random r = new Random();
//            roll += r.nextInt(numSides - 1) + 1;//get roll
//        }//add rolls 'sides' times
//
//        TextView resultsTextView = (TextView)findViewById(R.id.resultView);
//        resultsTextView.setText(resultsTextView.toString()+" "+roll);
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice_roller, menu);
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
