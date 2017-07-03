package camp.baixing.com.camp_android_notebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import components.NotebookAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_main_listview);

        final List<String> data = Arrays.asList(
                "香港各界对习近平重要讲话反响热烈",
                "嫌犯拒不交代章莹颖下落",
                "特朗普:假媒体曾想阻挠我入主白宫"
        );

        NotebookAdapter adapter = new NotebookAdapter(this, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
