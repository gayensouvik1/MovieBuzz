package com.example.souvik.moviebuzz;

import android.support.v7.app.AppCompatActivity;

import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.souvik.moviebuzz.models.LatestModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class LatestHolly extends AppCompatActivity {

    GridView gridView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_holly);

        gridView = (GridView) findViewById(R.id.gridview);
        textView = (TextView)findViewById(R.id.textView);


        new doIt().execute();
    }



    public class doIt extends AsyncTask<String,String,List<LatestModel>> {

        String words="",mName="",all="hello";
        double rate=0;
        String urls[] = new String[255];
        double rating[] = new double[255];

        protected List<LatestModel> doInBackground(String... params){

            List<LatestModel> LatestModelList = new ArrayList<>();

            try {

                Document doc = Jsoup.connect("http://www.bollymoviereviewz.com/2014/04/latest-hollywood-movies-2014-releases.html").get();
                all = doc.text();
                Elements link = doc.getElementsByClass("kltat");
                Elements content = doc.getElementsByClass("kltat");

                int i=0;
                for(Element e:link){
                    words = e.text();
                    urls[i] = words;
                    i++;
                }

                i=0;
                for(Element e:content){

                    mName = e.text();

                    LatestModel LatestModel = new LatestModel();

                    LatestModel.setName(mName);
                    LatestModel.setImageURL(urls[i]);
                    LatestModel.setRating(0);

                    LatestModelList.add(LatestModel);
                    i++;

                }


            }catch (Exception e){
                e.printStackTrace();
            }


            return LatestModelList;
        }




        @Override
        protected void onPostExecute(List<LatestModel> result) {
            super.onPostExecute(result);

            LatestAdapter adapter = new LatestAdapter(LatestHolly.this,R.layout.latest_content,result);
            gridView.setAdapter(adapter);
            textView.setText(all);

        }
    }
}
