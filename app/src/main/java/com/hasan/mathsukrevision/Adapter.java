package com.hasan.mathsukrevision;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements Filterable {

    Context context;
    Activity activity;
    List<NotesModel> notesList;
    List<NotesModel> searchNotesList;

    public Adapter(Context context, Activity activity, List<NotesModel> notesList) {
        this.context = context;
        this.activity = activity;
        this.notesList = notesList;
        searchNotesList = new ArrayList<>(notesList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text_title.setText(notesList.get(position).getText_title());
        holder.note_description.setText(notesList.get(position).getNote_description());

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    @Override
    public Filter getFilter() {
        return aFilter;
    }

    private Filter aFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<NotesModel> constraintList = new ArrayList<>();

            //No constraint equivalent to view all notes
            if (constraint == null || constraint.length() == 0) {
                constraintList.addAll(searchNotesList);

            } else {
                //Reference constraint matching string and loop through matching note items
                String constraintMatch = constraint.toString().toLowerCase().trim();

                for (NotesModel item:searchNotesList) {
                    if (item.getText_title().toLowerCase().contains(constraintMatch)) {
                        constraintList.add(item);

                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = constraintList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            notesList.clear();
            notesList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text_title, note_description;
        RelativeLayout single_note_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_title = itemView.findViewById(R.id.text_title);
            note_description = itemView.findViewById(R.id.note_description);
            single_note_layout = itemView.findViewById(R.id.layout_single_note);
        }
    }
}
