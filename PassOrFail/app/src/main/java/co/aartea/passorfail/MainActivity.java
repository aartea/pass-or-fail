package co.aartea.passorfail;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView tv;
    EditText et;
    Button buttonNL;
    Button buttonPT;
    Button buttonFT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Locate all of the defined elements
        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
        buttonNL = (Button) findViewById(R.id.numToLet);     //Number to grade letter button
        buttonPT = (Button) findViewById(R.id.passFail);     //Number entered; pass or fail?
        buttonFT = (Button) findViewById(R.id.fiveTime);     //Print number five times when clicked

        //Set the listener

        buttonNL.setOnClickListener(this);   //Note to self: cast View.OnClickListener to this
        buttonPT.setOnClickListener(this);
        buttonFT.setOnClickListener(this);

    }

        //tv.setOnClickListener(new View.OnClickListener(){}:
        public void onClick(View v){                                //Handle stuff regarding user input
            float grade;

            grade = Float.parseFloat(et.getText().toString());
            /*if(TextUtils.isEmpty(et.getText().toString())){       //Needs some more work on handling non-numeric values
                return;
            }*/
            if(grade > 100 || grade < 0){                           //if true; toast; else do switch
                Toast.makeText(MainActivity.this, "Please insert value between 0-100", Toast.LENGTH_SHORT).show();
            }
            else {
                switch (v.getId()) {
                    case R.id.fiveTime:
                        tv.setText(fiveTimes(grade));                    //Set the textview to display answer
                        break;                                          //Note to self: similar to System.out concept
                    case R.id.numToLet:
                        tv.setText(numberToLetter(grade));
                        break;
                    case R.id.passFail:
                        tv.setText(passOrFail(grade));

                }
            }
        }

    //Method declarations

 public static String numberToLetter(float grade){
        if(grade >= 90)
            return "A";
        else if(grade >=80)
            return "B";
        else if(grade >=70)
            return "C";
        else if(grade >=60)
            return "D";
        else
            return "F";
 }

  public static String passOrFail(float grade){
      if(grade>=65){
          return "Pass";
      }
      else
          return "Fail";
  }

  public static String fiveTimes(float grade){
      String c ="";
      int typeGrade = (int)grade;

      for(int i = 0; i < 5; i++){
            c+="   "+Integer.toString(typeGrade);
        }
      return c;
  }
}
