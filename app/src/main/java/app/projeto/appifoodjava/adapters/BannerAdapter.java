package app.projeto.appifoodjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.projeto.appifoodjava.R;
import app.projeto.appifoodjava.model.Banner;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerAdapterHolder>{

    Context context;
    List<Banner> bannerList;

    public BannerAdapter(Context context, List<Banner> bannerList) {
        this.context = context;
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public BannerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
        final BannerAdapterHolder viewHolder = new BannerAdapterHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapterHolder holder, int position) {

        holder.img_banner.setImageResource((bannerList.get(position).getImage()));

    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public static class BannerAdapterHolder extends RecyclerView.ViewHolder{

        ImageView img_banner;

        public BannerAdapterHolder(@NonNull View itemView) {
            super(itemView);

            img_banner = itemView.findViewById(R.id.img_banner);
        }
    }
}
