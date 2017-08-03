package be.bartvanherck.kassa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


public class Settings extends AppCompatActivity {
    public  Integer prijsEuroGroen = 0;
    public  Integer prijsEuroGeel = 0;
    public  Integer prijsEuroGrijs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        String prefs_name = MainActivity.PREFS_NAME;

        SharedPreferences settings = getSharedPreferences(prefs_name, 0);
        prijsEuroGroen = settings.getInt("prijsGroen", 0);
        prijsEuroGeel = settings.getInt("prijsGeel", 0);
        prijsEuroGrijs = settings.getInt("prijsGrijs", 0);

        setTextGroen();
        setTextGeel();
        setTextGrijs();
    }

    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("prijsGroen", getNumberGroen());
        editor.putInt("prijsGeel", getNumberGeel());
        editor.putInt("prijsGrijs", getNumberGrijs());

        editor.commit();
    }

    public void setTextGroen(){
        EditText editGroen = (EditText) findViewById(R.id.editSettingsGroen);
        editGroen.setText(prijsEuroGroen.toString());
    }

    public int getNumberGroen(){
        EditText editGroen = (EditText) findViewById(R.id.editSettingsGroen);
        String prijs = editGroen.getText().toString();
        if (prijs.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(prijs);
    }

    public void setTextGeel(){
        EditText editGeel = (EditText) findViewById(R.id.editSettingsGeel);
        editGeel.setText(prijsEuroGeel.toString());
    }

    public int getNumberGeel(){
        EditText editGeel = (EditText) findViewById(R.id.editSettingsGeel);
        String prijs = editGeel.getText().toString();
        if (prijs.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(prijs);
    }

    public void setTextGrijs(){
        EditText editGrijs = (EditText) findViewById(R.id.editSettingsGrijs);
        editGrijs.setText(prijsEuroGrijs.toString());
    }

    public int getNumberGrijs(){
        EditText editGrijs = (EditText) findViewById(R.id.editSettingsGrijs);
        String prijs = editGrijs.getText().toString();
        if (prijs.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(prijs);
    }

}
