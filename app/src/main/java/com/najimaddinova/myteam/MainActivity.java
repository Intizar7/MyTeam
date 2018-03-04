package com.najimaddinova.myteam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAdapter {

    private RecyclerView recycler_view;
    private List<Person> person_list;
    private LayoutInflater mLayoutInfilater;
    private Context context;

//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        layoutManager.scrollToPosition(0);
//        recycler_view.setLayoutManager(layoutManager);
//        person_list = new ArrayList<Person>();
//
//        SimpleRecyclerAdapter adapter_items = new SimpleRecyclerAdapter(person_list, new Person.CustomItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Log.d("position", "Tıklanan Pozisyon:" + position);
//                Person person = person_list.get(position);
//                Toast.makeText(getApplicationContext(),"pozisyon:"+" "+position+" "+"Ad:"+person.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        recycler_view.setHasFixedSize(true);
//
//        recycler_view.setAdapter(adapter_items);
//
//        recycler_view.setItemAnimator(new DefaultItemAnimator());
//
//    }

    public  MainActivity (List<Person> person, Context context){
        this.person_list=person;
        this.context=context;

    }
    @Override
    public int getCount() {
        return person_list.size();
    }

    @Override
    public Object getItem(int position) {
        return person_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SimpleRecyclerAdapter.ViewHolder vh;
        Person per= (Person) getItem(position);
        if (convertView==null){
            convertView=mLayoutInfilater.inflate(R.layout.)
        }


        return null;
    }
}
