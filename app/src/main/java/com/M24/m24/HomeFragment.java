package com.M24.m24;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Objects;

import Modalclass.EmergencyServices;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView Emergency,Otherservices;
    private LinearLayout profbox,notfibox,histbox;
    private CircleImageView profilephoto;
    private ImageView notification,history;
    private EditText namep,placep,distp,pinp,phonep,emailp;
    private Button subp;
    private Animation zoomin,zoomout;
    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter adapters;
    private NestedScrollView mainscroll;
    private ConstraintLayout home;
    private AppBarLayout mainappbar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        zoomin = AnimationUtils.loadAnimation(getContext(),R.anim.zoomin);
        zoomout = AnimationUtils.loadAnimation(getContext(),R.anim.zoomout);
        mainappbar = view.findViewById(R.id.mainappbar);
        mainappbar.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset!=0){
                    profbox.setVisibility(View.GONE);
                    notfibox.setVisibility(View.GONE);
                    histbox.setVisibility(View.GONE);
                }
            }
        });


        profbox = view.findViewById(R.id.profilebox);
        notfibox = view.findViewById(R.id.notificationbox);
        histbox = view.findViewById(R.id.historybox);
        profilephoto = view.findViewById(R.id.profileimage);
        notification = view.findViewById(R.id.notificationicon);
        history = view.findViewById(R.id.historyimage);
       // home = view.findViewById(R.id.homefrag);

        mainscroll = view.findViewById(R.id.mainrecycler);




        profilephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profbox.setVisibility(View.VISIBLE);
                notfibox.setVisibility(View.GONE);
                histbox.setVisibility(View.GONE);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profbox.setVisibility(View.GONE);
                notfibox.setVisibility(View.VISIBLE);
                histbox.setVisibility(View.GONE);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profbox.setVisibility(View.GONE);
                notfibox.setVisibility(View.GONE);
                histbox.setVisibility(View.VISIBLE);
            }
        });
        mainscroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profbox.setVisibility(View.GONE);
                notfibox.setVisibility(View.GONE);
                histbox.setVisibility(View.GONE);
            }
        });
        return view;
    }
}