package first.com.oftalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class chat extends AppCompatActivity {

    EditText editText;
    TextView text;
    Button enter;
    String[] k=new String[10];
    int i=0,j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editText= (EditText) findViewById(R.id.edit);
        text= (TextView) findViewById(R.id.text);
        enter= (Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k[i]= String.valueOf(editText.getText());
                do{
                    text.setText(k+"\n");
                    j++;
                }while(j<i);

            }
        });

    }
}
