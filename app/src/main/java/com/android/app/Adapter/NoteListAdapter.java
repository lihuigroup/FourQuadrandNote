package com.android.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.app.Entry.NoteEntry;
import com.android.app.fourquadrantnote.R;
import com.android.app.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

public class NoteListAdapter extends BaseExpandableListAdapter {
    final int IMPORT=0;
    final int URGENT=1;

    List<String> groupList;//父级列表
    List<List> childList;
    List<NoteEntry> u_i_list;
    List<NoteEntry>  u_ui_list;
    List<NoteEntry>  uu_i_list;
    List<NoteEntry>  uu_ui_list;
    Context context;


    public NoteListAdapter(Context context,int sort_type,List<NoteEntry> u_i_list
            ,List<NoteEntry> u_ui_list,List<NoteEntry> uu_i_list,List<NoteEntry> uu_ui_list){
        this.context=context;
        this.groupList=new ArrayList<>();
        this.childList=new ArrayList<>();
        this.u_i_list=u_i_list;
        this.uu_i_list=uu_i_list;
        this.u_ui_list=u_ui_list;
        this.uu_ui_list=uu_ui_list;

        if (sort_type==IMPORT){
            if (!u_i_list.isEmpty()){
                groupList.add("重要紧急");
                childList.add(u_i_list);
            }

            if (!uu_i_list.isEmpty()){
                groupList.add("重要不紧急");
                childList.add(uu_i_list);
            }

            if (!u_ui_list.isEmpty()){
                groupList.add("紧急不重要");
                childList.add(u_ui_list);
            }

            if (!uu_ui_list.isEmpty()){
                groupList.add("一般事情");
                childList.add(uu_ui_list);
            }
        }

        if (sort_type==URGENT){
            if (!u_i_list.isEmpty()){
                groupList.add("重要紧急");
                childList.add(u_i_list);
            }

            if (!u_ui_list.isEmpty()){
                groupList.add("紧急不重要");
                childList.add(u_ui_list);
            }

            if (!uu_i_list.isEmpty()){
                groupList.add("重要不紧急");
                childList.add(uu_i_list);
            }


            if (!uu_ui_list.isEmpty()){
                groupList.add("一般事情");
                childList.add(uu_ui_list);
            }
        }
      /*  Log.i("Group_Size",String.valueOf(groupList.size()));
        Log.i("Child_size",String.valueOf(childList.size()));
        Log.i("ii_size",String.valueOf(u_i_list.size()));
        Log.i("ui_size",String.valueOf(uu_i_list.size()));
        Log.i("iu_size",String.valueOf(u_ui_list.size()));
        Log.i("uu_size",String.valueOf(uu_ui_list.size()));*/
    }


    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        List<NoteEntry> child=childList.get(i);
        return child.size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //Log.i("groupPosition",String.valueOf(groupPosition));
        List<NoteEntry> child=childList.get(groupPosition);
        return child.get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View convertView, ViewGroup viewGroup) {
        View view;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_group_list, null);
        }else{
            view=convertView;
        }
        TextView textView=view.findViewById(R.id.txt_label);
        textView.setText(groupList.get(groupPosition));
        return view ;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        View view;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_main_list, null);
        }else{
            view=convertView;
        }
        TextView textView=view.findViewById(R.id.txt_note);
        Button button=view.findViewById(R.id.tv_delete);
        final NoteEntry entry=(NoteEntry) getChild(groupPosition,childPosition);
        textView.setText(entry.getTittle());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteModel.deleteNote(entry);
            }
        });
        return view ;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


}
