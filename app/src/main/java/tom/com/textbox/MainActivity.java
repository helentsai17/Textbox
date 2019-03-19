package tom.com.textbox;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tom.com.textbox.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
        implements ChatMessageFragment.OnFragmentInteractionListener, HistoryFragment.OnListFragmentInteractionListener,MemberFragment.OnListFragmentInteractionListener{

    private static final String TAG = "firebaseTest";
    private FirebaseApp mApp;
    private FirebaseAuth mAuth;

    ViewPager mViewPager;
    FragmentAdapter mfragmentAdapter;

    FirebaseAuth.AuthStateListener mAuthlistener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFirebase();
        initViewPager();
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.viewPage);
        mfragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mfragmentAdapter);
        TabLayout mTabLayout = findViewById(R.id.tablayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initFirebase() {
        mApp = FirebaseApp.getInstance();
        mAuth = FirebaseAuth.getInstance(mApp);
        final String[] mDisplayName = {String.valueOf(new String[1])};

        mAuthlistener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {//onAuthStateChanged is to see if the user are login already
                //find out if there is a user
                FirebaseUser user = mAuth.getCurrentUser();

                if (user != null/*如果有使用者*/) {
                    Log.e(TAG, "statue Update : Valid current user logged on: email[ " + user.getEmail() + "]display name[" + user.getDisplayName() + "]");
                    // mDisplayName[0] = user.getDisplayName();

                    String displayName = user.getDisplayName();
                    if (displayName != null)
                        mDisplayName[0] = displayName;
                    else
                        mDisplayName[0] = "Unknow DisplayName";

                } else {
                    Log.e(TAG, "statue Update : No Valid current user logged on");
                    mDisplayName[0] = "null";

                    //Intent signIn = new Intent(getApplicationContext(),SignIn.class);
                    //startActivity(signIn);
                }


            }
        };
        mAuth.addAuthStateListener(mAuthlistener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.e(TAG,"ChatMassage");
    }

    @Override
    public void onHistoryListFragmentInteraction(DummyContent.DummyItem item) {
        Log.e(TAG,"History");
    }

    @Override
    public void onMemberListFragmentInteraction(DummyContent.DummyItem item) {
        Log.e(TAG,"Member");
    }
}
