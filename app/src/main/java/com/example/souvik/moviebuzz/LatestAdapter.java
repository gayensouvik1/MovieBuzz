package com.example.souvik.moviebuzz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.souvik.moviebuzz.models.LatestModel;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

import static java.security.AccessController.getContext;

/**
 * Created by souvik on 4/1/17.
 */

public class LatestAdapter extends ArrayAdapter {

    private List<LatestModel> movieModelsList;
    private int resource;
    private LayoutInflater inflater;
    private Context context;

    public LatestAdapter(Context context, int resource, List<LatestModel> objects) {
        super(context, resource,objects);
        movieModelsList = objects;
        this.resource = resource;
        this.context = context;

    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.latest_content,null);

        }

        ImageView imageView;

        imageView = (ImageView)convertView.findViewById(R.id.latestIcon);



        //Picasso.with(getContext()).load(movieModelsList.get(position).getImageURL()).into(imageView);


        return convertView;
    }
}
