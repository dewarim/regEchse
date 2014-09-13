package de.dewarim.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class CheckRegex {
    
    String text1;
    String text2;
    
    Boolean firstOk;
    Boolean secondOk;
    
    String regex;

    public CheckRegex(String text1, String text2, String regex) {
        this.text1 = text1;
        this.text2 = text2;
        this.regex = regex;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text1);
        firstOk = matcher.find();
        Matcher secondMatcher = pattern.matcher(text2);
        secondOk = secondMatcher.find();
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public Boolean getFirstOk() {
        return firstOk;
    }

    public Boolean getSecondOk() {
        return secondOk;
    }

    public String getRegex() {
        return regex;
    }
}
