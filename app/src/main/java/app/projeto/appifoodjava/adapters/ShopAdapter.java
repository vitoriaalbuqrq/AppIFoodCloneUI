package app.projeto.appifoodjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.projeto.appifoodjava.R;
import app.projeto.appifoodjava.model.Shop;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    Context context;
    List<Shop> shopList;

    public ShopAdapter(Context context, List<Shop> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false);
        final ShopViewHolder viewHolder = new ShopViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {

        holder.txt_shop.setText(shopList.get(position).getText());
        holder.img_shop.setImageResource(shopList.get(position).getLogoURI());
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder{

        ImageView img_shop;
        TextView txt_shop;

        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            img_shop = itemView.findViewById(R.id.img_shop);
            txt_shop = itemView.findViewById(R.id.txt_shop);
        }
    }
}
