package app.projeto.appifoodjava.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import app.projeto.appifoodjava.R;
import app.projeto.appifoodjava.adapters.ViewPageAdapter;
import app.projeto.appifoodjava.databinding.ActivityMainBinding;
import app.projeto.appifoodjava.fragments.BuscarFragment;
import app.projeto.appifoodjava.fragments.DrinksFragment;
import app.projeto.appifoodjava.fragments.InicioFragment;
import app.projeto.appifoodjava.fragments.MarketplaceFragment;
import app.projeto.appifoodjava.fragments.PedidosFragment;
import app.projeto.appifoodjava.fragments.PerfilFragment;
import app.projeto.appifoodjava.fragments.RestaurantFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){

                case R.id.inicio:
                    replaceFragment(new InicioFragment());
                    break;
                case R.id.buscar:
                    replaceFragment(new BuscarFragment());
                    break;
                case R.id.pedidos:
                    replaceFragment(new PedidosFragment());
                    break;
                case R.id.perfil:
                    replaceFragment(new PerfilFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutMain, fragment);
        fragmentTransaction.commit();
    }
}