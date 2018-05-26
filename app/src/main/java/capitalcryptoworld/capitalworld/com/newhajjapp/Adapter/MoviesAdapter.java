package capitalcryptoworld.capitalworld.com.newhajjapp.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


import capitalcryptoworld.capitalworld.com.newhajjapp.R;

/**
 * Created by Fahad Aziz on 23/05/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    public List<Movie> moviesList;
    Context context;


    public MoviesAdapter(Context context, List<capitalcryptoworld.capitalworld.com.newhajjapp.Model.Movie> movieList) {
        this.moviesList = moviesList;
        this.context = context;
    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText("kkkk");
        holder.genre.setText("jjj");
        holder.year.setText("kkkk");
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }











}
