package com.example.recyclerview.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.recyclerview.R;
import com.example.recyclerview.activity.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.activity.adapter.Adapter;
import com.example.recyclerview.activity.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());//Gerenciador de Layout
        recyclerView.setLayoutManager(layoutManager); //Configura o layout
        recyclerView.setHasFixedSize(true); //Otimiza o RecyclerView deixando-o com tamanho fixo. Recomendação do Google.
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter); //Configura o adapter

        //Evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            //Pressiona o item
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item pressionado: " + filme.getTitulo(),
                                    Toast.LENGTH_SHORT
                            ).show();

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            //Pressiona e segura o item
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Clique longo: " + filme.getTitulo(),
                                    Toast.LENGTH_SHORT
                            ).show();

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //

                        }
                    }
            )
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Mulher-Maravilha", "Ação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem Aranha - De Volta ao Lar", "Ação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civil", "Aventura", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América - Soldado Invernal", "Aventura", "2014");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu Malvado Favorito 3", "Comédia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Batman - Cavaleiro das Trevas", "Suspense", "2008");
        this.listaFilmes.add(filme);

        filme = new Filme("Batman Begins", "Drama", "2005");
        this.listaFilmes.add(filme);

        filme = new Filme("Batman - O Cavaleiro das Trevas Ressurge", "Ação", "2012");
        this.listaFilmes.add(filme);

        filme = new Filme("The Avengers", "Fantasia", "2012");
        this.listaFilmes.add(filme);
    }


}
