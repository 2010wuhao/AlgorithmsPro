package com.leo.algorithms;

import android.app.ActivityManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.leo.algorithms.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
        long max = Runtime.getRuntime().maxMemory();
        Log.d(TAG, "max: max = " + max
                + " totalMemory = " + Runtime.getRuntime().totalMemory()
                + " freeMemory = " + Runtime.getRuntime().freeMemory());
        doSomethingMemoryIntensive();
        testGc();
    }

    public void doSomethingMemoryIntensive() {
        // Before doing something that requires a lot of memory,
        // check to see whether the device is in a low memory state.
        ActivityManager.MemoryInfo memoryInfo = getAvailableMemory();
        Log.d(TAG, "doSomethingMemoryIntensive: availMem = " + memoryInfo.availMem
                + " totalMem = " + memoryInfo.totalMem
                + " threshold = " + memoryInfo.threshold
                + " lowMemory = " + memoryInfo.lowMemory);
        if (!memoryInfo.lowMemory) {
            // Do memory intensive work ...
        }
    }

    // Get a MemoryInfo object for the device's current memory status.
    private ActivityManager.MemoryInfo getAvailableMemory() {
        ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public void testGc() {
        final int[] i = {0};
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        Log.d(TAG, " Thread is Running !!" + i[0]);
                        i[0]++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

}
