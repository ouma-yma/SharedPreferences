package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {
        private  SharedPreferences mPreferneces;
        private  SharedPreferences.Editor mEditor;
        private EditText mName,mMdp;
        private Button btn;
        private CheckBox ch;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mName= findViewById(R.id.editName);
            mMdp=findViewById(R.id.editTextTextPassword);
            btn=findViewById(R.id.button);
            ch=findViewById(R.id.checkBox);
            mPreferneces= PreferenceManager.getDefaultSharedPreferences(this);
            mEditor=mPreferneces.edit();
            checkShared();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ch.isChecked()){
                        mEditor.putString(getString(R.string.checkbox),"True");
                        mEditor.commit();
                        String name = mName.getText().toString();
                        mEditor.putString(getString(R.string.name),name);
                        mEditor.commit();
                        String password = mMdp.getText().toString();
                        mEditor.putString(getString(R.string.password),password);
                        mEditor.commit();
                    }
                    else{
                        mEditor.putString(getString(R.string.checkbox),"False");
                        mEditor.commit();

                        mEditor.putString(getString(R.string.name),"");
                        mEditor.commit();

                        mEditor.putString(getString(R.string.password),"");
                        mEditor.commit();


                    }
                }
            });

        }
        private void checkShared(){

            String checkbox= mPreferneces.getString(getString(R.string.checkbox),"False");
            String name= mPreferneces.getString(getString(R.string.name),"");
            String password= mPreferneces.getString(getString(R.string.password),"");
            mName.setText(name);
            mMdp.setText(password);
            if (checkbox.equals("True")){
                ch.setChecked(true);
            }else{
                ch.setChecked(false);
            }


        }
    }