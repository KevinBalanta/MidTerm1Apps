package com.example.challenge1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.challenge1.R;
import com.example.challenge1.activities.model.data.ArithmeticOperationGenerator;
import com.example.challenge1.activities.model.data.ScoreManager;

public class ArithmeticOperation extends AppCompatActivity {


    private ScoreManager arithmeticOperationManager;
    private ArithmeticOperationGenerator arithmeticOperationGenerator;
    private TextView operationTv;
    private Button operationBut;
    private EditText operationEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_operation);
        arithmeticOperationManager = new ScoreManager(this.getApplicationContext());
        arithmeticOperationGenerator = new ArithmeticOperationGenerator();
        operationTv = findViewById(R.id.operation_tv);
        operationBut = findViewById(R.id.operation_button);
        operationEt = findViewById(R.id.operation_et);

        operationTv.setText(arithmeticOperationGenerator.generateRandomOperation());
        operationBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result = operationEt.getText().toString();
                if(!result.isEmpty()) {

                    boolean respond = arithmeticOperationGenerator.solveOperation(Integer.parseInt(result));
                    arithmeticOperationManager.setPoint(respond);

                    Intent i = new Intent();
                    String r = (respond) ?  "Felicitaciones +1 punto" :  "practica más -1 punto ";
                    i.putExtra("resultado", r);
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });
    }
}
