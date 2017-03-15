package topsecretinformation.javaproject_v11;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;


public class StartActivity extends AppCompatActivity {

    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // получаём и записываем в переменную ActionBar
        ActionBar actionBar = getSupportActionBar();

        // включаем иконку, иначе не будет отображаться
        actionBar.setDisplayHomeAsUpEnabled(true);
        // устанавливаем для неё картинку
        actionBar.setHomeAsUpIndicator(android.R.drawable.ic_input_delete);
        // устанавливаем заголовок
        actionBar.setTitle("Title");
        // устанавливаем подзаголовок
        actionBar.setSubtitle("Subtitle");

        // настраиваем тулбар
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // отображаем ДОМОЙ
        getSupportActionBar().setHomeButtonEnabled(true); // включаем ДОМОЙ
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawwwwer_layout); // находим меню
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0); // создаём штуку, которая будет анимировать иконку (и не только)
        mDrawerLayout.addDrawerListener(mDrawerToggle); // подписываем её на события открытия и закрытия меню (чтобы она знала, когда нужно анимировать кнопку)

        NavigationView navigationView = (NavigationView) findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.favourites_item:
                        Toast.makeText(StartActivity.this, "Избранное", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.settings_item:
                        Intent intent = new Intent(StartActivity.this, SettingsActivityh.class);
                        startActivity(intent);
                        break;
                }

                mDrawerLayout.closeDrawer(Gravity.START);

                return true;
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { // если нажали на
            case android.R.id.home: // кнопку перехода в чат
                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawwwwer_layout);
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.openDrawer(GravityCompat.START);
                } else {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            default:
                return true;
        }
    }




    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
