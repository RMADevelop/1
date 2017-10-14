package com.example.romanm.a1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.romanm.a1.adapter.RecyclerAdapter;
import com.example.romanm.a1.utils.ActivityUtils;


public class FragmentRecycler extends Fragment {
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener listener;

    private OnRecyclerInteractionListener listenerRecycler = new OnRecyclerInteractionListener() {
        @Override
        public void implicitItemClick(int id) {
            listener.implicitItemClick(id);
        }

        @Override
        public void explicitItemClick(int id) {
            listener.explicitItemClick(id);
        }

        @Override
        public void fragmentItemClick(int id) {
            ActivityUtils.setFragmentWithBack(getFragmentManager(), FragmentInfo.newInstance(id), R.id.container_fragment);
        }
    };

    public FragmentRecycler() {
        // Required empty public constructor
    }

    public static FragmentRecycler newInstance() {
        FragmentRecycler fragment = new FragmentRecycler();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        initRecycler(view);
        return view;
    }

    private void initRecycler(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerAdapter(listenerRecycler));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    public interface OnFragmentInteractionListener {
        void implicitItemClick(int id);

        void explicitItemClick(int id);
    }

    public interface OnRecyclerInteractionListener {
        void implicitItemClick(int id);

        void explicitItemClick(int id);

        void fragmentItemClick(int id);
    }
}
