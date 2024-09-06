package Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutapi.R;

import java.util.ArrayList;

import Model.Model;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    @NonNull
    ArrayList<Model> list;
    Context context;
    public Adapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Model model=list.get(position);
        holder.muscles.setText(model.getMuscles());
        holder.workout.setText(model.getWorkout());
        holder.intensity.setText(model.getIntensity());
        holder.beginnersets.setText(model.getBeginnersets());
        holder.intermediatesets.setText(model.getIntermediatesets());
        holder.expertsets.setText(model.getExpertsets());
        holder.equipment.setText(model.getEquipment());
        holder.explanation.setText(model.getExplanation());
        holder.longexplanation.setText(model.getLongexplanation());
        holder.link.setText(model.getLink());
        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = model.getLink();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setPackage("com.google.android.youtube");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView muscles,workout,intensity,beginnersets,intermediatesets,expertsets,equipment,explanation,longexplanation,link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            muscles = itemView.findViewById(R.id.musc);
            workout = itemView.findViewById(R.id.work);
            intensity = itemView.findViewById(R.id.intens);
            beginnersets = itemView.findViewById(R.id.beng);
            intermediatesets = itemView.findViewById(R.id.inter);
            expertsets = itemView.findViewById(R.id.exp);
            equipment = itemView.findViewById(R.id.equip);
            explanation = itemView.findViewById(R.id.explan);
            longexplanation = itemView.findViewById(R.id.longexplan);
            link = itemView.findViewById(R.id.link);
        }
    }
}
