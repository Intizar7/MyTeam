package com.najimaddinova.myteam;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gulin on 3.03.2018.
 */

 public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public EditText person_name;
        public ImageView person_img;
        public CardView card_view;
        public EditText person_surname;
        public EditText person_age;
        public int photo_id;

        public ViewHolder(View view) {
            super(view);
            card_view = (CardView)view.findViewById(R.id.card_view);
            person_name = (EditText) view.findViewById(R.id.person_name);
            person_surname=(EditText)view.findViewById(R.id.person_photo);
            person_img = (ImageView)view.findViewById(R.id.person_photo);
            person_age=(EditText)view.findViewById(R.id.person_age);
        }
    }
    List<Person> list_person;
    Person.CustomItemClickListener listener;
    public SimpleRecyclerAdapter(List<Person> list_person, Person.CustomItemClickListener listener) {
        this.list_person = list_person;
        this.listener = listener;
    }
    @Override
    public SimpleRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        final ViewHolder view_holder = new ViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, view_holder.getPosition());
            }
        });
        return view_holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.person_name.setText(list_person.get(position).getName());
        holder.person_age.setText(list_person.get(position).getAge());
        holder.person_img.setImageResource(list_person.get(position).getPhoto_id());
        holder.person_surname.setText(list_person.get(position).getSurname());

    }

    @Override
    public int getItemCount() {
        return list_person.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
