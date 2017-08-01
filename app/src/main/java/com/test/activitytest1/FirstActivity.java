package com.test.activitytest1;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button = (Button)findViewById(R.id.button_fa);
        Button button2 = (Button)findViewById(R.id.button_fa_return);
        Button button3 = (Button)findViewById(R.id.button_fa_browser);
        Button button4 = (Button)findViewById(R.id.button_fa_tel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "Switched to Second Activity", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("com.test.activitytest1.ACTION_START");
                intent.addCategory("com.test.activitytest1.MY_CATEGORY");
                intent.putExtra("data", "FA_to_SA");
                startActivityForResult(intent, 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK) {
                    String data_return = data.getStringExtra("data_return");
                    Log.i("FirstActivity", "ResultFromSA:" + data_return);
                }
                break;
            default:
        }
    }
}
