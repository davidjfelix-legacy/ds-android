package com.dinnersolutions.instameal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinnersolutions.instameal.api.model.Meal;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dejan Ristic on 2/23/16.
 */
public class MealAdapter extends
        RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private List<Meal> meals;
    private Context context;

    public MealAdapter(Context context, List<Meal> meals) {
        this.context = context;
        this.meals = meals;
    }

    public void updateMeals(List<Meal> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return meals != null ? meals.size() : 0;
    }

    @Override
    public MealAdapter.MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(MealAdapter.MealViewHolder viewHolder, int position) {
        Meal meal = meals.get(position);
        viewHolder.setMeal(meal);
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.meal_image)
        ImageView mealImage;
        @Bind(R.id.name)
        TextView mealName;
        @Bind(R.id.price)
        TextView mealPrice;
        @Bind(R.id.zipcode)
        TextView mealZipcode;
        @Bind(R.id.time)
        TextView mealTime;

        private Meal meal;

        public MealViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setMeal(Meal meal) {
            this.meal = meal;
            layoutMeal();
        }

        private void layoutMeal() {
            //todo uncomment when image is reasonable size
            //Glide.with(context).load(meal.imageUrl).into(mealImage);
            mealName.setText(meal.name);
            mealPrice.setText("$" + String.valueOf(meal.price));

            //todo use actual data when we have location services / date helper
            mealZipcode.setText("41071");
            mealTime.setText("Ready from 3:00 - 3:45 pm.");

        }
    }
}