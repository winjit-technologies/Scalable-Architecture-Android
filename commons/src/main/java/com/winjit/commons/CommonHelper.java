package com.winjit.commons;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import android.support.design.widget.Snackbar;
import com.squareup.picasso.Picasso;

public class CommonHelper {

    /**
     * Method used to show toast on screen
     * @param mMessage
     */
    public void showToast(Context context, String mMessage){
        Toast.makeText(context, mMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * Method used to show snack bar on screen
     * @param view : view to which snack bar attached
     * @param message : message to display on snack bar
     */
    public void showSnackBar(View view, String message){
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    /**
     * Share Intent for url text
     */
    public void shareTextUrl(Activity activity) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "About");
        share.putExtra(Intent.EXTRA_TEXT, "https://branded.me/prakash-gavhane");

        activity.startActivity(Intent.createChooser(share, "About"));
    }

    /**
     * Asynchronously load image using picasso
     * @param url
     * @param target
     */
    public void loadImageAsync(Context context, String url, ImageView target, int defaultImage, int errorImage) {
        Picasso.with(context)
                .load(url)
                .placeholder(defaultImage)
                .error(errorImage)
                .into(target);
    }

    /**
     * Method used to create progress dialog
     * @param activity
     * @param message
     * @return
     */
    public ProgressDialog createLoadingDialog(Activity activity, String message) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        return  progressDialog;
    }

    /**
     * Method used to add fragment on activity
     * @param fragmentManager
     * @param layout
     * @param fragment
     * @param isBackStack decide to add fragment with back stack or not.
     */
    public void replaceFragment(FragmentManager fragmentManager, int layout, Fragment fragment, boolean isBackStack){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (fragmentManager.findFragmentByTag(fragment.getClass().getSimpleName()) == null) {
            if (isBackStack)
                fragmentTransaction.replace(layout, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
            else
                fragmentTransaction.replace(layout, fragment).commit();
        } else {

            Fragment requestedFragment = fragmentManager.findFragmentByTag(fragment.getClass().getSimpleName());

            if (requestedFragment != null) {
                for (Fragment f : fragmentManager.getFragments()) {
                    if (f == requestedFragment)
                        fragmentTransaction.show(f);
                    else
                        fragmentTransaction.hide(f);
                }
                fragmentTransaction.commit();
            }
        }
    }

    /**
     * Method used to remove all fragments from activity
     * @param fragmentManager
     */
    public void removeAllFragments(FragmentManager fragmentManager) {
        for(int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
            fragmentManager.popBackStack();
        }
        // OR
        // fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}