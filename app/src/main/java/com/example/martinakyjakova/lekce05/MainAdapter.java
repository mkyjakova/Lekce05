package com.example.martinakyjakova.lekce05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martina.kyjakova on 11/1/2017.
 */

public class MainAdapter extends BaseAdapter {
    private Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    private List<Person> persons = new ArrayList<>();

    public void add(String name, String surname, String age){

        persons.add(new Person(name, surname, age));
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Person person = getItem(i);
        View view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.list_item_person, viewGroup, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView surname = (TextView) view.findViewById(R.id.surname);
        TextView age = (TextView) view.findViewById(R.id.age);

        name.setText(person.name);
        surname.setText(person.surname);
        age.setText(person.age);

        return view;
    }

    class Person{
        String name;
        String surname;
        String age;

        public Person(String name, String surname, String age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
    }
}
