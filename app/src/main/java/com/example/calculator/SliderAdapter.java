package com.example.calculator;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {
    private TextView resultDisplayTextView;
    private MaterialButton[] buttons;
    private ImageView imageView;
    private ImageButton doneButton;
    ConstraintLayout layout;
    Color buttonColor;
    Color textViewColor;
    private SliderView sliderView;
    private Context context;
    private int[] slideImages = {R.drawable.orange_screen, R.drawable.red_screen, R.drawable.blue_screen};
    private int[] slideColors = {R.color.orangeBackground, R.color.redBackground, R.color.blueBackground};

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.color_background, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        int image = slideImages[position];
        int color = ContextCompat.getColor(context,slideColors[position]);
        viewHolder.layout.setBackgroundColor(color);
        Glide.with(context).load(image).into(viewHolder.imageView);

    }

    @Override
    public int getCount() {
        return slideImages.length;
    }

    static class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;
        ConstraintLayout layout;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            layout = itemView.findViewById(R.id.background);

        }
    }

}
