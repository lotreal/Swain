package im.lot.swain;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import im.lot.swain.annotation.InjectExtra;

public class AboutActivity extends AppCompatActivity {
    @Bind(value = R.id.textView2)
    TextView textView2;

    @InjectExtra(value = "config", optional = true)
    Config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        App.component(this).inject(this);
        AboutActivityMyInjector.inject(this);
        ButterKnife.bind(this);

        Log.d("MAIN ABOUT", config.toString());
        Log.d("MAIN ABOUT", textView2.toString());
    }

}
