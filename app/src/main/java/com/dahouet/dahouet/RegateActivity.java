package com.dahouet.dahouet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dahouet.dahouet.adapter.RegateAdapter;
import com.dahouet.dahouet.model.Regate;
import com.dahouet.dahouet.service.RegateService;

import java.util.List;

import retrofit.RestAdapter;

public class RegateActivity extends AppCompatActivity {
    int challenge_id;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regate);
        Intent intent = getIntent();
        challenge_id = intent.getIntExtra("challenge_id", 0);
        mListView = (ListView) findViewById(R.id.RegateListView);
        new ListRegatesTask().execute();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Regate regate = (Regate) mListView.getItemAtPosition(position);
                int regate_id = regate.getId();
                String regate_nom = regate.getLibelle();
                Intent intent = new Intent(RegateActivity.this, ResultatActivity.class);
                intent.putExtra("regate_id", regate_id);
                intent.putExtra("regate_nom", regate_nom);
                startActivity(intent);
            }
        });
    }

    public void afficherResultats(List<Regate> regates) {
        RegateAdapter adapter = new RegateAdapter(RegateActivity.this, regates);
        mListView.setAdapter(adapter);
    }


    class ListRegatesTask extends AsyncTask<String, Void, List<Regate>> {

        @Override
        protected List<Regate> doInBackground(String... params) {

            RegateService regateService = new RestAdapter.Builder().setEndpoint(RegateService.ENDPOINT).build().create(RegateService.class);

            List<Regate> regates = regateService.regates(challenge_id);

            return regates;
        }

        @Override
        protected void onPostExecute(List<Regate> regates) {
            super.onPostExecute(regates);
            afficherResultats(regates);
        }
    }
}