package com.theErrors.theSpecialSchool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuizAdapter extends  RecyclerView.Adapter<QuizAdapter.viewHolder>{

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

    public QuizAdapter(String [] questionList, String[] options,String[] correctAnswer,Context context) {
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


        holder.optA.setText(options[check]);//4
        holder.optB.setText(options[check+1]);//5
        holder.optC.setText(options[check+2]);//6
        holder.optD.setText(options[check+3]);//7
        check=check+4;

        holder.optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked++;
                holder.optB.animate().alpha(0f).setDuration(2000);
                holder.optC.animate().alpha(0f).setDuration(2000);
                holder.optD.animate().alpha(0f).setDuration(2000);
                if (marked==questionList.length){
//                    Toast.makeText(context, "level Completed", Toast.LENGTH_SHORT).show();
                    if (holder.optA.getText()==correctAnswer[position]){
//                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                        correct++;

                    }
                    Intent intent=new Intent(holder.optA.getContext(),answersActivity.class);
                    intent.putExtra("corrected",correct);
                    holder.optA.getContext().startActivity(intent);
                    ((Activity)context).finish();

                }

                if (holder.optA.getText()==correctAnswer[position]){
//                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                    correct++;

                }

            }
        });

        holder.optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked++;
                holder.optA.animate().alpha(0f).setDuration(2000);
                holder.optC.animate().alpha(0f).setDuration(2000);
                holder.optD.animate().alpha(0f).setDuration(2000);

                if (marked==questionList.length){

                    if (holder.optB.getText()==correctAnswer[position]){
//                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                        correct++;

                    }
//                    Toast.makeText(context, "level Completed", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(holder.optB.getContext(),answersActivity.class);
                    intent.putExtra("corrected",correct);
                    holder.optB.getContext().startActivity(intent);
                    ((Activity)context).finish();


                }

                if (holder.optB.getText()==correctAnswer[position]){
//                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                    correct++;

                }



            }
        });

        holder.optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked++;
                holder.optA.animate().alpha(0f).setDuration(2000);
                holder.optB.animate().alpha(0f).setDuration(2000);
                holder.optD.animate().alpha(0f).setDuration(2000);

                if (marked==questionList.length){

                    if (holder.optC.getText()==correctAnswer[position]){
//                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                        correct++;

                    }
//                    Toast.makeText(context, "level Completed", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(holder.optC.getContext(),answersActivity.class);
                    intent.putExtra("corrected",correct);

                    holder.optC.getContext().startActivity(intent);
                    ((Activity)context).finish();


                }

                if (holder.optC.getText()==correctAnswer[position]){
//                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                    correct++;

                }



            }
        });

        holder.optD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked++;
                holder.optA.animate().alpha(0f).setDuration(2000);
                holder.optB.animate().alpha(0f).setDuration(2000);
                holder.optC.animate().alpha(0f).setDuration(2000);

                if (marked==questionList.length){
//                    Toast.makeText(context, "level Completed", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(holder.optD.getContext(),answersActivity.class);
                    intent.putExtra("corrected",correct);
                    holder.optD.getContext().startActivity(intent);
                    ((Activity)context).finish();



                }

                if (holder.optD.getText()==correctAnswer[position]){
//                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                    correct++;

                }



            }
        });



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
