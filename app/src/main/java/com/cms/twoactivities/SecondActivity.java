package com.cms.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    private EditText replyBox;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        replyBox = findViewById(R.id.editText_second);

        Intent intent = getIntent();
        String messageFromMain= intent.getStringExtra("MainMessage");
        TextView textView = findViewById(R.id.text_message);
        textView.setText(messageFromMain);

        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG, "OnCreate");
    }

    public void returnReply(View view)
    {
        String reply = replyBox.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra("ReplyMessage", reply);
        setResult(RESULT_OK,replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
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
