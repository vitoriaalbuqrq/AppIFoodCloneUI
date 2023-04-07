package app.projeto.appifoodjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

import app.projeto.appifoodjava.R;
import app.projeto.appifoodjava.adapters.ViewPageAdapter;


public class InicioFragment extends Fragment {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    public InicioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        configTabLayout();

    }

    private void configTabLayout(){

        ViewPageAdapter adapter = new ViewPageAdapter(requireActivity());
        viewPager.setAdapter(adapter);

        adapter.addFragment(new RestaurantFragment(), "Restaurantes");
        adapter.addFragment(new MarketplaceFragment(), "Mercados");
        adapter.addFragment(new DrinksFragment(), "Bebidas");

        viewPager.setOffscreenPageLimit(adapter.getItemCount());

        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(adapter.getTitle(position));
        });

        mediator.attach();
    }
}