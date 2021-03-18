package com.example.solicitudpiezasv3;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    Context context;
    List<Uri> lista;
    LayoutInflater inflater;

    GridViewAdapter(Context context,List<Uri> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item,null);
        }

        ImageView imagenEscogida = convertView.findViewById(R.id.imgView);
        imagenEscogida.setImageURI(lista.get(position));

        ImageButton btn = convertView.findViewById(R.id.btnBorrar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
