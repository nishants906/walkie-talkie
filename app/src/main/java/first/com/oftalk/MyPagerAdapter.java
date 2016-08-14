package first.com.oftalk;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Test on 8/12/2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                Fragment fm2 = new fragment2();
                return fm2;
            }
            case 1:{
                Fragment fm1 = new fragment3();
                return fm1;
            }

            default: {
                Fragment fm3 = new fragment1();
                return fm3;

            }
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
}
