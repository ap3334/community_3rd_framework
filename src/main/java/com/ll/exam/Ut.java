package com.ll.exam;

public class Ut {
    public static class Str {

        public static String deCapitalize(String string) {

            if (string == null || string.length() == 0) {
                return string;
            }

            char c[] = string.toCharArray();
            c[0] = Character.toLowerCase(c[0]);

            return new String(c);

        }
    }
}