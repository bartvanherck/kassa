package be.bartvanherck.kassa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

/*
RGB   R      G    B
GROEN 0 ,   150,  0
GEEL  255,  215,  0
GRIJS 190,  190,  190
 */

public class ColorSettings extends AppCompatActivity {
    public Integer colorLeft_Red = 0;
    public Integer colorRight_Red = 190;
    public Integer colorMiddle_Red = 255;
    public Integer colorLeft_Green = 150;
    public Integer colorRight_Green = 190;
    public Integer colorMiddle_Green = 215;
    public Integer colorLeft_Blue = 0;
    public Integer colorRight_Blue = 190;
    public Integer colorMiddle_Blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_settings);
        String prefs_name = MainActivity.PREFS_NAME;

        SharedPreferences settings = getSharedPreferences(prefs_name, 0);
        colorLeft_Red = settings.getInt("colorLeft_Red", 0);
        colorMiddle_Red = settings.getInt("colorMiddle_Red", 255);
        colorRight_Red = settings.getInt("colorRight_Red", 190);

        colorLeft_Green = settings.getInt("colorLeft_Green", 150);
        colorMiddle_Green = settings.getInt("colorMiddle_Green", 215);
        colorRight_Green = settings.getInt("colorRight_Green", 190);

        colorLeft_Blue = settings.getInt("colorLeft_Blue", 0);
        colorMiddle_Blue = settings.getInt("colorMiddle_Blue", 0);
        colorRight_Blue = settings.getInt("colorRight_Blue", 190);
        setValuesInTextFields();
    }

    public void getAllColors(){
        EditText edit = (EditText) findViewById(R.id.editColorSettingsLeft_R);
        colorLeft_Red = Integer.parseInt(edit.getText().toString());
        edit = (EditText) findViewById(R.id.editColorSettingsMiddle_R);
        colorMiddle_Red = Integer.parseInt(edit.getText().toString());
        edit = (EditText) findViewById(R.id.editColorSettingsRight_R);
        colorRight_Red = Integer.parseInt(edit.getText().toString());

        edit = (EditText) findViewById(R.id.editColorSettingsLeft_G);
        colorLeft_Green = Integer.parseInt(edit.getText().toString());
        edit = (EditText) findViewById(R.id.editColorSettingsMiddle_G);
        colorMiddle_Green = Integer.parseInt(edit.getText().toString());
        edit = (EditText) findViewById(R.id.editColorSettingsRight_G);
        colorRight_Green = Integer.parseInt(edit.getText().toString());

        edit = (EditText) findViewById(R.id.editColorSettingsLeft_B);
        colorLeft_Blue = Integer.parseInt(edit.getText().toString());
        edit = (EditText) findViewById(R.id.editColorSettingsMiddle_B);
        colorMiddle_Blue = Integer.parseInt(edit.getText().toString());
        edit = (EditText) findViewById(R.id.editColorSettingsRight_B);
        colorRight_Blue = Integer.parseInt(edit.getText().toString());
    }

    public void setValuesInTextFields(){
        EditText edit = (EditText) findViewById(R.id.editColorSettingsLeft_R);
        edit.setText(colorLeft_Red.toString());
        edit = (EditText) findViewById(R.id.editColorSettingsMiddle_R);
        edit.setText(colorMiddle_Red.toString());
        edit = (EditText) findViewById(R.id.editColorSettingsRight_R);
        edit.setText(colorRight_Red.toString());

        edit = (EditText) findViewById(R.id.editColorSettingsLeft_G);
        edit.setText(colorLeft_Green.toString());
        edit = (EditText) findViewById(R.id.editColorSettingsMiddle_G);
        edit.setText(colorMiddle_Green.toString());
        edit = (EditText) findViewById(R.id.editColorSettingsRight_G);
        edit.setText(colorRight_Green.toString());

        edit = (EditText) findViewById(R.id.editColorSettingsLeft_B);
        edit.setText(colorLeft_Blue.toString());
        edit = (EditText) findViewById(R.id.editColorSettingsMiddle_B);
        edit.setText(colorMiddle_Blue.toString());
        edit = (EditText) findViewById(R.id.editColorSettingsRight_B);
        edit.setText(colorRight_Blue.toString());
    }

    public void actionColorSettingsBack(View view) {
        getAllColors();

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("colorLeft_Red", colorLeft_Red);
        editor.putInt("colorMiddle_Red", colorMiddle_Red);
        editor.putInt("colorRight_Red", colorRight_Red);

        editor.putInt("colorLeft_Green", colorLeft_Green);
        editor.putInt("colorMiddle_Green", colorMiddle_Green);
        editor.putInt("colorRight_Green", colorRight_Green);

        editor.putInt("colorLeft_Blue", colorLeft_Blue);
        editor.putInt("colorMiddle_Blue", colorMiddle_Blue);
        editor.putInt("colorRight_Blue", colorRight_Blue);

        editor.commit();
        setResult(RESULT_OK);
        finish();
    }
}
