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
import app.projeto.appifoodjava.model.MoreShop;

public class MoreShopAdapter extends RecyclerView.Adapter<MoreShopAdapter.MoreShopViewHolder> {

    Context context;
    static List<MoreShop> moreShopList;
    MoreShop moreShop;

    public MoreShopAdapter(Context context, List<MoreShop> moreShopList) {
        this.context = context;
        this.moreShopList = moreShopList;
    }

    @NonNull
    @Override
    public MoreShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.more_shop, parent, false);
        final MoreShopViewHolder viewHolder = new MoreShopViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoreShopViewHolder holder, int position) {

        holder.img_shop.setImageResource(moreShopList.get(position).getBannerImage());
        holder.txt_star.setText(String.valueOf(moreShopList.get(position).getRate()));
        holder.txt_shop.setText(moreShopList.get(position).getText());
        holder.txt_price.setText(String.valueOf(moreShopList.get(position).getPrice()));


    }

    @Override
    public int getItemCount() {
        return moreShopList.size();
    }

    public static class MoreShopViewHolder extends RecyclerView.ViewHolder{

        ImageView img_shop, img_favorite;
        TextView txt_shop, txt_star, txt_subtitle, txt_price;

        public MoreShopViewHolder(@NonNull View itemView) {
            super(itemView);

            img_shop = itemView.findViewById(R.id.img_shop);
            img_favorite = itemView.findViewById(R.id.img_favorite);
            txt_shop = itemView.findViewById(R.id.txt_shop);
            txt_star = itemView.findViewById(R.id.txt_star);
            txt_subtitle = itemView.findViewById(R.id.txt_subtitle);
            txt_price = itemView.findViewById(R.id.txt_price);

        }
    }
}
