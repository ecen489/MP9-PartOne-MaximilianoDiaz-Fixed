package com.example.mp9_partone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> script = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> Script) {
        script = Script;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called " + i);
        String quote = script.get(i);

        viewHolder.textFound.setText(quote);

        viewHolder.parentLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "removing: " + script.get(i));
                Toast.makeText(mContext, "Removed " + viewHolder.textFound.getText().toString(), Toast.LENGTH_SHORT).show();
                script.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeRemoved(i, script.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.v("GetItemCount: ", "" + script.size());
        return script.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textFound;
        View parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textFound = itemView.findViewById(R.id.textfoundView);
            parentLayout = itemView;

        }
    }

}
