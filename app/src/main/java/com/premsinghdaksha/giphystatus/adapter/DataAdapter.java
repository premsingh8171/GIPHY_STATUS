package com.premsinghdaksha.giphystatus.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.premsinghdaksha.giphystatus.R;
import com.premsinghdaksha.giphystatus.model.DataDTO;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewholder> {
    private List<DataDTO> dataDTOList;
    private Context mContext;
    private OnClickGif onClickGif;

    public DataAdapter(List<DataDTO> dataDTOList, Context mContext, OnClickGif onClickGif) {
        this.dataDTOList = dataDTOList;
        this.mContext = mContext;
        this.onClickGif = onClickGif;
    }

    @NonNull
    @Override
    public DataViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new DataViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewholder holder, int position) {
        // String gif = "https://media1.giphy.com/media/" + dataDTOList.get(position).getId() + "/giphy.gif";
       // Glide.with(mContext).load(dataDTOList.get(position).getImages().getOriginal().getUrl()).into(holder.gif_);
        uploadImage(mContext,holder,position,dataDTOList.get(position).getImages().getOriginal().getUrl());
        holder.title.setText(dataDTOList.get(position).getTitle());
        holder.title.setVisibility(View.GONE);
        holder.gif_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGif.onClik(dataDTOList.get(position));
            }
        });
    }

    private void uploadImage(Context context, DataViewholder holder, int position, String strOther3) {
        Glide.with(context).load(strOther3)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.pg.setVisibility(View.GONE);
                        holder.gif_.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.pg.setVisibility(View.GONE);
                        holder.gif_.setVisibility(View.VISIBLE);
                        return false;
                    }
                }).into(holder.gif_);
    }

    @Override
    public int getItemCount() {
        return dataDTOList.size();
    }

    public void setFilter(List<DataDTO> dataDTOS_) {
        dataDTOList = new ArrayList<>();
        dataDTOList.addAll(dataDTOS_);
        notifyDataSetChanged();
    }

    public class DataViewholder extends RecyclerView.ViewHolder {
        private ImageView gif_;
        private TextView title;
        private ProgressBar pg;

        public DataViewholder(@NonNull View itemView) {
            super(itemView);
            gif_ = itemView.findViewById(R.id.gif_);
            title = itemView.findViewById(R.id.title);
            pg = itemView.findViewById(R.id.pg);

        }
    }

    public interface OnClickGif {
        public void onClik(DataDTO dataDTO);
    }
}
