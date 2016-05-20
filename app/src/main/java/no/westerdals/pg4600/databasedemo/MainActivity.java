package no.westerdals.pg4600.databasedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LightDataSource lightDataSource = new LightDataSource(this);

        lightDataSource.open();

        Light light1 = new Light();
        light1.setAccuracy(12);
        light1.setValue(34);
        lightDataSource.saveLight(light1);

        Light light2 = new Light();
        light2.setAccuracy(48);
        light2.setValue(2);
        lightDataSource.saveLight(light2);

        List<Light> lightMeasurements = lightDataSource.getLightMeasurements();

        TextView lightsTextView = (TextView) findViewById(R.id.lightsTextView);
        assert lightsTextView != null;
        lightsTextView.setText("Found lights: " + lightMeasurements);

        lightDataSource.close();
    }
}
