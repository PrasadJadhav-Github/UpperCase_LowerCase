package com.example.uppercase_lowercase;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Locale;

public class Action extends Dialog {
    private EditText edtText;
    private RadioButton radiobtnUpperCase ,radiobtnLowerCase,radiobtnIC,radiobtnreverse;
    private Context context;
    private  Button ok;
    private String data;

   public Action(Context context,String data){
       super(context);
       this.data= data;
       this.context=context;
       initView();
       String convertedtext = "";

       edtText.setText(data);

   }
   public  interface OnoKListener{
        void ok(Action action ,String str);
   }
   private OnoKListener onoKListener = null;
   public void setOnoKListener(OnoKListener onoKListener){
       this.onoKListener=onoKListener;
   }

   private  class BtnUpperCaseListener implements View.OnClickListener{
       @Override
       public void onClick(View view) {

           String originalText=edtText.getText().toString();

           String convertedtext=originalText.toUpperCase();
           edtText.setText(convertedtext);
           mt("UpperCase");
       }
   }

   private  class BtnLowerCaseListener implements  View.OnClickListener{
       @Override
       public void onClick(View view) {

           String originalText=edtText.getText().toString();
           String convertedtext=originalText.toLowerCase();
           edtText.setText(convertedtext);
           mt("LowerCase");
       }
   }

   private  class  BtnICListener implements  View.OnClickListener{
       @Override
       public void onClick(View view) {
           String str = edtText.getText().toString();
         edtText.setText(Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase());
       }
   }

   private  class  BtnReverseListener implements  View.OnClickListener{
       @Override
       public void onClick(View view) {
           String str=edtText.getText().toString();
           String reversedstr = " ";
           for (int i = 0; i < str.length() ; i ++) {
               reversedstr = str.charAt(i) + reversedstr;
           }
           edtText.setText(reversedstr);
       }
   }

   private  class  Btnok implements  View.OnClickListener{
       @Override
       public void onClick(View view) {
           if(onoKListener!=null){
               onoKListener.ok(Action.this,edtText.getText().toString());
           }
           dismiss();
       }
   }

    private void mt(String text){
        Toast.makeText(context,text, Toast.LENGTH_SHORT).show();
    }

    private void initView(){
        setContentView(R.layout.actions);
        edtText=findViewById(R.id.edtText);
        radiobtnUpperCase=findViewById(R.id.radioUpperCase);
       radiobtnLowerCase=findViewById(R.id.radioLowerCase);
       radiobtnIC=findViewById(R.id.radioIC);
       radiobtnreverse=findViewById(R.id.radioreverse);
       ok=findViewById(R.id.Btnok);

       radiobtnUpperCase.setOnClickListener(new BtnUpperCaseListener());
        radiobtnLowerCase.setOnClickListener(new BtnLowerCaseListener());
        radiobtnIC.setOnClickListener(new BtnICListener());
        radiobtnreverse.setOnClickListener(new BtnReverseListener());
        ok.setOnClickListener(new Btnok());
    }
}

