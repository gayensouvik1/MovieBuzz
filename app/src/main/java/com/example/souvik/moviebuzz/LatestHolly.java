package com.example.souvik.moviebuzz;

import android.support.v7.app.AppCompatActivity;

import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_holly);

        listView = (ListView)findViewById(R.id.listView);


        new doIt().execute();
    }



    public class doIt extends AsyncTask<String,String,List<LatestModel>> {

        String words="",mName="";
        double rate=0;

        protected List<LatestModel> doInBackground(String... params){

            List<LatestModel> LatestModelList = new ArrayList<>();
            String urls[] = new String[255];
            double rating[] = new double[255];
            try {

                Document doc = Jsoup.connect("http://www.imdb.com/chart/top").get();
                Elements link = doc.select("img[src$=.jpg]");
                Elements content = doc.select("a[href^=/title/][title]");
                Elements ratings = doc.select("strong[title]");
                int i=0;
                for(Element e:link){
                    words = e.attr("src");
                    urls[i] = words;
                    i++;
                }
                i=0;
                for(Element e:ratings){

                    rate=Double.parseDouble(e.text());
                    rating[i] = rate;
                    i++;
                }
                i=0;
                for(Element e:content){

                    mName = e.text();

                    LatestModel LatestModel = new LatestModel();

                    LatestModel.setName(mName);
                    LatestModel.setImageURL(urls[i]);
                    LatestModel.setRating(rating[i]);

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
            listView.setAdapter(adapter);

        }
    }
}
