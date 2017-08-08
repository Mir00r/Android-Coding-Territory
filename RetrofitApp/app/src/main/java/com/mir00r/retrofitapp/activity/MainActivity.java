package com.mir00r.retrofitapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.mir00r.retrofitapp.R;
import com.mir00r.retrofitapp.adapters.MoviesAdapter;
import com.mir00r.retrofitapp.model.Movie;
import com.mir00r.retrofitapp.model.MoviesResponse;
import com.mir00r.retrofitapp.rest.ApiClient;
import com.mir00r.retrofitapp.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "2b43d82427975dfc893660a894e62f33";
    //private final static String API_KEY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiKeyInit();
    }

    public void apiKeyInit() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Please Obtain Your API KEY First Then Request Me Otherwise I will Kill Your Ha ha ah ....... !!!!",
                    Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        //Call<MoviesResponse> call = apiService.getMovieDetails(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of Movie Receive" + movies.size());
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }
            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }
}
