package app.projeto.appifoodjava.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.projeto.appifoodjava.R;
import app.projeto.appifoodjava.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        final CategoryViewHolder viewHolder = new CategoryViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.txt_category.setText(categoryList.get(position).getName());
        holder.img_category.setImageResource(categoryList.get(position).getImage());
        holder.bg_category.setBackgroundResource(categoryList.get(position).getColor());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView txt_category;
        ImageView img_category;
        View bg_category;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_category= itemView.findViewById(R.id.txt_category);
            img_category= itemView.findViewById(R.id.img_category);
            bg_category= itemView.findViewById(R.id.bg_category);


        }
    }
}


