package com.kuncham.kyetees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.kuncham.kyetees.adapter.ListbaseAdapter;
import com.kuncham.kyetees.modelclasses.Beanclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    SliderLayout mDemoSlider;

    private ListView list;
    private ArrayList<Beanclasses> Bean;
    private ListbaseAdapter baseAdapter;

    private int[] IMAGE = {R.drawable.slidertea, R.drawable.item2, R.drawable.item3,};

    private String[] TITLE = {"Great Deal", "Great Deal", "Great Deal"};

    private String[] SUBTITLE = {"Grab it!", "Grab it!", "Grab it!"};

    private String[] SHOP = {"Shop Now", "Shop Now", "Shop Now"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = (ListView)findViewById(R.id.list);


        //*****listview*******
        Bean = new ArrayList<Beanclasses>();

        for (int i= 0; i< TITLE.length; i++){

            Beanclasses bean = new Beanclasses(IMAGE[i], TITLE[i], SUBTITLE[i], SHOP[i]);
            Bean.add(bean);

        }

        baseAdapter = new ListbaseAdapter(HomeActivity.this, Bean) {

        };

        list.setAdapter(baseAdapter);



        //******slider***********
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.s1);
        file_maps.put("2",R.drawable.s2);
        file_maps.put("3",R.drawable.s3);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
