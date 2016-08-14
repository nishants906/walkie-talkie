package first.com.oftalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Test on 8/12/2016.
 */
public class fragment1 extends Fragment {
    String title="FORGET THOSE OLD STYLE OF CALLING";


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment1, container, false);
        TextView textview= (TextView) v.findViewById(R.id.text1);
        textview.setText(title);
        return v;

    }
}
