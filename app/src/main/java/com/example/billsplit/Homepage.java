package com.example.billsplit;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
//import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

//import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class Homepage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    HmpgSliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // code for side-navigation bar
        drawerLayout = findViewById(R.id.navbarlayout);

//  ##############################################################################################################################
//      Need to find out if we need this portion of the code as we already removed toolbar widget from the xml file.
//  ###############################################################################################################################


        // navView = findViewById(R.id.navview);
        // toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//  ###############################################################################################################################


        //settle up button function
        ImageButton settleup_btn = (ImageButton) findViewById(R.id.settleUpBtn);

        settleup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Homepage.this,SettleUpPage.class);
                startActivity(intent1);
            }
        });

        //----Homepage slider function code----
        tabLayout = findViewById(R.id.homeTabLayout);
        viewPager2 = findViewById(R.id.viewpager2);

        FragmentManager fragManager = getSupportFragmentManager();
        sliderAdapter = new HmpgSliderAdapter(fragManager,getLifecycle());
        viewPager2.setAdapter(sliderAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//###############################################################################################################################
//                        code for changing profile picture  ---> CHANGES NEEDED!
//###############################################################################################################################

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


       /* profilePic = findViewById(R.id.profileImageView);
        changeProPicButton = findViewById(R.id.editProfilePicImageButton);

        changeProPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(Homepage.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .cropOval()	    		//Allow dimmed layer to have a circle inside
                        .cropFreeStyle()	    //Let the user to resize crop bounds
                        .galleryOnly()          //We have to define what image provider we want to use
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .createIntent();
            }
        });*/

//###############################################################################################################################

        //HomeScreen Bottom Sheet function
        ImageButton bottommenu = (ImageButton) findViewById(R.id.homeScreenAddBtn);

        bottommenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeScreenBottomSheetDialog();
            }
        });

    }

    private void replaceExpenseFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.hmscrnFragment,fragment);
        fragmentTransaction.commit();
    }

    private void showHomeScreenBottomSheetDialog(){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_homepg_bottomup_sheet);

        LinearLayout newExpense = dialog.findViewById(R.id.bottomMenuExpense);
        LinearLayout newTransaction = dialog.findViewById(R.id.bottomMenuTransaction);
        LinearLayout newMember = dialog.findViewById(R.id.bottomMenuAddMember);

        newExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        newTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        newMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAddNewMemberBtmSheetDialogue();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.HomeScreenBottomAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    private void showAddNewMemberBtmSheetDialogue(){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_add_new_member_btmsheet);

        ListView listView;

        ArrayList<String> newMembers = new ArrayList<String>();

        EditText newMemberName;
        Button addNewMember_btn;
        ImageButton del_mem_btn;

        newMemberName = dialog.findViewById(R.id.input_member_name);
        addNewMember_btn = dialog.findViewById(R.id.add_new_mem_btn);
        del_mem_btn = findViewById(R.id.mem_del_btn);

        listView = dialog.findViewById(R.id.add_member_list);

        AddMemberAdapter adapter = new AddMemberAdapter(this, newMembers);

        listView.setAdapter(adapter);

        addNewMember_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp_name;
                temp_name = newMemberName.getText().toString();
                if(temp_name.length() == 0){
                    Toast.makeText(getApplicationContext(), "Need to enter member's name", Toast.LENGTH_SHORT).show();
                }
                else{
                    newMembers.add(temp_name);
                    newMemberName.setText("");
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "New Member Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.HomeScreenBottomAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    // This function is triggered when the menu icon in the HomePage toolbar is clicked. The mapping is created from the activity_homepage.xml file. line-no 60. " android:onClick="clickMenu" "
    public void clickMenu(View view){
        drawerLayout.openDrawer(Gravity.LEFT);
    }

}