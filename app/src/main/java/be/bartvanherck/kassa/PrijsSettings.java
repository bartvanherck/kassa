package be.bartvanherck.kassa;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class PrijsSettings extends AppCompatActivity {
    public  Integer prijsEuroLeft = 0;
    public  Integer prijsEuroMiddle = 0;
    public  Integer prijsEuroRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijs_settings);

        String prefs_name = MainActivity.PREFS_NAME;

        SharedPreferences settings = getSharedPreferences(prefs_name, 0);
        prijsEuroLeft = settings.getInt("prijsLeft", 0);
        prijsEuroMiddle = settings.getInt("prijsMiddle", 0);
        prijsEuroRight = settings.getInt("prijsRight", 0);

        setTextLeft();
        setTextMiddle();
        setTextRight();
    }

    public void setTextLeft(){
        EditText edit = (EditText) findViewById(R.id.editSettingsLeft);
        edit.setText(prijsEuroLeft.toString());
    }

    public int getNumberLeft(){
        EditText edit = (EditText) findViewById(R.id.editSettingsLeft);
        String prijs = edit.getText().toString();
        if (prijs.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(prijs);
    }

    public void setTextMiddle(){
        EditText edit = (EditText) findViewById(R.id.editSettingsMiddle);
        edit.setText(prijsEuroMiddle.toString());
    }

    public int getNumberMiddle(){
        EditText edit = (EditText) findViewById(R.id.editSettingsMiddle);
        String prijs = edit.getText().toString();
        if (prijs.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(prijs);
    }

    public void setTextRight(){
        EditText edit = (EditText) findViewById(R.id.editSettingsRight);
        edit.setText(prijsEuroRight.toString());
    }

    public int getNumberRight(){
        EditText edit = (EditText) findViewById(R.id.editSettingsRight);
        String prijs = edit.getText().toString();
        if (prijs.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(prijs);
    }

    public void actionPriceSettingsBack(View view) {
        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("prijsLeft", getNumberLeft());
        editor.putInt("prijsMiddle", getNumberMiddle());
        editor.putInt("prijsRight", getNumberRight());
        editor.commit();

        setResult(RESULT_OK);
        finish();
    }

}
