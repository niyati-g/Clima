package com.example.clima;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import android.os.Bundle;

public class PermissionManager{
    private static PermissionManager instance = null;
    private Context context;
    private PermissionManager(){

    }
    public static PermissionManager getInstance(Context context)
    {
        if (instance == null){
            instance = new PermissionManager();
        }
        instance.init(context);
        return instance;
    }
    private void init(Context context){
        this.context = context;
    }
    boolean checkPermissions(String [] permissions){
        int numberOfPermissions = permissions.length;
        int numberOfPermissionsGranted = 0;
        boolean isLocationPermissionGranted =false ;
        for (int i=0;i<numberOfPermissions;i++){
            if (ContextCompat.checkSelfPermission(context,permissions[i])==PermissionChecker .PERMISSION_GRANTED){
                numberOfPermissionsGranted = numberOfPermissionsGranted +1;
            }
        }
        if (numberOfPermissionsGranted==numberOfPermissions){
            isLocationPermissionGranted = true;
        }else{
            isLocationPermissionGranted =false;
        }
        return isLocationPermissionGranted;
    }

    boolean checkPreciseAndApproximateLocationPermsissions(String[] permissions){
        int numberOfPermissions = permissions.length;
        int numberOfPermissionsGranted = 0;
        boolean isLocationPermissionGranted =false ;
        for (int i=0;i<numberOfPermissions;i++){
            if (ContextCompat.checkSelfPermission(context,permissions[i])==PermissionChecker .PERMISSION_GRANTED){
                numberOfPermissionsGranted = numberOfPermissionsGranted +1;
            }
        }
        if (numberOfPermissionsGranted>0){
            isLocationPermissionGranted = true;
        }else{
            isLocationPermissionGranted =false;
        }
        return isLocationPermissionGranted;
    }


    void askPermissions (Activity activity,String[] permissions ,int requestCode){
        ActivityCompat.requestPermissions(activity,permissions,requestCode);
    }


    boolean handlePreciseLocationPermissionsResult(int[] grantResults){
        if (grantResults.length>0){
            boolean areAllPermissionsGranted =true ;

            if (grantResults[0] ==PackageManager.PERMISSION_DENIED){
                areAllPermissionsGranted = false;
            }
                return areAllPermissionsGranted;
        }
        return false;
    }

}