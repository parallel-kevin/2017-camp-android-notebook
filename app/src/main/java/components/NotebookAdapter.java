package components;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import camp.baixing.com.camp_android_notebook.NoteEditorActivity;

/**
 * Created by zijing on 03/07/2017
 */

public class NotebookAdapter extends RecyclerView.Adapter<NoteItemViewHolder> {

    private List<String> title;
    private List<String> data;
    private Context context;

    public NotebookAdapter(Context context, List<String> title, List<String> data) {
        this.context = context;
        this.title = title;
        this.data = data;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return title == null ? 0 : title.size();
    }

    @Override
    public NoteItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NoteItemViewHolder(context, parent);
    }

    @Override
    public void onBindViewHolder(final NoteItemViewHolder holder, int position) {
        if (holder != null && title != null) {
            holder.setText(title.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoteEditorActivity.class);
                    intent.putExtra(NoteEditorActivity.EXTRA_TITLE, title.get(holder.getAdapterPosition()));
                    intent.putExtra(NoteEditorActivity.EXTRA_CONTENT, data.get(holder.getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }
}
