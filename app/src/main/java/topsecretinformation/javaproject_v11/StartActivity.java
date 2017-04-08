package topsecretinformation.javaproject_v11;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kuelye.banana.examples.tinydatabaser.TinyDatabaser;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private GoogleApiClient client;
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;
    MessageAdapter adapter; // адаптер
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        ActionBar actionBar = getSupportActionBar();
        // включаем иконку, иначе не будет отображаться
        actionBar.setDisplayHomeAsUpEnabled(true);
        // устанавливаем для неё картинку
        actionBar.setHomeAsUpIndicator(R.drawable.ic_flight_land_black_24dp);
        // устанавливаем заголовок
        actionBar.setTitle("Навигационный ИИ NX-7422 Philanthrop");
        // устанавливаем подзаголовок
        actionBar.setSubtitle("HKH-474");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawwwwer_layout); // находим меню
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0); // создаём штуку, которая будет анимировать иконку (и не только)
        mDrawerLayout.addDrawerListener(mDrawerToggle); // подписываем её на события открытия и закрытия меню (чтобы она знала, когда нужно анимировать кнопку)

        mNavigationView = (NavigationView) findViewById(R.id.navi);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_2_item:
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

        initializeChat();
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

    private void initializeChat() {
        final TinyDatabaser dataBase = new TinyDatabaser(StartActivity.this, R.raw.globe_x);

        // настраиваем список
        ListView listView = (ListView) findViewById(R.id.listView); // находим список
        Context context = this; // создаём переменную для контекста
        int resource = android.R.layout.simple_list_item_1; // создаём переменную для макета отдельного сообщения
        List<Message> messages = new ArrayList<>(); // создаём переменную для сообщений (пока пустую)
        adapter = new MessageAdapter(context, resource, messages);
        listView.setAdapter(adapter);
        // настраиваем обработку ввода сообщений
        final EditText editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // actionId - действие, которое произошло
                if (actionId == EditorInfo.IME_ACTION_DONE) { // если нажали ENTER
                    String text = editText.getText().toString(); // сохраняем сообщение в переменную
                    Message message1 = new Message(text, Message.SENDER_USER);
                    addMessage(message1); // добавляем сообщение в чат

                    String value = dataBase.find(text);
                    Message message2 = new Message(value, Message.SENDER_BOT);
                    addMessage(message2);

                    if (text.equals("Пряник вкусный")) {
                        MenuItem bot2Item = mNavigationView.getMenu().findItem(R.id.bot_2_item);
                        bot2Item.setVisible(true);
                        addMessage(new Message("Вкусный пряник! Дополнительные функции бота разблокированы!", Message.SENDER_BOT));
                    }
                }
                return true;
            }
        });
        Message messageFromBot = new Message("Вас приветствует Philanthrop! Если не знаете как задать вопрос напишите '!help list' ", Message.SENDER_BOT);
        addMessage(messageFromBot);

    }

    private void addMessage(final Message message) {
        adapter.add(message);
    }
}
