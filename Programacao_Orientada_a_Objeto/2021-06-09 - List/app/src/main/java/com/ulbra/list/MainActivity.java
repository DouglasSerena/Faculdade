package com.ulbra.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ulbra.list.adapter.PokemonAdapter;
import com.ulbra.list.models.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Pokemon> listPokemon = new ArrayList<Pokemon>();

        listPokemon.add(new Pokemon("carlinhos", "elta"));
        listPokemon.add(new Pokemon("pr", "celta"));
        listPokemon.add(new Pokemon("daw", "celta"));
        listPokemon.add(new Pokemon("vx", "celta"));
        listPokemon.add(new Pokemon("qw", "celta"));
        listPokemon.add(new Pokemon("tw", "celta"));

        ListView listView = (ListView) findViewById(R.id.viewList);

//        String[] dados = new String[] { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
//                "Honeycomb", "Ice Cream Sandwich", "Jelly Bean",
//                "KitKat", "Lollipop", "Marshmallow", "Nougat" };
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
//
//        listView.setAdapter(adapter);

        PokemonAdapter adapter = new PokemonAdapter(getApplicationContext(), listPokemon);
        listView.setAdapter(adapter);
    }
}