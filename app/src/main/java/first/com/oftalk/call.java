package first.com.oftalk;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class call extends AppCompatActivity implements View.OnClickListener {
    ImageView play,stop,record;
    String file=null;
    MediaRecorder recorder;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        play= (ImageView) findViewById(R.id.play);
        stop= (ImageView) findViewById(R.id.stop);
        record= (ImageView) findViewById(R.id.start);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        record.setOnClickListener(this);
        file= Environment.getExternalStorageDirectory().getAbsolutePath() + "/myrec.3gp";


     }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.start:{
                recorder = new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                recorder.setOutputFile(file);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                try {
                    recorder.prepare();
                } catch (IOException e) {
                    Log.e("failedresult1", "prepare() failed");
                }

                recorder.start();
                Toast.makeText(this, "Audio Recording started Successfully", Toast.LENGTH_SHORT).show();
                stop.setVisibility(View.VISIBLE);
                record.setVisibility(View.GONE);
                break;

            }
            case R.id.stop:{
                recorder.stop();
                recorder.release();
                stop.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
                recorder = null;
                Toast.makeText(this, "Audio Recorded Successfully", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.play:{

                player = new MediaPlayer();
                try {
                    player.setDataSource(file);
                    player.prepare();
                    player.start();
                    play.setVisibility(View.GONE);
                    record.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    Log.e("failedresult2", "prepare() failed");
                }
                break;
            }
        }

    }
}
