package com.dahouet.dahouet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dahouet.dahouet.R;
import com.dahouet.dahouet.model.Regate;

import java.util.List;

/**
 * Created by mcueff on 09/11/17.
 */

public class RegateAdapter extends ArrayAdapter<Regate> {

    public RegateAdapter(Context context, List<Regate> challenges){
        super(context,0,challenges);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_regate,parent, false);
        }

        ChallengeViewHolder viewHolder = (ChallengeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ChallengeViewHolder();
            viewHolder.txtRegateDate =  convertView.findViewById(R.id.txtRegateDate);
            viewHolder.txtRegateNom =  convertView.findViewById(R.id.txtRegateNom);
            viewHolder.txtRegateDistance =  convertView.findViewById(R.id.txtRegateDistance);

            convertView.setTag(viewHolder);
        }

        //getItem(position) will get the position of the item in the collection
        Regate regate = getItem(position);

        //fill the view
        viewHolder.txtRegateDate.setText(regate.getDate());
        viewHolder.txtRegateNom.setText(regate.getLibelle());
        viewHolder.txtRegateDistance.setText(String.valueOf(regate.getDistance()));
        return convertView;
    }

    private class ChallengeViewHolder{
        public TextView txtRegateDate;
        public TextView txtRegateNom;
        public TextView txtRegateDistance;
    }

}
