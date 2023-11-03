package com.bimbo.net.applogin.ui.beer.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bimbo.net.applogin.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapterCustom extends RecyclerView.Adapter<ListAdapterCustom.ViewHolder> {

    private List<ElementItem> list;
    private LayoutInflater layoutInflater;

    private ElementClickListener listener;
    private Context context;

    public ListAdapterCustom(List<ElementItem> list,
                             ElementClickListener listener,
                             Context context){
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapterCustom.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.item_beer,null);
        return new ListAdapterCustom.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterCustom.ViewHolder holder, int position) {
        holder.bindData(this.list.get(position), position);
    }

    public void setListItems(List<ElementItem> list){
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return this.list == null ? 0 : this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tvNameElement;
        TextView tvDescription;
        TextView tvDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgBeer);
            tvNameElement = itemView.findViewById(R.id.nameBeer);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvDetail = itemView.findViewById(R.id.tvDetail);
        }

        public void bindData(final ElementItem item, int position){
            Picasso.get()
                    .load(item.srcImage)
                    .placeholder(R.drawable.ic_beer)
                    .error(R.drawable.ic_beer)
                    .into(img);
            tvNameElement.setText(item.getNameElement());
            tvDescription.setText(item.getDescriptionElement());
            tvDetail.setOnClickListener(v -> {
                listener.OnclickListener(item,position);
            });
        }
    }

}
