package net.gfdz.com.serviec01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean serviceRunning=false;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       /* new Thread(){
            @Override
            public void run() {
                while(true){

                    System.out.println("服务正在运行");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();*/
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        System.out.println("onCreate");
        serviceRunning=true;
       new Thread(){
            @Override
            public void run() {
                while(serviceRunning){

                    System.out.println("服务正在运行");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        serviceRunning=false;
    }
}
