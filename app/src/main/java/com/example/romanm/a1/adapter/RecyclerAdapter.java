package com.example.romanm.a1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.romanm.a1.FragmentRecycler;
import com.example.romanm.a1.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int IMPLICIT = 0;
    private final int EXPLICIT = 1;
    private final int FRAGMENT = 2;


    private FragmentRecycler.OnRecyclerInteractionListener listener;

    public RecyclerAdapter(FragmentRecycler.OnRecyclerInteractionListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return IMPLICIT;
        } else if (position % 3 == 0) {
            return EXPLICIT;
        } else {
            return FRAGMENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case IMPLICIT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_implicit, parent, false);
                viewHolder = new ImplicitViewHolder(view);
                break;
            case EXPLICIT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_explicit, parent, false);
                viewHolder = new ExplicitViewHolder(view);

                break;
            case FRAGMENT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment, parent, false);
                viewHolder = new FragmentViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case IMPLICIT:
                ImplicitViewHolder implicitViewHolder = (ImplicitViewHolder) holder;
                implicitViewHolder.bindTo(implicitViewHolder, position);
                break;
            case EXPLICIT:
                ExplicitViewHolder explicitViewHolder = (ExplicitViewHolder) holder;
                explicitViewHolder.bindTo(explicitViewHolder, position);
                break;
            case FRAGMENT:
                FragmentViewHolder fragmentViewHolder = (FragmentViewHolder) holder;
                fragmentViewHolder.bindTo(fragmentViewHolder, position);
                break;

        }
    }


    @Override
    public int getItemCount() {
        return 1000;
    }


    class ImplicitViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ImplicitViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.implicitItemClick(getAdapterPosition());
                }
            });
            text = (TextView) itemView.findViewById(R.id.number);
        }

        public void bindTo(ImplicitViewHolder holder, int position) {
            holder.text.setText(String.valueOf(position));
        }
    }

    class ExplicitViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ExplicitViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.explicitItemClick(getAdapterPosition());
                }
            });
            text = (TextView) itemView.findViewById(R.id.number);
        }

        public void bindTo(ExplicitViewHolder holder, int position) {
            holder.text.setText(String.valueOf(position));
        }
    }

    class FragmentViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public FragmentViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.fragmentItemClick(getAdapterPosition());
                }
            });
            text = (TextView) itemView.findViewById(R.id.number);
        }

        public void bindTo(FragmentViewHolder holder, int position) {
            holder.text.setText(String.valueOf(position));
        }
    }


}
