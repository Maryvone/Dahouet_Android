package com.dahouet.dahouet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dahouet.dahouet.adapter.ResultatAdapter;
import com.dahouet.dahouet.model.Resultat;
import com.dahouet.dahouet.service.ResultatService;

import java.util.List;

import retrofit.RestAdapter;

public class ResultatActivity extends AppCompatActivity {

    private ListView mListView;
    int regate_id;
    String regate_nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        Intent intent = getIntent();
        regate_id = intent.getIntExtra("regate_id",0);
        regate_nom = intent.getStringExtra("regate_nom");
        mListView=(ListView) findViewById(R.id.resultat_list_view);
        new ListResultatTask().execute();

    }
    public void afficherResultats(List<Resultat> resultats) {
        ResultatAdapter adapter = new ResultatAdapter(this, resultats);
        mListView.setAdapter(adapter);
    }


    class ListResultatTask extends AsyncTask<String, Void, List<Resultat>> {

        @Override
        protected List<Resultat> doInBackground(String... params) {

            ResultatService resultatService = new RestAdapter.Builder().setEndpoint(ResultatService.ENDPOINT).build().create(ResultatService.class);

            List<Resultat> resultats = resultatService.resultats(regate_id);

            return resultats;
        }

        @Override
        protected void onPostExecute(List<Resultat> resultats) {
            super.onPostExecute(resultats);
            afficherResultats(resultats);
        }
    }
}
