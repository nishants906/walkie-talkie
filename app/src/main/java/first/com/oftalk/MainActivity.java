package first.com.oftalk;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView text1;
    ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1= (TextView) findViewById(R.id.text1);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/3Dumb.ttf");
        text1.setTypeface(custom_font);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {Intent intent=new Intent(MainActivity.this,intro.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        }, 2000);

    }
}
