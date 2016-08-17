package first.com.oftalk;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;

public class call extends AppCompatActivity implements View.OnClickListener {
    ImageView play,stop,record,send;
    String file=null;
    MediaRecorder recorder;
    MediaPlayer player;
    RelativeLayout rl1,rl2,rl3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        play= (ImageView) findViewById(R.id.play);
        stop= (ImageView) findViewById(R.id.stop);
        record= (ImageView) findViewById(R.id.start);
        send= (ImageView) findViewById(R.id.send);
        rl1= (RelativeLayout) findViewById(R.id.rl1);
        rl2= (RelativeLayout) findViewById(R.id.rl2);


        rl3= (RelativeLayout) findViewById(R.id.rl3);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        record.setOnClickListener(this);
        send.setOnClickListener(this);
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
                rl1.setVisibility(View.GONE);
                rl2.setVisibility(View.VISIBLE);
                rl3.setVisibility(View.VISIBLE);
                recorder = null;
                Toast.makeText(this, "Audio Recorded Successfully", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.play: {

                player = new MediaPlayer();
                try {
                    player.setDataSource(file);
                    player.prepare();
                    player.start();
                    rl1.setVisibility(View.VISIBLE);
                    rl2.setVisibility(View.INVISIBLE);
                    rl3.setVisibility(View.INVISIBLE);
                    record.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    Log.e("failedresult2", "prepare() failed");
                }
                break;
            }
                case R.id.send:{
     /*               String sharePath = Environment.getExternalStorageDirectory().getPath()+"/myrec.3gp";
                    Uri uri = Uri.parse(sharePath);
                    Intent share =new Intent(Intent.ACTION_SEND); share.setType("audio/*");
                    share.putExtra(Intent.EXTRA_STREAM, uri);
                    startActivity(Intent.createChooser(share,"Share Sound File"));
*/



            }
        }

    }
}
