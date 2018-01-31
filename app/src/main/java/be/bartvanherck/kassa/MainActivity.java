package be.bartvanherck.kassa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    public static Integer numberLeft = 0;
    public static Integer numberMiddle = 0;
    public static Integer numberRight = 0;

    public static final String PREFS_NAME = "BE.BARTVANHERCK.KASSA.GROENMULEURO";
    static final int SETTINGS_SAVED = 1;
    static final String EURO = "\u20ac";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateAllTextFields();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.prijssettings){
            Intent intent = new Intent(this, PrijsSettings.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.colorsettings){
            Intent intent = new Intent(this, ColorSettings.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void actionUpLeft(View view) {
        numberLeft = numberLeft + 1;
        updateAllTextFields();
    }

    public void actionDownLeft(View view)
    {
        numberLeft = numberLeft - 1;
        if (numberLeft < 0 ) {
            numberLeft = 0;
        }
        updateAllTextFields();
    }

    public void actionUpMiddle(View view) {
        numberMiddle = numberMiddle + 1;
        updateAllTextFields();
    }

    public void actionDownMiddle(View view)
    {
        numberMiddle = numberMiddle - 1;
        if (numberMiddle < 0){
            numberMiddle = 0;
        }
        updateAllTextFields();
    }

    public void actionUpRight(View view) {
        numberRight = numberRight + 1;
        updateAllTextFields();
    }

    public void actionDownRight(View view)
    {
        numberRight = numberRight - 1;
        if (numberRight < 0){
            numberRight = 0;
        }
        updateAllTextFields();
    }

    public void actionVolgende(View view)
    {
        numberLeft = 0;
        numberMiddle = 0;
        numberRight = 0;
        updateAllTextFields();
    }

    public void updateAllTextFields()
    {
        setTextLeft();
        setTextMiddle();
        setTextRight();
        setResultaat();
    }

    public void setResultaat(){
        Integer resultLeft = getMulLeft() * numberLeft;
        Integer resultMiddle = getMulMiddle() * numberMiddle;
        Integer resultRight = getMulRight() * numberRight;

        Integer calculated = resultLeft + resultMiddle + resultRight;
        Integer cents = calculated % 100;
        Integer euros = calculated / 100;

        setTextResultaat(euros, cents);
    }

    public void setTextLeft(){
        TextView txtNumber = (TextView) findViewById(R.id.txtLeft);
        txtNumber.setText(numberLeft.toString());

        LinearLayout left_layout = (LinearLayout) findViewById(R.id.layout_left_result);
        if (numberLeft > 5) {
            left_layout.setBackgroundColor(Color.rgb(255, 0, 0));
        }
    }

    public void setTextMiddle(){
        TextView txtNumber = (TextView) findViewById(R.id.txtMiddle);
        txtNumber.setText(numberMiddle.toString());
    }

    public void setTextRight(){
        TextView txtNumber = (TextView) findViewById(R.id.txtRight);
        txtNumber.setText(numberRight.toString());
    }

    public void setTextResultaat(Integer euros, Integer cents){
        TextView txtResultaat = (TextView) findViewById(R.id.txtResultaat);
        String resultaat;
        resultaat = euros.toString() + " " + EURO;
        if (cents != 0) {
            resultaat = resultaat + " " + cents.toString();
        }
        txtResultaat.setText(resultaat);
    }

    public Integer getMulLeft(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("prijsLeft", 0);
    }

    public Integer getMulMiddle(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("prijsMiddle", 0);
    }

    public Integer getMulRight(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("prijsRight", 0);
    }
}
