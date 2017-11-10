package com.dahouet.dahouet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dahouet.dahouet.adapter.ChallengeAdapter;
import com.dahouet.dahouet.model.Challenge;
import com.dahouet.dahouet.service.ChallengeService;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity {
ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.ChallengeListView);
        new ListChallengesTask().execute();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Challenge challenge = (Challenge) mListView.getItemAtPosition(position);
                int challenge_id=challenge.getId();
                Intent intent = new Intent(MainActivity.this, RegateActivity.class);
                intent.putExtra("challenge_id",challenge_id);
                startActivity(intent);
            }
        });
    }

    public void afficherResultats(List<Challenge> challenges) {
        ChallengeAdapter adapter = new ChallengeAdapter(MainActivity.this, challenges);
        mListView.setAdapter(adapter);
    }


    class ListChallengesTask extends AsyncTask<String, Void, List<Challenge>> {

        @Override
        protected List<Challenge> doInBackground(String... params) {

            ChallengeService challengeService = new RestAdapter.Builder().setEndpoint(ChallengeService.ENDPOINT).build().create(ChallengeService.class);

            ArrayList<Challenge> challenges = challengeService.challenges();

            return challenges;
        }

        @Override
        protected void onPostExecute(List<Challenge> challenges) {
            super.onPostExecute(challenges);
            afficherResultats(challenges);
        }
    }

}
