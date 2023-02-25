package hcmute.edu.vn.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String phepToan = "";
    Double So1, So2, ketqua;
    Boolean checkBang = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView result = (TextView)findViewById(R.id.result);
        TextView work = (TextView)findViewById(R.id.work);
        ImageButton btnSo1 = (ImageButton) findViewById(R.id.one);
        ImageButton btnTwo = (ImageButton) findViewById(R.id.two);
        ImageButton btnThree = (ImageButton) findViewById(R.id.three);
        ImageButton btnFour = (ImageButton) findViewById(R.id.four);
        ImageButton btnFive = (ImageButton) findViewById(R.id.five);
        ImageButton btnSix = (ImageButton) findViewById(R.id.six);
        ImageButton btnSeven = (ImageButton) findViewById(R.id.seven);
        ImageButton btnEight = (ImageButton) findViewById(R.id.eight);
        ImageButton btnNine = (ImageButton) findViewById(R.id.night);
        ImageButton btnZero = (ImageButton) findViewById(R.id.zero);
        ImageButton btnDot = (ImageButton) findViewById(R.id.dot);
        ImageButton btnMul = (ImageButton) findViewById(R.id.multiple);
        ImageButton btnDiv = (ImageButton) findViewById(R.id.division);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.addition);
        ImageButton btnSub = (ImageButton) findViewById(R.id.subtraction);
        ImageButton btnEqual = (ImageButton) findViewById(R.id.equal);
        ImageButton btnClear = (ImageButton) findViewById(R.id.deleteAll);
        ImageButton btnDelete = (ImageButton) findViewById(R.id.deleteOne);
        ImageButton btnNegative = (ImageButton) findViewById(R.id.negative);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String temp = result.getText().toString();
                    temp = temp.substring(0,temp.length() - 1);
                    result.setText(temp);
                }
                catch(Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                   if(!checkBang)
                   {
                       So2 = Double.parseDouble(result.getText() + "");
                       if(phepToan == "*")
                       {
                           work.setText(work.getText().toString() + result.getText().toString() + "=");
                           result.setText("");
                           ketqua = So1 * So2;
                       } else if (phepToan == "/") {
                           work.setText(work.getText().toString() + result.getText().toString() + "=");
                           result.setText("");
                           ketqua = So1 / So2;
                           ketqua = Math.ceil(ketqua*10000)/10000;
                       } else if (phepToan == "+") {
                           work.setText(work.getText().toString() + result.getText().toString() + "=");
                           result.setText("");
                           ketqua = So1 + So2;
                       } else if (phepToan == "-") {
                           work.setText(work.getText().toString() + result.getText().toString() + "=");
                           result.setText("");
                           ketqua = So1 - So2;
                       }
                       else {

                           work.setText(result.getText().toString()+"=");
                           result.setText("");
                           ketqua = So2;

                       }
                       result.setText(ketqua.toString());
                       checkBang = true;
                       phepToan = "";
                   }
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    So1 = Double.parseDouble(result.getText().toString());
                    String div = "/";
                    String text = result.getText().toString();
                    work.setText(text + String.valueOf(div));
                    result.setText("");
                    phepToan = "/";
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    So1 = Double.parseDouble(result.getText().toString());
                    String mul = "*";
                    String text = result.getText().toString();
                    work.setText(text + String.valueOf(mul));
                    result.setText("");
                    phepToan = "*";
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    So1 = Double.parseDouble(result.getText().toString());
                    String add = "+";
                    String text = result.getText().toString();
                    work.setText(text + String.valueOf(add));
                    result.setText("");
                    phepToan="+";
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    So1 = Double.parseDouble(result.getText().toString());
                    String sub = "-";
                    String text = result.getText().toString();
                    work.setText(text + String.valueOf(sub));
                    result.setText("");
                    phepToan="-";
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNegative.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    if (result.getText() != ""){
                        String temp = result.getText().toString();
                        double a = Double.parseDouble(temp);
                        if (a > 0) {
                            temp = "-".concat(temp);
                        }
                        else {
                            temp = temp.substring(1);
                        }

                        result.setText(temp);
                    }
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   String dot = ".";
                   String text = result.getText().toString();
                   if(text.indexOf(dot)==-1)
                   {
                       result.setText(text + String.valueOf(dot));
                   }
               }
               catch (Exception ex){
                   Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
               }
            }
        });
        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String one = "1";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(one));

                        }
                        else
                        {
                            result.setText(text + String.valueOf(one));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(one));
                    }
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String two = "2";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(two));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(two));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(two));
                    }
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String three = "3";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(three));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(three));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(three));
                    }
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String four = "4";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(four));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(four));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(four));
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String five = "5";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(five));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(five));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(five));
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String six = "6";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(six));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(six));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(six));
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String seven = "7";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(seven));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(seven));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(seven));
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String eight = "8";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(eight));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(eight));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(eight));
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nine = "9";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(nine));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(nine));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(nine));
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String zero = "0";
                    String text = result.getText().toString();
                    if(checkBang == false)
                    {
                        if(text == "")
                        {
                            result.setText(String.valueOf(zero));
                        }
                        else
                        {
                            result.setText(text + String.valueOf(zero));
                        }
                    }
                    else {
                        checkBang=false;
                        result.setText(String.valueOf(zero));
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please check!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                work.setText("");
                checkBang = false;
            }
        });
    }
}