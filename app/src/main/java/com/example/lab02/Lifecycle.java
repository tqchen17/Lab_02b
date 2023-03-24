package com.example.lab02;

public class Lifecycle {
    int onCreate = 0;
    int onStart = 0;
    int onResume = 0;
    int onPause = 0;
    int onStop = 0;
    int onRestart = 0;
    int onDestroy = 0;

    public int getOnStart() { return onStart; }

    public void updateEvent(String currentEnclosingMethod) {
        switch(currentEnclosingMethod) {
            case "onCreate":
                onCreate++;
                break;
            case "onStart":
                onStart++;
                break;
            case "onResume":
                onResume++;
                break;
            case "onPause":
                onPause++;
                break;
            case "onStop":
                onStop++;
                break;
            case "onRestart":
                onRestart++;
                break;
            case "onDestroy":
                onDestroy++;
                break;
            default:break;
        }
    }
    public void clearEvent() {
        onCreate = 0;
        onStart = 0;
        onResume = 0;
        onPause = 0;
        onStop = 0;
        onRestart = 0;
        onDestroy = 0;
    }
}

