package com.android.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.app.Entry.NoteEntry;
import com.android.app.fourquadrantnote.R;

import java.util.ArrayList;
import java.util.List;

public class NoteListAdapter extends BaseAdapter {
    private Context context;                        //运行上下文
    private List<NoteEntry> listItems;    //便签集合
    private int sort_type;                //排序类型
    private List<Integer> labels;          //分类下标
    private List<NoteEntry> u_i_list;     //四大便签分类
    private List<NoteEntry> u_ui_list;
    private List<NoteEntry> uu_i_list;
    private List<NoteEntry> uu_ui_list;
    private LayoutInflater listContainer;           //视图容器
    private static final int ITEM_NOTE =0;
    private static final int ITEM_TXT =1;
    private static final int ITEM_COUNT=2;
    public final class NoteListItemView {                //自定义控件集合
        public TextView title;
    }

    public final class LabelListItemView {                //自定义控件集合
        public TextView name_txt;

    }


    public NoteListAdapter(Context context, List<NoteEntry> listItems,int sort) {
        this.context = context;
        listContainer = LayoutInflater.from(context);   //创建视图容器并设置上下文
        this.listItems = listItems;
        sort_type=sort;
        u_i_list=new ArrayList<>();
        u_ui_list=new ArrayList<>();
        uu_i_list=new ArrayList<>();
        uu_ui_list=new ArrayList<>();

        for (int i=0;i<listItems.size();i++){
            NoteEntry item=listItems.get(i);
            switch (item.getType()){
                case 0:
                    u_i_list.add(item);
                    break;
                case 1:
                    uu_i_list.add(item);
                    break;
                case 2:
                    u_ui_list.add(item);
                    break;
                case 3:
                    uu_ui_list.add(item);
            }
        }

        if(sort_type==1) {
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        if (!u_i_list.isEmpty())
                            labels.add(new Integer(0));
                        break;
                    case 1:
                        if (!uu_i_list.isEmpty())
                            labels.add(new Integer(u_i_list.size() + labels.size()));
                        break;
                    case 2:
                        if (!u_ui_list.isEmpty())
                            labels.add(new Integer(uu_i_list.size() + u_i_list.size() + labels.size()));
                        break;
                    case 3:
                        if (!uu_ui_list.isEmpty())
                            labels.add(new Integer(uu_i_list.size() + u_i_list.size() + u_ui_list.size() + labels.size()));
                }

            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        if (!u_i_list.isEmpty())
                            labels.add(new Integer(0));
                        break;
                    case 1:
                        if (!u_ui_list.isEmpty())
                            labels.add(new Integer(u_i_list.size() + labels.size()));
                        break;
                    case 2:
                        if (!uu_i_list.isEmpty())
                            labels.add(new Integer(u_ui_list.size() + u_i_list.size() + labels.size()));
                        break;
                    case 3:
                        if (!uu_ui_list.isEmpty())
                            labels.add(new Integer(uu_i_list.size() + u_i_list.size() + u_ui_list.size() + labels.size()));
                }

            }
        }
    }

    public int getCount() {
        return listItems.size()+labels.size();
    }

    public Object getItem(int arg0) {
        if (sort_type==1){
            if (arg0<labels.get(1))
                return null;
        }
        return null;
    }

    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void reflesh(List<NoteEntry> list){
        refleshData(list);
        notifyDataSetChanged();
    }

    private void refleshData(List<NoteEntry> list){
        listItems=list;
        for (int i=0;i<listItems.size();i++){
            NoteEntry item=listItems.get(i);
            switch (item.getType()){
                case 0:
                    u_i_list.add(item);
                    break;
                case 1:
                    uu_i_list.add(item);
                    break;
                case 2:
                    u_ui_list.add(item);
                    break;
                case 3:
                    uu_ui_list.add(item);
            }
        }
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        int type=ITEM_NOTE;
        for (int i=0;i<labels.size();i++){
            if (position==labels.get(i))
                type=ITEM_TXT;
        }
        return type;
    }

    /**
     * ListView Item设置
     */
    public View getView(final int position, View convertView, ViewGroup parent) {
        int item_type = getItemViewType(position);
        NoteListItemView noteListItemView = null;
        LabelListItemView labelListItemView =null;
        if (convertView == null) {
            switch (item_type) {//初始化包
                case ITEM_TXT:
                    noteListItemView = new NoteListItemView();
                    //获取list_item布局文件的视图
                    convertView = listContainer.inflate(R.layout.item_main_list1, null);
                    //获取控件对象
                    noteListItemView.title = (TextView) convertView.findViewById(R.id.txt_label);

                    //设置控件集到convertView
                    convertView.setTag(noteListItemView);
                    break;
                case ITEM_NOTE:
                    labelListItemView = new LabelListItemView();
                    //获取list_item布局文件的视图
                    convertView = listContainer.inflate(R.layout.item_main_list, null);
                    //获取控件对象
                    labelListItemView.name_txt = (TextView) convertView.findViewById(R.id.txt_label);

                    //设置控件集到convertView
                    convertView.setTag(labelListItemView);
                    break;
            }
        } else {
            switch (item_type) {
                case ITEM_TXT:
                    noteListItemView = (NoteListItemView) convertView.getTag();
                    break;
                case ITEM_NOTE:
                    labelListItemView = (LabelListItemView) convertView.getTag();
                    break;
            }
        }

        switch (item_type) {
            case ITEM_TXT:
                //设置文字


                break;
            case ITEM_NOTE:
                //设置文字

                break;
        }

        return convertView;
    }
}
