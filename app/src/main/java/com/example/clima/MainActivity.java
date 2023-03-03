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

public class MainActivity{
    private static PermissionManager instance = null;
    private Context context;
    private PermissionManager(){

    }

}