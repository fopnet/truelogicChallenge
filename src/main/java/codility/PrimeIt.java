package com.example.demo;

public class PrimeIt {

    public String solution(String s) {
        char c = s.charAt(0);
        int code = c;
        if (code >= 65 && code <= 90)    {  // please fix condition
            return "upper";
        } else if (code >= 97 && code <= 122) {  // please fix condition
            return "lower";
        } else if (code>=48 && code<=57) {  // please fix condition
            return "digit";
        } else {
            return "other";
        }
    }

    public static void main(String[] args) {
      System.out.println(new PrimeIt().solution("!abc"));

    } 
}