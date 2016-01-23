package com.stephentuso.welcome.ui.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stephentuso.welcome.R;
import com.stephentuso.welcome.ui.WelcomeScreenPage;

/**
 * A simple fragment that shows an image and a title.
 * Use the {@link TitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TitleFragment extends Fragment implements WelcomeScreenPage.OnChangeListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DRAWABLE_ID = "drawable_id";
    private static final String ARG_TITLE = "title";

    private int drawableId;
    private String title = "";
    private TextView titleView = null;
    private ImageView imageView = null;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of TitleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TitleFragment newInstance(@DrawableRes int resId, String title) {
        TitleFragment fragment = new TitleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DRAWABLE_ID, resId);
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public TitleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        imageView = (ImageView) view.findViewById(R.id.image);
        titleView = (TextView) view.findViewById(R.id.title);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            drawableId = getArguments().getInt(ARG_DRAWABLE_ID);
            title = getArguments().getString(ARG_TITLE);
            imageView.setImageResource(drawableId);
            titleView.setText(title);
        }
    }

    @Override
    public void onScrolled(int pageIndex, float offset, int offsetPixels) {
        if (Build.VERSION.SDK_INT >= 11 && imageView != null) {
            imageView.setX(-offsetPixels * 0.8f);
        }
    }

    @Override
    public void onSelected(int pageIndex) {

    }

    @Override
    public void onScrollStateChanged(int state) {

    }
}