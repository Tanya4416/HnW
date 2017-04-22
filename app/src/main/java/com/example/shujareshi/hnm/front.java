package com.example.shujareshi.hnm;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class front extends AppCompatActivity {
    FloatingActionMenu materialDesignFAM;
    com.github.clans.fab.FloatingActionButton floatingActionButton1;
    com.github.clans.fab.FloatingActionButton floatingActionButton2;
    com.github.clans.fab.FloatingActionButton floatingActionButton3;



    ExpandableListAdapter ListAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> ListDataChild;
/*    FloatingActionButton fab, fab1, fab2, fab3;
    LinearLayout fabLayout1, fabLayout2, fabLayout3;
    View fabBGLayout;
    boolean isFABOpen=false;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        //get list view
        expListView = (ExpandableListView) findViewById(R.id.explist);

        //preparing lsit data
        prepareListData();

        ListAdapter = new ExpandableListAdapter(this, listDataHeader, ListDataChild);

        //setting list adapter
        expListView.setAdapter(ListAdapter);

        //listview goup click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long id) {

                if (groupPosition == 3) {
                    Intent i = new Intent(front.this, news.class);
                    startActivity(i);
                }

                return false;
            }
        });

        //list view group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {

            }
        });

        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {

            }
        });

        //listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosotion, int childPosition, long id) {

                if (groupPosotion == 0 && childPosition == 0) {
                    Intent i = new Intent(front.this, diet.class);

                    startActivity(i);
                } else if (groupPosotion == 0 && childPosition == 1) {
                    Intent i = new Intent(front.this, gym.class);

                    startActivity(i);
                } else if (groupPosotion == 0 && childPosition == 2) {
                    Intent i = new Intent(front.this, yoga.class);

                    startActivity(i);
                }
                return false;
            }
        });


        materialDesignFAM     = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //TODO something when floating action menu first item clicked

                Intent i = new Intent(front.this, profile.class);
                startActivity(i);



            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                //LOGOUT


                    }

        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked

                Intent j  = new Intent(Intent.ACTION_CALL);
                j.setData(Uri.parse("tel:8860513619"));
                startActivity(j);

            }
        });
    }

        /*fabLayout1= (LinearLayout) findViewById(R.id.fabLayout1);
        fabLayout2= (LinearLayout) findViewById(R.id.fabLayout2);
        fabLayout3= (LinearLayout) findViewById(R.id.fabLayout3);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2= (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fabBGLayout=findViewById(R.id.fabBGLayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });

        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });


    }

    private void showFABMenu(){
        isFABOpen=true;
        fabLayout1.setVisibility(View.VISIBLE);
        fabLayout2.setVisibility(View.VISIBLE);
        fabLayout3.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);

        fab.animate().rotationBy(180);
        fabLayout1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabLayout2.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
        fabLayout3.animate().translationY(-getResources().getDimension(R.dimen.standard_145));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fabBGLayout.setVisibility(View.GONE);
        fab.animate().rotationBy(-180);
        fabLayout1.animate().translationY(0);
        fabLayout2.animate().translationY(0);
        fabLayout3.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(!isFABOpen){
                    fabLayout1.setVisibility(View.GONE);
                    fabLayout2.setVisibility(View.GONE);
                    fabLayout3.setVisibility(View.GONE);
                }

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(isFABOpen){
            closeFABMenu();
        }else{
            super.onBackPressed();
        }
    }

*/


    //preparing the list data
    private void prepareListData() {

        listDataHeader= new ArrayList<String>();
        ListDataChild = new HashMap<String , List<String>>();

        //adding child data
        listDataHeader.add("HEALTH");
        listDataHeader.add("MEDICINES");
        listDataHeader.add("HOSPITALS & SERVICES");
        listDataHeader.add("NEWS");


        //adding child
        List<String> health = new ArrayList<String>();
        health.add("diet chart  ");
        health.add("gym  ");
        health.add("yoga  ");

        List<String> medicines = new ArrayList<String>();
        medicines.add("disease and cure  ");
        medicines.add("description  ");
        medicines.add("nearby stores  ");

        List<String> hos = new ArrayList<String>();
        hos.add("hospitals  ");
        hos.add("clinics  ");
        hos.add("blood banks  ");
        hos.add("emergency services  ");
        hos.add("government services  ");
        hos.add("rehabilitation centers  " );

        List<String> news = new ArrayList<String>();

        ListDataChild.put(listDataHeader.get(0),health);
        ListDataChild.put(listDataHeader.get(1),medicines);
        ListDataChild.put(listDataHeader.get(2),hos);
        ListDataChild.put(listDataHeader.get(3),news);


    }
}
