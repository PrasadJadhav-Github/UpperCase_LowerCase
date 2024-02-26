package com.example.uppercase_lowercase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnEdit;
    private EditText txtMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEdit=findViewById(R.id.btnEdit);
        txtMain=findViewById(R.id.txtMain);


        btnEdit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Action action=new Action(MainActivity.this,txtMain.getText().toString());
                        action.setOnoKListener(new OnOkClickListener());
                        action.show();
                    }
                }
        );
    }

    public  class  OnOkClickListener implements Action.OnoKListener{
        @Override
        public void ok(Action action, String str) {
            txtMain.setText(str);
        }
    }
}

