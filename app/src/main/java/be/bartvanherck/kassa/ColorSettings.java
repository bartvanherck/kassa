package be.bartvanherck.kassa;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;


public class ColorSettings extends AppCompatActivity {
    public Integer colorLeft = 0;
    public Integer colorMiddle = 0;
    public Integer colorRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_color_settings);
        String prefs_name = MainActivity.PREFS_NAME;

        SharedPreferences settings = getSharedPreferences(prefs_name, 0);
        colorLeft = settings.getInt("colorLeft", R.color.colorGreen);
        colorMiddle = settings.getInt("colorMiddle", R.color.colorYellow);
        colorRight = settings.getInt("colorRight", R.color.colorGray);

        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }

    public void actionColorSettingsBack(View view) {

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("colorLeft", colorLeft);
        editor.putInt("colorMiddle", colorMiddle);
        editor.putInt("colorRight", colorRight);

        editor.commit();
        setResult(RESULT_OK);
        finish();
    }

    public void setNewColor(Integer id, Integer color){
        LinearLayout layout = (LinearLayout) findViewById(id);
        layout.setBackgroundColor(color);
    }

    public void actionCSLeft_Red(View view){
        Resources res = getResources();
        colorLeft = res.getColor(R.color.colorRed);
        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
    }

    public void actionCSLeft_Green(View view){
        Resources res = getResources();
        colorLeft = res.getColor(R.color.colorGreen);
        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
    }

    public void actionCSLeft_Yellow(View view){
        Resources res = getResources();
        colorLeft = res.getColor(R.color.colorYellow);
        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
    }

    public void actionCSLeft_Blue(View view){
        Resources res = getResources();
        colorLeft = res.getColor(R.color.colorBlue);
        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
    }

    public void actionCSLeft_Gray(View view){
        Resources res = getResources();
        colorLeft = res.getColor(R.color.colorGray);
        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
    }

    public void actionCSLeft_White(View view){
        Resources res = getResources();
        colorLeft = res.getColor(R.color.colorWhite);
        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
    }

    public void actionCSLeft_Purple(View view){
        Resources res = getResources();
        colorLeft = res.getColor(R.color.colorPurple);
        setNewColor(R.id.layout_colorsettings_left_color, colorLeft);
    }

    public void actionCSMid_Red(View view){
        Resources res = getResources();
        colorMiddle = res.getColor(R.color.colorRed);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
    }

    public void actionCSMid_Green(View view){
        Resources res = getResources();
        colorMiddle = res.getColor(R.color.colorGreen);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
    }

    public void actionCSMid_Yellow(View view){
        Resources res = getResources();
        colorMiddle = res.getColor(R.color.colorYellow);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
    }

    public void actionCSMid_Blue(View view){
        Resources res = getResources();
        colorMiddle = res.getColor(R.color.colorBlue);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
    }

    public void actionCSMid_Gray(View view){
        Resources res = getResources();
        colorMiddle = res.getColor(R.color.colorGray);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
    }

    public void actionCSMid_White(View view){
        Resources res = getResources();
        colorMiddle = res.getColor(R.color.colorWhite);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
    }

    public void actionCSMid_Purple(View view){
        Resources res = getResources();
        colorMiddle = res.getColor(R.color.colorPurple);
        setNewColor(R.id.layout_colorsettings_middle_color, colorMiddle);
    }

    public void actionCSRight_Red(View view){
        Resources res = getResources();
        colorRight = res.getColor(R.color.colorRed);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }

    public void actionCSRight_Green(View view){
        Resources res = getResources();
        colorRight = res.getColor(R.color.colorGreen);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }

    public void actionCSRight_Yellow(View view){
        Resources res = getResources();
        colorRight = res.getColor(R.color.colorYellow);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }

    public void actionCSRight_Blue(View view){
        Resources res = getResources();
        colorRight = res.getColor(R.color.colorBlue);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }

    public void actionCSRight_Gray(View view){
        Resources res = getResources();
        colorRight = res.getColor(R.color.colorGray);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }

    public void actionCSRight_White(View view){
        Resources res = getResources();
        colorRight = res.getColor(R.color.colorWhite);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }

    public void actionCSRight_Purple(View view){
        Resources res = getResources();
        colorRight = res.getColor(R.color.colorPurple);
        setNewColor(R.id.layout_colorsettings_right_color, colorRight);
    }
}
