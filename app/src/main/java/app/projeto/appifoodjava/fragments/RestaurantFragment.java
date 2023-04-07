package app.projeto.appifoodjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;

import java.util.ArrayList;
import java.util.List;

import app.projeto.appifoodjava.R;
import app.projeto.appifoodjava.adapters.BannerAdapter;
import app.projeto.appifoodjava.adapters.CategoryAdapter;
import app.projeto.appifoodjava.adapters.MoreShopAdapter;
import app.projeto.appifoodjava.adapters.ShopAdapter;
import app.projeto.appifoodjava.model.Banner;
import app.projeto.appifoodjava.model.Category;
import app.projeto.appifoodjava.model.MoreShop;
import app.projeto.appifoodjava.model.Shop;

public class RestaurantFragment extends Fragment {

    View v;
    LinearLayout dots;

    private List<Category> categoryList;
    private List<Shop> shopList;
    private List<MoreShop> moreShopList;
    private List<Banner> bannerList;

    RecyclerView rv_category;
    RecyclerView rv_shops;
    RecyclerView rv_more_shops;
    RecyclerView rv_banners;

    public RestaurantFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_restaurant, container,false);

        rv_category = v.findViewById(R.id.rv_category);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), categoryList);
        rv_category.setAdapter(categoryAdapter);
        rv_category.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_banners = v.findViewById(R.id.rv_banners);
        BannerAdapter bannerAdapter = new BannerAdapter(getContext(), bannerList);
        rv_banners.setAdapter(bannerAdapter);
        rv_banners.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        dots = v.findViewById(R.id.dots);

        rv_banners.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    notifyPositionChanged(recyclerView);
                }
            }
        });

        rv_shops = v.findViewById(R.id.rv_shops);
        ShopAdapter shopAdapter = new ShopAdapter(getContext(), shopList);
        rv_shops.setAdapter(shopAdapter);
        rv_shops.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_more_shops = v.findViewById(R.id.rv_more_shops);
        MoreShopAdapter moreShopAdapter = new MoreShopAdapter(getContext(), moreShopList);
        rv_more_shops.setAdapter(moreShopAdapter);
        rv_more_shops.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        categoryList = new ArrayList<>();
        categoryList.add(new Category("Mercado", R.drawable.market, R.color.red));
        categoryList.add(new Category("Restaurante", R.drawable.restaurant, R.color.yellow));
        categoryList.add(new Category("Bebidas", R.drawable.drinks, R.color.blue));
        categoryList.add(new Category("Saudável", R.drawable.saudavel, R.color.purple));
        categoryList.add(new Category("Salgados", R.drawable.salgados, R.color.red));
        categoryList.add(new Category("Express", R.drawable.express, R.color.yellow));


        bannerList = new ArrayList<>();
        bannerList.add(new Banner(0, R.drawable.bannerpromocao));
        bannerList.add(new Banner(1, R.drawable.bannerifood));
        bannerList.add(new Banner(2, R.drawable.bannerapp));

        shopList = new ArrayList<>();
        shopList.add(new Shop(R.drawable.pizzacrek, "Pizza Crek"));
        shopList.add(new Shop(R.drawable.frabricaesfira, "Fábrica de Esfiha"));
        shopList.add(new Shop(R.drawable.pecorino, "Pecorino"));
        shopList.add(new Shop(R.drawable.barbacoa, "Barbacoa Grill"));
        shopList.add(new Shop(R.drawable.bolomadre, "Bolo de Madre"));
        shopList.add(new Shop(R.drawable.uauesfira, "Uau Esfiha"));
        shopList.add(new Shop(R.drawable.barjuarez, "Bar do Juarez"));


        moreShopList = new ArrayList<>();
        moreShopList.add(new MoreShop(R.drawable.pizzacrek, "Shop 1", 4.5, "Pizza", 11.2, "60-70", 26.00));
        moreShopList.add(new MoreShop(R.drawable.frabricaesfira, "Shop 2", 4.5, "Pizza", 11.2, "60-70", 26.00));
        moreShopList.add(new MoreShop(R.drawable.pecorino, "Shop 3", 4.5, "Pizza", 11.2, "60-70", 26.00));
        moreShopList.add(new MoreShop(R.drawable.barbacoa, "Shop 4", 4.5, "Pizza", 11.2, "60-70", 26.00));
        moreShopList.add(new MoreShop(R.drawable.uauesfira, "Shop 5", 4.5, "Pizza", 11.2, "60-70", 26.00));
        moreShopList.add(new MoreShop(R.drawable.barjuarez, "Shop 6", 4.5, "Pizza", 11.2, "60-70", 26.00));
        moreShopList.add(new MoreShop(R.drawable.pecorino, "Shop 7", 4.5, "Pizza", 11.2, "60-70", 26.00));

    }

    private void addDots(LinearLayout container, int size, int position){
        container.removeAllViews();

        for (int i = 0; i < size; i++) {
            TextView textView = new TextView(container.getContext());
            textView.setText(getString(R.string.dotted));
            textView.setTextSize(30f);
            int textColor = (position == i) ? ContextCompat.getColor(container.getContext(), R.color.black) : ContextCompat.getColor(container.getContext(), R.color.gray);
            textView.setTextColor(textColor);
            container.addView(textView);
        }
    }

    private Integer position = RecyclerView.NO_POSITION;
    private final LinearSnapHelper snapHelper = new LinearSnapHelper();

    private void notifyPositionChanged(RecyclerView recyclerView){
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        View view = snapHelper.findSnapView(layoutManager);
        Integer position;
        if ((view == null)) {
            position = RecyclerView.NO_POSITION;
        } else {
            assert layoutManager != null;
            position = layoutManager.getPosition(view);
        }


        boolean positionChanged = !position.equals(this.position);
        if(positionChanged){
            addDots(dots, bannerList.size(), position);
        }
        this.position = position;
    }

}