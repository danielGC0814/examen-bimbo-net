package com.bimbo.net.applogin.util;

import android.content.Context;

import androidx.fragment.app.Fragment;

public interface HandlerActionActivity {
    void showDialogProgressBar(String message, Context context);

    void hideDialogProgressBar();
}
