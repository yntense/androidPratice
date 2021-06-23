package com.example.androidpractice.fragment.component;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidpractice.R;
import com.example.androidpractice.base.BaseFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CPMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CPMapFragment extends BaseFragment {
    private static final String TAG = "CPMapFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    BottomSheetBehavior bottomSheetBehavior;
    //屏幕高
    int heightPixels;
    int bottomSheetMaxHeight;

    public CPMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CPMapFragment newInstance(String param1, String param2) {
        CPMapFragment fragment = new CPMapFragment();
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
    protected View onCreateView() {
        // Inflate the layout for this fragment
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_map, null);
        ButterKnife.bind(this, root);

        bottomSheetBehavior= BottomSheetBehavior.from(nestedScrollView);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.addBottomSheetCallback(new bottomSheetBehavior());
        return root;
    }

    //底部BotoomSheet的监听回调类
    private class bottomSheetBehavior extends BottomSheetBehavior.BottomSheetCallback
    {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();
            int[] location = new int[2];
//            ret.getLocationOnScreen(location);
            bottomSheetMaxHeight = location[1];
            ViewGroup.LayoutParams params = bottomSheet.getLayoutParams();
            // Utils.Write("debug", String.format("bottomSheetMaxHeight %d %d %d",bottomSheetMaxHeight, heightPixels,bottomSheet.getTop()));
            if(bottomSheet.getTop() < bottomSheetMaxHeight )
            {

                params.height = heightPixels - bottomSheetMaxHeight;
                Log.i(TAG, "onStateChanged: ");
//                Utils.Write("debug", String.format("free %d %d",params.height, Utils.px2dp(context, 50.0f)));
                bottomSheet.setLayoutParams(params);
            }

        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {


        }

    }

    //    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }



}