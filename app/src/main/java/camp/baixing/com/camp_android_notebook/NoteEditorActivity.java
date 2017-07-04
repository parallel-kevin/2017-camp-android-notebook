package camp.baixing.com.camp_android_notebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by zijing on 03/07/2017
 */

public class NoteEditorActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_CONTENT = "extra_content";
    private final int MEMO_ADD = 0;
    private final int MEMO_EDIT = 1;
    private final int MEMO_DELETE = 2;
    private int editState;
    private String formerTitle;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
        editState = MEMO_ADD;

        Button btnDelete = (Button)findViewById(R.id.activity_note_delete_button);
        editor= getSharedPreferences("memo", MODE_PRIVATE).edit();

        /*  读取传入的标题和内容  */
        EditText editTitle = (EditText) findViewById(R.id.activity_note_title);
        EditText editContent = (EditText) findViewById(R.id.activity_note_edit);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String content = getIntent().getStringExtra(EXTRA_CONTENT);
        if ((title != null) && (content != null)) {
            editTitle.setText(title);
            editContent.setText(content);
            formerTitle = title;
            editState = MEMO_EDIT;
        }
        else
            /*  新增时隐藏删除按钮  */
            btnDelete.setVisibility(View.INVISIBLE);

        /*  删除按钮事件  */
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editState = MEMO_DELETE;
                Intent intent = new Intent(NoteEditorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        /*  根据editState更新备忘录  */
        EditText editTitle = (EditText) findViewById(R.id.activity_note_title);
        EditText editContent = (EditText) findViewById(R.id.activity_note_edit);
        if (editState == MEMO_EDIT) {
            editor.remove(formerTitle);
            editor.putString(editTitle.getText().toString(), editContent.getText().toString());
        }
        else if (editState == MEMO_ADD)
            editor.putString(editTitle.getText().toString(), editContent.getText().toString());
        else if (editState == MEMO_DELETE)
            editor.remove(formerTitle);
        editor.commit();
    }
}
