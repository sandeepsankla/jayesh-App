package com.example.sandeep.myvote;

import android.text.TextUtils;
import android.util.Patterns;

public class Utils {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public static boolean isValidMobile(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.PHONE.matcher(target).matches());
    }
    public static boolean isValidPassWord(CharSequence target) {
        return (!TextUtils.isEmpty(target) && target.length()>5);
    }
    public static boolean isNullorEmpty(CharSequence target) {
        return (TextUtils.isEmpty(target) && target==null);
    }
}
