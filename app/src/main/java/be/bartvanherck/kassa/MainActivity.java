package be.bartvanherck.kassa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Integer numberGroen = 0;
    public static Integer numberGeel = 0;
    public static Integer numberGrijs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateAllTextFields();
    }

    public void actionUpGroen(View view) {
        numberGroen = numberGroen + 1;
        updateAllTextFields();
    }

    public void actionDownGroen(View view)
    {
        numberGroen = numberGroen - 1;
        if (numberGroen < 0 ) {
            numberGroen = 0;
        }
        updateAllTextFields();
    }

    public void actionUpGeel(View view) {
        numberGeel = numberGeel + 1;
        updateAllTextFields();
    }

    public void actionDownGeel(View view)
    {
        numberGeel = numberGeel - 1;
        if (numberGeel < 0){
            numberGeel = 0;
        }
        updateAllTextFields();
    }

    public void actionUpGrijs(View view) {
        numberGrijs = numberGrijs + 1;
        updateAllTextFields();
    }

    public void actionDownGrijs(View view)
    {
        numberGrijs = numberGrijs - 1;
        if (numberGrijs < 0){
            numberGrijs = 0;
        }
        updateAllTextFields();
    }

    public void actionVolgende(View view)
    {
        numberGroen = 0;
        numberGeel = 0;
        numberGrijs = 0;
        updateAllTextFields();
    }

    public void updateAllTextFields()
    {
        setTextGroen();
        setTextGeel();
        setTextGrijs();
        setResultaat();
    }

    public void setResultaat(){
        Integer groenMulEuro = 140;
        Integer geelMulEuro = 160;
        Integer grijsMulEuro = 220;

        Integer resultGroen = groenMulEuro * numberGroen;
        Integer resultGeel = geelMulEuro * numberGeel;
        Integer resultGrijs = grijsMulEuro * numberGrijs;

        Integer calculated = resultGroen + resultGeel + resultGrijs;
        Integer cents = calculated % 100;
        Integer euros = calculated / 100;

        setTextResultaat(euros, cents);
    }

    public void setTextGroen(){
        TextView txtNumber = (TextView) findViewById(R.id.txtGroen);
        txtNumber.setText(numberGroen.toString());
    }

    public void setTextGeel(){
        TextView txtNumber = (TextView) findViewById(R.id.txtGeel);
        txtNumber.setText(numberGeel.toString());
    }

    public void setTextGrijs(){
        TextView txtNumber = (TextView) findViewById(R.id.txtGrijs);
        txtNumber.setText(numberGrijs.toString());
    }

    public void setTextResultaat(Integer euros, Integer cents){
        TextView txtResultaat = (TextView) findViewById(R.id.txtResultaat);
        String resultaat;
        resultaat = euros.toString() + " Euro";
        if (cents != 0) {
            resultaat = resultaat + " " + cents.toString();
        }
        txtResultaat.setText(resultaat);
    }
}
