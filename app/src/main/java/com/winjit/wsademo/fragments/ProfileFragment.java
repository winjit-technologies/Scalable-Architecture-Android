package com.winjit.wsademo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winjit.commons.CommonHelper;
import com.winjit.wsademo.R;
import com.winjit.wsademo.entities.Profile;
import com.winjit.wsademo.entities.Result;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM = "profile";
    @Bind(R.id.iv_profile_pic)
    CircleImageView ivProfilePic;
    private Profile mProfile;

    @Bind(R.id.tv_profile_details)
    TextView tvProfileDetails;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(Profile profile) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, profile);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProfile = (Profile) getArguments().getSerializable(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        Result results = mProfile.getResults().get(0);
        StringBuilder profileDetails = new StringBuilder();
        profileDetails.append("<B>Name</B><BR>");
        String name = results.getName().getFirst() + " " + results.getName().getLast();
        profileDetails.append(name);
        profileDetails.append("<BR><BR><B>DOB</B><BR>");
        profileDetails.append(results.getDob());
        profileDetails.append("<BR><BR><B>Gender</B><BR>");
        profileDetails.append(results.getGender());
        profileDetails.append("<BR><BR><B>Location</B><BR>");
        String address = results.getLocation().getStreet() + ", " + results.getLocation().getCity() + ",<Br>"
                + results.getLocation().getState() + " " + results.getLocation().getPostcode() + ".";
        profileDetails.append(address);
        profileDetails.append("<BR><BR><B>Contacts</B><BR>");
        profileDetails.append("Phone : ");
        profileDetails.append(results.getPhone());
        profileDetails.append("<BR>Cell : ");
        profileDetails.append(results.getCell());
        tvProfileDetails.setText(Html.fromHtml(profileDetails.toString()));

        new CommonHelper().loadImageAsync(getActivity().getApplicationContext(), results.getPicture().getLarge(), ivProfilePic, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}