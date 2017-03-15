package topsecretinformation.javaproject_v11;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;



public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


    // получаём и записываем в переменную ActionBar
    ActionBar actionBar = getSupportActionBar();

// включаем иконку, иначе не будет отображаться
    actionBar.setDisplayHomeAsUpEnabled(true);
// устанавливаем для неё картинку
    actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_36dp);
// устанавливаем заголовок
    actionBar.setTitle(!.title);
// устанавливаем подзаголовок
    actionBar.setSubtitle(!.titleEnglish);

    // настраиваем тулбар
    StartActivity().setDisplayHomeAsUpEnabled(true); // отображаем ДОМОЙ
    getSupportActionBar().setHomeButtonEnabled(true); // включаем ДОМОЙ
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // находим меню
    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0); // создаём штуку, которая будет анимировать иконку (и не только)
    mDrawerLayout.addDrawerListener(mDrawerToggle); // подписываем её на события открытия и закрытия меню (чтобы она знала, когда нужно анимировать кнопку)

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
