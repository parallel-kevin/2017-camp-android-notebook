package camp.baixing.com.camp_android_notebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import components.NotebookAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*  增加按钮事件  */
        Button btnAdd = (Button)findViewById(R.id.activity_main_add_button);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoteEditorActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_main_listview);

        /*  读取备忘录  */
        SharedPreferences pref = getSharedPreferences("memo", MODE_PRIVATE);
        Map<String, ?> content = pref.getAll();
        List<String> title = new ArrayList<>(content.keySet());
        List<String> data = new ArrayList<>((Collection<String>)content.values());

        NotebookAdapter adapter = new NotebookAdapter(this, title, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
