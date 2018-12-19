package com.cms.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public static final int TEXT_REQUEST = 1;
    private EditText messageBox;
    private TextView headerText;
    private TextView replyText;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageBox = findViewById(R.id.editText_main);
        headerText = findViewById(R.id.text_header_reply);
        replyText = findViewById(R.id.text_message_reply);

        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG, "OnCreate");

        if(savedInstanceState != null)
        {
            boolean visibility = savedInstanceState.getBoolean("reply_visible");
            if(visibility)
            {
                headerText.setVisibility(View.VISIBLE);
                replyText.setVisibility(View.VISIBLE);
                replyText.setText(savedInstanceState.getString("reply_text"));
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (headerText.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",replyText.getText().toString());
        }
    }


    public void launchSecondActivity(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = messageBox.getText().toString();
        intent.putExtra("MainMessage", message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST && resultCode == RESULT_OK)
        {
            String reply = data.getStringExtra("ReplyMessage");
            headerText.setVisibility(View.VISIBLE);
            replyText.setText(reply);
            replyText.setVisibility(View.VISIBLE);
        }
    }





    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }


    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
