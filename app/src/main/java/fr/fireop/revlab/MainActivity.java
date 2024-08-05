package fr.fireop.revlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import fr.fireop.revlab.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'revlab' library on application startup.
    static {
        System.loadLibrary("revlab");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.v("LAB_JAVA", "Log from Java");

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'revlab' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
