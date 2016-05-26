package com.winjit.wsademo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.credila.commons.CommonHelper;
import com.winjit.wsademo.R;
import com.winjit.wsademo.WinjitApp;
import com.winjit.wsademo.entities.Name;
import com.winjit.wsademo.entities.Result;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private final List<Result> mValues;
    private OnUserClickListener mListener;

    public UsersAdapter(List<Result> items, OnUserClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Name name = mValues.get(position).getName();
        String userName = name.getFirst() + " " + name.getLast();
        holder.mIdView.setText(userName);
        holder.mContentView.setText(mValues.get(position).getEmail());

        new CommonHelper().loadImageAsync(WinjitApp.sContext, mValues.get(position).getPicture().getThumbnail(), holder.mImageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onUserSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final CircleImageView mImageView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Result mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (CircleImageView) view.findViewById(R.id.image);
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    public interface OnUserClickListener {
        void onUserSelected(Result item);
    }
}