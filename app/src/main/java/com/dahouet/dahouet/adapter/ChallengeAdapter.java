package com.dahouet.dahouet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dahouet.dahouet.R;
import com.dahouet.dahouet.model.Challenge;

import java.util.List;

/**
 * Created by mcueff on 09/11/17.
 */

public class ChallengeAdapter extends ArrayAdapter<Challenge> {

    public ChallengeAdapter(Context context, List<Challenge> challenges){
        super(context,0,challenges);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_challenge,parent, false);
        }

        ChallengeViewHolder viewHolder = (ChallengeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ChallengeViewHolder();
            viewHolder.txtChallengeDebut =  convertView.findViewById(R.id.txtChallengeDebut);
            viewHolder.txtChallengeFin =  convertView.findViewById(R.id.txtChallengeFin);
            viewHolder.txtChallengeNom =  convertView.findViewById(R.id.txtChallengeNom);

            convertView.setTag(viewHolder);
        }

        //getItem(position) will get the position of the item in the collection
        Challenge challenge = getItem(position);

        //fill the view
        viewHolder.txtChallengeDebut.setText(challenge.getDate_debut());
        viewHolder.txtChallengeFin.setText(challenge.getDate_fin());
        viewHolder.txtChallengeNom.setText(challenge.getLibelle());
        return convertView;
    }

    private class ChallengeViewHolder{
        public TextView txtChallengeDebut;
        public TextView txtChallengeFin;
        public TextView txtChallengeNom;
    }
}
