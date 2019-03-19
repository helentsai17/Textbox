package tom.com.textbox;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment page = null;
        switch (position){
            case 0: page = ChatMessageFragment.newInstance("one","two"); break;
            case 1: page = HistoryFragment.newInstance(1);break;
            case 2: page = MemberFragment.newInstance(2);break;
            default:ChatMessageFragment.newInstance("one","two");
        }
        return page;
    }

    
    @Override
    public int getCount() {
        return 3;//代表3頁
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence result = " ";
        switch (position){
            case 0 : result = "Chat"; break;
            case 1 : result = "History"; break;
            case 2 : result = "Member"; break;
            default: result = "Chat"; break;
        }
        return result;
    }
}
