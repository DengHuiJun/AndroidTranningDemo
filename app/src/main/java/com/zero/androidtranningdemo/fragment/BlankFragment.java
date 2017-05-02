package com.zero.androidtranningdemo.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zero.androidtranningdemo.R;
import com.zero.androidtranningdemo.utils.LogUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context mContext;


    public BlankFragment() {
        // Required empty public constructor
        LogUtils.i("BlankFragment 构造函数");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i("onCreate（）：" + getActivity());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogUtils.i("onCreateView（）：" + getActivity());
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.i("onAttach（）：" + getActivity());
    }

    @Override
    public void onDetach() {
        LogUtils.i("onDetach（）：" + getActivity());
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.i("onActivityCreated（）：" + getActivity());
        loadTask();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i("onDestroy（）：" + getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.i("onDestroyView（）：" + getActivity());
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LogUtils.i("onAttach（Activity）：" + getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i("onPause（）：" + getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.i("onStart（）：" + getActivity());
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.i("onStop（）：" + getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i("onResume（）：" + getActivity());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.i("onViewCreated（）：" + getActivity());
    }

    private void loadTask() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                LogUtils.i("onPreExecute activity:"+ getActivity());

            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                LogUtils.i("onPostExecute activity:"+ mContext.toString());

            }
        }.execute();
    }
}
