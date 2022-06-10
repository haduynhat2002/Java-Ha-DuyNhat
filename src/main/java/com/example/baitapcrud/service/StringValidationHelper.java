package com.example.baitapcrud.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidationHelper {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_VIETNAMESE_PHONE_REGEX =
            Pattern.compile(
                    "(([03+[2-9]|05+[6|8|9]|07+[0|6|7|8|9]|08+[1-9]|09+[1-4|6-9]]){3})+[0-9]{7}\\b",
                    Pattern.CASE_INSENSITIVE);

    public static boolean checkValidEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean checkValidVietnamesePhone(String phone) {
        Matcher matcher = VALID_VIETNAMESE_PHONE_REGEX.matcher(phone);
        return matcher.find();
    }
}
