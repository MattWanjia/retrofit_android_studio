package com.example.andjango;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private Context context;
    private List<Tasks> tasksList;

    public TaskAdapter(Context context, List taskList) {
        this.context = context;
        this.tasksList = taskList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(tasksList.get(position));

        Tasks task = tasksList.get(position);

        holder.title.setText(task.getTitle());
        holder.desc.setText(task.getDescription());

    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id;
        public TextView title;
        public TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.item_id);
            title = (TextView) itemView.findViewById(R.id.item_title);
            desc = (TextView) itemView.findViewById(R.id.item_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Tasks currentTask = (Tasks) view.getTag();

                    Toast.makeText(view.getContext(), currentTask.getTitle(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

}
