package apprecycler.simbirsoft.com.androidrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import android.view.Menu;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements ViewAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ViewAdapter viewAdapter;

    private EditText editText;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(android.R.id.list);

        createLayoutManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Уведомления");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void createLayoutManager() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setUpAdapter();
    }

    private void setUpAdapter() {
        viewAdapter = new ViewAdapter(generateData(), this);
        recyclerView.setAdapter(viewAdapter);
    }

    private Data generateData() {
        Data data = new Data();
        data.dataBase = new ArrayList<>();
        data.dataTime = new ArrayList<>();

        data.dataBase.add("Вход в систему с устройства iPhone, Телефон горячей линии 8 (800) 870-87-00");
        data.dataTime.add("14:55");

        data.dataBase.add("Новое сообщение в чате");
        data.dataTime.add("15:45");

        data.dataBase.add("\n\n");
        data.dataTime.add("4 часа назад");

        data.dataBase.add("Уважаемый клиент! Спасибо за " +
                "установку приложения страховой " +
                "фирмы. Мы ценим наших клиентов не " +
                "будем надоедать уведомлениями");
        data.dataTime.add("2 часа назад");

        return data;
    }

    private int getSize() {
        return viewAdapter != null ? viewAdapter.getItemCount() : 0;
    }

    @Override
    public void onClick(int position, String value) {

    }
}
