package kr.hs.emirim.s2019s19.mirimintenttest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    RadioGroup rg;
    Button btnCalcultor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        rg = findViewById(R.id.rg);
        btnCalcultor = findViewById(R.id.calculate);
        btnCalcultor.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("num1", num1.getText().toString());
            intent.putExtra("num2", num2.getText().toString());
            switch (rg.getCheckedRadioButtonId()) {
                case R.id.plus:
                    intent.putExtra("op", "+");
                    break;
                case R.id.minus:
                    intent.putExtra("op", "-");
                    break;
                case R.id.multiple:
                    intent.putExtra("op", "*");
                    break;
                case R.id.divide:
                    intent.putExtra("op", "/");
                    break;
            }
            startActivity(intent);
        }
    };
}