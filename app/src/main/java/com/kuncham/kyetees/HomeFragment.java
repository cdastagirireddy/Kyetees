package com.kuncham.kyetees;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuncham.kyetees.adapter.GridViewAdapter;
import com.kuncham.kyetees.modelclasses.Beanclass;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ExpandableHeightGridView gridview;
    private ArrayList<Beanclass> beanclassArrayList;
    private GridViewAdapter gridviewAdapter;
    private View view;

    private int[] IMAGEgrid = {R.drawable.item4, R.drawable.item3, R.drawable.item5, R.drawable.item6, R.drawable.item7, R.drawable.item8,};
    private String[] TITLeGgrid = {"Min 70% off", "Min 50% off", "Min 45% off",  "Min 60% off", "Min 70% off", "Min 50% off"};
    private String[] DIscriptiongrid = {"Brand Shoes", "Brand Shoes", "Brand Shoes","Brand Shoes", "Brand Shoes", "Brand Shoes"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!", "Explore Now!","Grab Now!"};




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        gridview = (ExpandableHeightGridView)view.findViewById(R.id.gridview);
        beanclassArrayList= new ArrayList<Beanclass>();

        for (int i= 0; i< IMAGEgrid.length; i++) {

            Beanclass beanclass = new Beanclass(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
            beanclassArrayList.add(beanclass);

        }
        gridviewAdapter = new GridViewAdapter(getActivity(), beanclassArrayList);
        gridview.setExpanded(true);

        gridview.setAdapter(gridviewAdapter);
        return view;


    }



}
