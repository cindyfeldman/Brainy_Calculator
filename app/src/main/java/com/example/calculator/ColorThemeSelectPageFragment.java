package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.calculator.databinding.ColorThemePageFragmentBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.Slider;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ColorThemeSelectPageFragment extends Fragment {
    ConstraintLayout layout;
    private View rootView;
    private ColorThemePageFragmentBinding binding;
    private SliderView sliderView;
private SliderAdapterExample adapter;
private TextView resultDisplayTextView;
private MaterialButton[] buttons;
private ImageView imageView;
private ImageButton doneButton;
private Fragment CalculatorPage;
    Color buttonColor;
    Color textViewColor;
    private static final String ARG_BACKGROUND_COLOR = "Color.Blue";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = ColorThemePageFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sliderView = view.findViewById(R.id.slider);

        adapter = new SliderAdapterExample(this);
        doneButton = view.findViewById(R.id.doneButton);
        resultDisplayTextView  = view.findViewById(R.id.resultDisplayTextView);
        layout = view.findViewById( R.id.background);
        buttons = new MaterialButton[19];
        buttons[0]  = view.findViewById(R.id.zeroButton);
        buttons[1] = view.findViewById(R.id.oneButton);
        buttons[2] = view.findViewById(R.id.number2Button);
        buttons[3]  = view.findViewById(R.id.number3Button);
        buttons[4] = view.findViewById(R.id.number4Button);
        buttons[5] = view.findViewById(R.id.number5Button);
        buttons[6] = view.findViewById(R.id.number6Button);
        buttons[7] = view.findViewById(R.id.number7Button);
        buttons[8] = view.findViewById(R.id.number8Button);
        buttons[9] = view.findViewById(R.id.number9button);
        buttons[10] = view.findViewById(R.id.decimalPointButton);
        buttons[11] = view.findViewById(R.id.clearButton);
        buttons[12] = view.findViewById(R.id.negativeButton);
        buttons[13] = view.findViewById(R.id.percentButton);
        buttons[14] = view.findViewById(R.id.divideButton);
        buttons[15] = view.findViewById(R.id.multiplyButton);
        buttons[16] = view.findViewById(R.id.subtractionButton);
        buttons[17] = view.findViewById(R.id.plusButton);
        buttons[18] = view.findViewById(R.id.equalButton);
        imageView = view.findViewById(R.id.colorImageView);
        setRedColors();
        view.setOnTouchListener(new OnSwipeTouchListener(ColorThemeSelectPageFragment.this.getContext()) {

            @SuppressLint("ResourceAsColor")
            int currentIndex = 0;

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();

                currentIndex++;
                // your swipe left here.
                System.out.println("Swiped left");
                if(currentIndex == 0){
                    setRedColors();
                    System.out.println("red colors");

                }
                else if(currentIndex == 1){
                    setOrangeColors();
                    System.out.println("orange colors");

                }
                else if(currentIndex  == 2){
                    setBlueColors();
                    System.out.println("blue colors");
                }

            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                // your swipe right here.
                System.out.println("Swiped right");currentIndex++;
                // your swipe left here.

                currentIndex--;
                if(currentIndex == 2){
                    setBlueColors();
                    System.out.println("blue colors");
                }
                else if(currentIndex == 1){
                    setOrangeColors();
                    System.out.println("orange colors");
                }
                else if(currentIndex  ==0){
                    setRedColors();
                    System.out.println("red colors");
                }
                else if(currentIndex < 0){
                    currentIndex = 2;
                    System.out.println("reset colors");
                }
                currentIndex--;

            }
        });
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Drawable backgroundColorDraw = layout.getBackground();
                Color buttonColorDraw = buttonColor;
                Color textColor = textViewColor;
                int backgroundColor;
                if (backgroundColorDraw instanceof ColorDrawable) {
                    backgroundColor = ((ColorDrawable) backgroundColorDraw).getColor();
                } else {
                    // Default color if the background is not a solid color
                    backgroundColor = Color.TRANSPARENT;
                }
                int buttonColors = buttonColorDraw.toArgb();
                int textViewColor = textColor.toArgb();

                Bundle args = new Bundle();
                args.putInt("buttonColors", buttonColors);
                args.putInt("backgroundColors",backgroundColor);
                args.putInt("textViewColor", textViewColor);
                NavHostFragment.findNavController(ColorThemeSelectPageFragment.this).navigate(R.id.action_SecFragment_to_thirdFragment,args);


            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setBlueColors(){
        imageView.setImageResource(R.drawable.blue_screen);
        layout.setBackgroundColor(Color.rgb(185,211,243));
        sliderView.setIndicatorSelectedColor(Color.rgb(49, 102, 255));
        sliderView.setIndicatorUnselectedColor( Color.rgb(255, 255, 255));
        buttonColor = Color.valueOf(Color.rgb(3, 218, 197));
        textViewColor = Color.valueOf(Color.rgb(131,218,210));
    }

    public void setRedColors(){
        imageView.setImageResource(R.drawable.red_screen);
        layout.setBackgroundColor(Color.rgb(230,209,217));
        sliderView.setIndicatorSelectedColor(Color.rgb(255, 0, 76));
        sliderView.setIndicatorUnselectedColor(Color.rgb(255, 255, 255));
        buttonColor = Color.valueOf(Color.rgb(218,131,141));
        textViewColor = Color.valueOf(Color.rgb(248, 108, 108));

    }


    public void setOrangeColors(){
        imageView.setImageResource(R.drawable.orange_screen);
        layout.setBackgroundColor(Color.rgb(248, 184, 164));
        sliderView.setIndicatorSelectedColor(Color.rgb(255, 113, 31));
        sliderView.setIndicatorUnselectedColor(Color.rgb(255, 255, 255));
        buttonColor = Color.valueOf(Color.rgb(255, 87, 34));
        textViewColor = Color.valueOf(Color.rgb(253, 128, 89));

    }

}

class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

    View itemView;
    ImageView imageViewBackground;
    ImageView imageGifContainer;
    TextView textViewDescription;

    public SliderAdapterVH(View itemView) {
        super(itemView);
        imageViewBackground = itemView.findViewById(R.id.slider);
        imageGifContainer = itemView.findViewById(R.id.background);
        this.itemView = itemView;
    }
}
