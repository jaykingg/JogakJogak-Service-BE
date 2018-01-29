package com.github.unithon.unithon.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.home.HomeFragment;
import com.github.unithon.unithon.mypage.MyPageFragment;
import com.github.unithon.unithon.search.SearchActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeFragment();

        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.navigation_home:
                replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG);

                return true;
            case R.id.navigation_search:
                final Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);

                return false;
            case R.id.navigation_mypage:
                replaceFragment(MyPageFragment.newInstance(), MyPageFragment.TAG);

                return true;
            default:
                return false;
        }

    }

    private void initializeFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(HomeFragment.newInstance(), HomeFragment.TAG)
                .commitNow();

        replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG);
    }

    private void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, fragment, tag)
                .commitNow();
    }

}
