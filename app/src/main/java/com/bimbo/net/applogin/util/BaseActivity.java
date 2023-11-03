package com.bimbo.net.applogin.util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.bimbo.net.applogin.R;

public class BaseActivity extends AppCompatActivity implements HandlerActionActivity {

    private Dialog progressBarDialog;

    @Override
    public void showDialogProgressBar(String message, Context context) {
        progressBarDialog = new Dialog(context);
        View customLayout = LayoutInflater.from(context).inflate(R.layout.dialog_progress_custom,null);
        progressBarDialog.setContentView(customLayout);
        progressBarDialog.setCanceledOnTouchOutside(true);
        progressBarDialog.getWindow().setBackgroundDrawableResource(R.drawable.np_shape_background_dialog);
        progressBarDialog.show();
    }

    @Override
    public void hideDialogProgressBar() {
        if(progressBarDialog != null){
            progressBarDialog.dismiss();
            progressBarDialog.cancel();
            progressBarDialog = null;
        }
    }
}