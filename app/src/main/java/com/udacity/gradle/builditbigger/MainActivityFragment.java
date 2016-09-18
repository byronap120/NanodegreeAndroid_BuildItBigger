package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jokeactivity.JokeActivity;
import com.udacity.gradle.builditbigger.task.AsyncResponse;
import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment  implements AsyncResponse {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) root.findViewById(R.id.tell_joke);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startJokeTask();
            }
        });

        return root;
    }

    private void startJokeTask(){
        new EndpointsAsyncTask(this, getContext()).execute();
    }

    @Override
    public void processFinish(String output) {
        Intent openJokeIntent = new Intent(getContext(), JokeActivity.class);
        openJokeIntent.putExtra(JokeActivity.JOKE_INTENT_VALUE, output);
        startActivity(openJokeIntent);
    }
}
