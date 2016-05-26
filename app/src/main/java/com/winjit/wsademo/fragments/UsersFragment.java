package com.winjit.wsademo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.credila.commons.CommonHelper;
import com.winjit.wsademo.WinjitApp;
import com.winjit.wsademo.R;
import com.winjit.wsademo.Tasks.Task;
import com.winjit.wsademo.events.GetUsersEvent;
import com.winjit.wsademo.adapters.UsersAdapter;
import com.winjit.wsademo.entities.Result;
import com.winjit.wsademo.listeners.EndlessRecyclerOnScrollListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UsersFragment extends Fragment implements UsersAdapter.OnUserClickListener {

    private List<Result> mUsers = new ArrayList<>();
    private UsersAdapter mUsersAdapter = null;

    @Bind(R.id.iv_error_messages)
    ImageView ivErrorMessages;
    @Bind(R.id.list)
    RecyclerView recyclerView;
    @Bind(R.id.view_loading)
    RelativeLayout viewLoading;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UsersFragment() {
    }

    public static UsersFragment newInstance() {
        UsersFragment fragment = new UsersFragment();
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        WinjitApp.getEventBus().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        WinjitApp.getEventBus().unregister(this);
    }

    @Subscribe
    public void OnUsersReceived(GetUsersEvent response) {

        if (response.getError() == null) {

            setItemToRecyclerView(response.getUsers().getResults());

        } else {

            ivErrorMessages.setImageResource(R.drawable.ic_no_internet);
            ivErrorMessages.setVisibility(View.VISIBLE);
        }

        viewLoading.setVisibility(View.GONE);
    }

    /**
     * Set data to recycler view
     * @param results
     */
    private void setItemToRecyclerView(List<Result> results) {

        if (recyclerView != null) {
            if (results != null) {
                if (results.size() > 0) {
                    ivErrorMessages.setVisibility(View.GONE);

                    if (mUsersAdapter == null) {
                        mUsers = results;
                        mUsersAdapter = new UsersAdapter(results, this);
                        recyclerView.setAdapter(mUsersAdapter);
                    } else {
                        mUsers.addAll(results);
                        mUsersAdapter.notifyDataSetChanged();
                    }
                } else {
                    ivErrorMessages.setImageResource(R.drawable.ic_empty);
                    ivErrorMessages.setVisibility(View.VISIBLE);
                }

            } else {
                ivErrorMessages.setImageResource(R.drawable.ic_empty);
                ivErrorMessages.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common_list, container, false);
        ButterKnife.bind(this, view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        setItemToRecyclerView(null);

        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page > 1 && mUsers.size() < 50) {
                    new CommonHelper().showSnackBar(recyclerView, "Loading more...");
                    new Task().getUsers(current_page);
                }
            }
        });

        getUsers();
        return view;
    }

    void getUsers() {
        viewLoading.setVisibility(View.VISIBLE);
        new Task().getUsers(1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onUserSelected(Result item) {
        new CommonHelper().showSnackBar(recyclerView, "Clicked : " + item.getName().getFirst());
    }
}