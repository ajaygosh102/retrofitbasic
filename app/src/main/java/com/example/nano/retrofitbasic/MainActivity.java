package com.example.nano.retrofitbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

   // ListView listView;

  public   RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // listView =(ListView)findViewById(R.id.listViewHeroes);
        getHeroes();
    }

    private void getHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api=retrofit.create(Api.class);

        Call<List<Hero>> call =api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
                         @Override
                         public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                             List<Hero> movies=response.body();

                             //String[] heroes =new String[heroList.size()];

                             //for(int i=0;i<heroList.size();i++){

                           //      heroes[i]=heroList.get(i).getRealname();
                         //    }
                          //   listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                             //        android.R.layout.simple_list_item_1,heroes));



                             //  List<Movie> movies = response.body().getResults();
                             recyclerView.setAdapter(new HeroAdapter(movies, R.layout.list_item_heroes, getApplicationContext()));

                            // recyclerView.setAdapter((RecyclerView.Adapter) movies);
                         }

                         @Override
                         public void onFailure(Call<List<Hero>> call, Throwable t) {

                             Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                         }
                     });

    }
}
