package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Character victim;
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        victim = new Character("Игрок");
        story = new Story();
        updateStatus();
    }


    private void go(int i) {
        story.go(i + 1);
        updateStatus();
        if (story.isEnd())
            Toast.makeText(this, "Игра закончена!", Toast.LENGTH_LONG).show();
    }


    private void updateStatus() {
        victim.Health += story.current_situation.dHealth;
        victim.Fatigue += story.current_situation.dFatigue;
        victim.Panic += story.current_situation.dPanic;
        ((TextView) findViewById(R.id.status)).
                setText("Здоровье " + victim.Health +
                        "\nУсталость " + victim.Fatigue + "\nПаника " + victim.Panic);
        ((TextView) findViewById(R.id.title)).
                setText(story.current_situation.subject);
        ((TextView) findViewById(R.id.desc)).
                setText(story.current_situation.text);
        ((LinearLayout) findViewById(R.id.layout)).removeAllViews();

        for (int i = 0; i < story.current_situation.direction.length; i++) {
            Button b = new Button(this);
            b.setText(Integer.toString(i + 1));
            final int buttonId = i;

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    go(buttonId);
                }
            });
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
        }
    }

}
