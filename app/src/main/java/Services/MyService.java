package Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public Context context = this;
    public android.os.Handler handler = null;
    public Runnable runnable = null;
    public MyService() {}


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Create", Toast.LENGTH_SHORT).show();
        handler = new Handler();
        runnable = new Runnable() {
            public void run(){
                double randomNo = getRandomDoubleBetween(1,100);
                Toast.makeText(context, "Random no:" + randomNo, Toast.LENGTH_SHORT).show();
                handler.postDelayed(runnable, 2000);
            }
        };
        handler.postDelayed(runnable,2000);
    }
    public static double getRandomDoubleBetween(double min, double max){
        return (Math.random()*((max-min)+1))+min;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }
}
