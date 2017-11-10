package com.dahouet.dahouet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dahouet.dahouet.R;
import com.dahouet.dahouet.model.Resultat;

import java.util.List;

/**
 * Created by mcueff on 09/11/17.
 */

public class ResultatAdapter extends ArrayAdapter<Resultat> {

    public ResultatAdapter(Context context, List<Resultat> resultats){
        super(context,0,resultats);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_resultat,parent, false);
        }

       ResultatViewHolder viewHolder = (ResultatViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ResultatViewHolder();
            viewHolder.txtResultatClassement =  convertView.findViewById(R.id.txtResultatClassement);
            viewHolder.txtResultatNumVoile =  convertView.findViewById(R.id.txtResultatNumVoile);


            convertView.setTag(viewHolder);
        }

        //getItem(position) will get the position of the item in the collection
        Resultat resultat = getItem(position);

        //fill the view
        viewHolder.txtResultatClassement.setText( String.valueOf(resultat.getClassement()));
        viewHolder.txtResultatNumVoile.setText( String.valueOf(resultat.getNum_voile()));

        return convertView;
    }

    private class ResultatViewHolder{
        public TextView txtResultatClassement;
        public TextView txtResultatNumVoile;

    }
}
