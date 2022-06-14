package com.app.vsam.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import com.app.vsam.R;
import com.app.vsam.fragments.AddFragment;
import com.app.vsam.fragments.ChallengeFragment;
import com.app.vsam.fragments.HomeFragment;
import com.app.vsam.fragments.ProfileFragment;

import com.app.vsam.fragments.SearchFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import static com.app.vsam.util.AppUtil.changeStatusBarColor;

public class HomeActivity extends AppCompatActivity {

    public MeowBottomNavigation bottomNavigation;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private AddFragment addFragment;
    private ChallengeFragment challengeFragment;
    private ProfileFragment profileFragment;
    private FragmentManager fragmentManager;
    private boolean isBackPressed = true;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        changeStatusBarColor(this , "#1A1A1A");

        bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_search));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_add));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_user2));

        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        addFragment = new AddFragment();
        challengeFragment = new ChallengeFragment();
        profileFragment = new ProfileFragment();

        bottomNavigation.show(1 , true);
        replace(homeFragment, isBackPressed);

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId())
                {
                    case 1:
                            replace(homeFragment, isBackPressed);
                            break;

                    case 2:
                            replace(searchFragment, isBackPressed);
                            break;

                    case 3:
                            replace(addFragment, isBackPressed);
                            break;

                    case 4:
                            replace(challengeFragment, isBackPressed);
                            break;

                    case 5:
                            replace(profileFragment, isBackPressed);
                            break;
                }

                return null;
            }
        });

    }

    private void replace(Fragment fragment, boolean addBack) {
        if (fragment != null) {
            String tag = fragment.getClass().getSimpleName();
            FragmentTransaction tr = fragmentManager.beginTransaction();

            Fragment curFrag = getSupportFragmentManager().getPrimaryNavigationFragment();
            final Fragment cacheFrag = getSupportFragmentManager().findFragmentByTag(tag);

            if (curFrag != null)
                tr.hide(curFrag);

            if (cacheFrag == null) {
                tr.add(R.id.frame, fragment, tag);
            } else {
                tr.show(cacheFrag);
                fragment = cacheFrag;
            }

            tr.setPrimaryNavigationFragment(fragment);
            if (addBack) {
                tr.addToBackStack(tag);
            }
            tr.commit();
            isBackPressed = true;
        }

    }

    @Override
    public void onBackPressed() {
        int count = fragmentManager.getBackStackEntryCount();
        if (count <= 1) {
            finish();
            super.onBackPressed();
        } else {
            String stackName = fragmentManager.getBackStackEntryAt(count - 2).getName();
            isBackPressed = false;
            assert stackName != null;
            switch (stackName) {
                case "PriceFragment":
                    bottomNavigation.show(1, true);
                    break;
                case "ConverterFragment":
                    bottomNavigation.show(2, true);
                    break;
                case "RewardsFragment":
                    bottomNavigation.show(3, true);
                    break;
                case "WithdrawFragment":
                    bottomNavigation.show(4, true);
                    break;
                case "ProfileFragment":
                    bottomNavigation.show(5, true);
                    break;
            }
            fragmentManager.popBackStack();
        }
    }

//    private void init()
//    {
//        RecyclerView storiesBar = findViewById(R.id.recyclerView1);
//        RecyclerView postsBar = findViewById(R.id.recyclerView2);
//
//        List<Story > stories = new ArrayList<>();
//        stories.add(new Story(false));
//        stories.add(new Story(false));
//        stories.add(new Story(true));
//        stories.add(new Story(false));
//        stories.add(new Story(true));
//        stories.add(new Story(false));
//        stories.add(new Story(true));
//        stories.add(new Story(false));
//
//        StoriesAdapter adapter = new StoriesAdapter(stories , this);
//
//        storiesBar.setAdapter(adapter);
//        storiesBar.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL , false));
//
//        //Setting the space between stories
//        storiesBar.addItemDecoration(new StoriesDecoration(10));
//
//
//        //Posts Adapter
//        List<Data> posts = new ArrayList<>();
//        posts.add(new Data(false));
//        posts.add(new Data(false));
//        posts.add(new Data(false));
//        posts.add(new Data(false));
//        posts.add(new Data(false));
//        posts.add(new Data(false));
//
//        PostsAdapter adapter1 = new PostsAdapter(posts , this);
//
//        postsBar.setAdapter(adapter1);
//        postsBar.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
//
//
//    }
}
