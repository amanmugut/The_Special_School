package com.theErrors.theSpecialSchool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class correctAdapter extends  RecyclerView.Adapter<correctAdapter.viewHolder>{

    String[] questionList;
    String[] options;
    String[] correctAnswer;

    // how many question have been solved
    int marked=0;

    // to make options set
    int check=0;

    // correct answers
    int correct=0;
    Context context;

    public correctAdapter(String[] questionList, String[] options,String[] correctAnswer,Context context) {
        this.correctAnswer=correctAnswer;
        this.questionList = questionList;
        this.options=options;
        this.context = context;

    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.question,parent,false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        String currentQuestion=questionList[position];
        holder.question.setText(currentQuestion);

        holder.optA.setBackgroundResource(R.color.white);
        holder.optB.setBackgroundResource(R.color.white);
        holder.optC.setBackgroundResource(R.color.white);
        holder.optD.setBackgroundResource(R.color.white);



        holder.optA.setText(options[check]);//4
        holder.optB.setText(options[check+1]);//5
        holder.optC.setText(options[check+2]);//6
        holder.optD.setText(options[check+3]);//7
        check=check+4;

        if (holder.optA.getText()==correctAnswer[position]){
            holder.optA.setBackgroundResource(R.drawable.correctbackground);
        }

        if (holder.optB.getText()==correctAnswer[position]){
            holder.optB.setBackgroundResource(R.drawable.correctbackground);
        }

        if (holder.optC.getText()==correctAnswer[position]){
            holder.optC.setBackgroundResource(R.drawable.correctbackground);
        }

        if (holder.optD.getText()==correctAnswer[position]){
            holder.optD.setBackgroundResource(R.drawable.correctbackground);
        }

    }

    @Override
    public int getItemCount() {
        return questionList.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView question;
        TextView optA,optB,optC,optD;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            question=itemView.findViewById(R.id.question);
            optA=itemView.findViewById(R.id.optA);
            optB=itemView.findViewById(R.id.optB);
            optC=itemView.findViewById(R.id.optC);
            optD=itemView.findViewById(R.id.optD);


        }
    }
}
