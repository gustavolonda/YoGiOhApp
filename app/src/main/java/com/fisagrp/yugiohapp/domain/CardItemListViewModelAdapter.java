package com.fisagrp.yugiohapp.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fisagrp.yugiohapp.R;
import com.fisagrp.yugiohapp.databinding.ItemListFragmentCardBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardItemListViewModelAdapter extends RecyclerView.Adapter<CardItemListViewModelAdapter.ViewHolder> {
    ItemListFragmentCardBinding itemListFragmentCardBinding;
    private LayoutInflater inflater;
    private List<CardItemListViewModel> items;
    private Context mContext;
    public int ITEM_VIEW = R.layout.item_list_fragment_card;
    private  CardItemListViewModelAdapterListener mListener;
    public CardItemListViewModelAdapter(Context context, CardItemListViewModelAdapterListener listener) {
        this.mContext  = context ;
        this.mListener = listener ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        itemListFragmentCardBinding= DataBindingUtil.inflate(inflater, ITEM_VIEW, viewGroup, false);
        return new ViewHolder(itemListFragmentCardBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final CardItemListViewModel item = items.get(position);
        try {
            Picasso.get()
                    .load(item.imageUrlCropped)
                    .error(R.drawable.no_image)
                    .into(viewHolder.binding.cardImageId);
        }catch (Exception e){
            e.fillInStackTrace();
        }
        viewHolder.binding.setCadViewModel(item);
        viewHolder.binding.setListener(mListener);
    }

    @Override
    public int getItemCount()
    {
        return items == null ? 0 : items.size();
    }
    public void setItems(List<CardItemListViewModel> items)
    {
        if (this.items == items)
        {
            return;
        }

        if (this.items != null)
        {
            notifyItemRangeRemoved(0, this.items.size());
        }
        if (this.items != items)
        {   this.items = items;

            notifyItemRangeInserted(0, this.items.size());
        }


    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        final ItemListFragmentCardBinding binding;

        ViewHolder(ItemListFragmentCardBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}