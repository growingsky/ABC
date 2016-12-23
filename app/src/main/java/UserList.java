import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import de.freshmaninandroid.app_programmierung.newproject.adapter.ItemDecoration;
import de.freshmaninandroid.app_programmierung.newproject.adapter.RecyclerAdapter;
import de.freshmaninandroid.app_programmierung.newproject.object.User;

public class UserList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // linearLayoutManager.scrollToPosition(6);
        RecyclerView.ItemDecoration myItemDecoration = new ItemDecoration();
        //  recyclerView.setLayoutManager(linearLayoutManager);

        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(myItemDecoration);
        initializeData();
        initializeAdpter();


    }

    public void initializeData() {
        users = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            users.add(new User("Джон Джон", "Скрамместер"));
            users.add(new User("Стив Стивенс", "Проектменеджер"));
            users.add(new User("Василий Пупки", "Разработчик"));
        }

    }


    public void initializeAdpter() {


        adapter = new RecyclerAdapter(users);
        recyclerView.setAdapter(adapter);
    }


}


