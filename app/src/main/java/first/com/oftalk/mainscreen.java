package first.com.oftalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skyfishjy.library.RippleBackground;

public class mainscreen extends Activity {

    Button wifi,chat,call,settings,phon12;

    TextView text1,text2,text3,text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        text1= (TextView) findViewById(R.id.text1);
        text2= (TextView) findViewById(R.id.text2);
        wifi= (Button) findViewById(R.id.wifi);
        chat= (Button) findViewById(R.id.chat);
        call= (Button) findViewById(R.id.call);
        settings= (Button) findViewById(R.id.settings);
        phon12= (Button) findViewById(R.id.phone12);


        /* Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.swipe);
        phon12.startAnimation(anim);
        Animation an=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.swipe2);
        text1.startAnimation(an);
        text2.startAnimation(an);
        text3.startAnimation(an);
        text4.startAnimation(an);*/

   /*     ImageView icon = new ImageView(this);
        icon.setImageDrawable(getResources().getDrawable(R.drawable.profile));
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();*/

        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        rippleBackground.startRippleAnimation();



        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainscreen.this,wifi.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainscreen.this,chat.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });
        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainscreen.this,call.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainscreen.this,settings.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });




    }
}

