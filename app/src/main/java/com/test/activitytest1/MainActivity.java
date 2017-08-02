package com.test.activitytest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Button button = (Button)findViewById(R.id.button_main);
        Button button2 = (Button)findViewById(R.id.button_main_return);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                Log.i("MainActivity", "switch to FirstActivity");
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Switched to FirstActivity", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.main_1:
                Toast.makeText(MainActivity.this, "Item_1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_2:
                Toast.makeText(MainActivity.this, "Item_2", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - mExitTime > 2000){
            Toast.makeText(MainActivity.this, "Press again to quit", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        }
        else {
            Toast.makeText(MainActivity.this, "Goodbye", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
