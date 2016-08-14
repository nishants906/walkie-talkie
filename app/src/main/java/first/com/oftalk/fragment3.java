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
public class fragment3 extends Fragment {
    String title="HEAR THE CRYSTAL CLEAR QUALITY";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3, container, false);
        TextView textview = (TextView) v.findViewById(R.id.text2);
        textview.setText(title);
        return v;

    }
}

