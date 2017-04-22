package com.example.shujareshi.hnm;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import static java.sql.Types.NULL;

/**
 * Created by shuja reshi on 2/11/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter{


    private Context context ;
    private List<String> data;
    private HashMap<String,List<String>> child_data;
    public ExpandableListAdapter (Context context, List<String> data,HashMap<String,List<String>> child_data) {

        this.context=context;
        this.data=data;
        this.child_data=child_data;
    }

    @Override
    public int getGroupCount() {

        return this.data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.child_data.get(this.data.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.child_data.get(this.data.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle= (String)getGroup(groupPosition);
        if(convertView==null) {
            LayoutInflater inflater= (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=  inflater.inflate(R.layout.contents,null);
        }

        TextView  contname= (TextView)convertView.findViewById(R.id.contname);
        contname.setTypeface(null, Typeface.NORMAL);
        contname.setText(headerTitle);
        if(groupPosition==0)
            convertView.setBackgroundColor(Color.parseColor("#009688"));
        else if(groupPosition==1)
            convertView.setBackgroundColor(Color.parseColor("#26a69a"));
        else if(groupPosition==2)
            convertView.setBackgroundColor(Color.parseColor("#4db6ac"));
        else if(groupPosition==3)
            convertView.setBackgroundColor(Color.parseColor("#4db6ac"));






        return convertView;
    }

    @Override
    public View getChildView(int groupPosition,final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childtext = (String)getChild(groupPosition,childPosition);
        if(convertView==null) {

            LayoutInflater inflater= (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=  inflater.inflate(R.layout.childlist,null);

        }


        TextView childText = (TextView)convertView.findViewById(R.id.childList);
        childText.setText(childtext);



        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return true;
    }
}
