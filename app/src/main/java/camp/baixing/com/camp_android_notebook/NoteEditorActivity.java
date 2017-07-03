package camp.baixing.com.camp_android_notebook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by zijing on 03/07/2017
 */

public class NoteEditorActivity extends AppCompatActivity {

    public static final String EXTRA_CONTENT = "extra_content";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = (EditText) findViewById(R.id.acitivyt_note_edit);
        String content = getIntent().getStringExtra(EXTRA_CONTENT);
        if (content != null) {
            editText.setText(content);
        }
    }
}
