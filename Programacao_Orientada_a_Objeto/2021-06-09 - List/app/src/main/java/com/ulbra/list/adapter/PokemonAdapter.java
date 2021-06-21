package com.ulbra.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ulbra.list.R;
import com.ulbra.list.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {
    public PokemonAdapter(Context context, ArrayList<Pokemon> pokemon) {
        super(context, 0, pokemon);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.view_list_pokemon,parent,false);
        }

        Pokemon currentPokemon = getItem(position);

        TextView textName = (TextView) listItemView.findViewById(R.id.textName);
        TextView textType = (TextView) listItemView.findViewById(R.id.textType);

        textName.setText(currentPokemon.getName());
        textType.setText(currentPokemon.getType());

        listItemView.setOnClickListener(v -> {
            showTost("Pokemon: " + currentPokemon.getName() + "\nTipo: " + currentPokemon.getType());
        });

        return listItemView;
    }

    void showTost(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
