package de.dewarim.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class CheckRegex {

    static Logger log = LoggerFactory.getLogger(CheckRegex.class);

    String text1;
    String text2;

    Boolean firstOk;
    Boolean secondOk;
    boolean useIgnoreCaseAndUnicode;

    String regex;

    public CheckRegex(String text1, String text2, String regex, boolean useIgnoreCaseAndUnicode) {
        this.text1 = text1;
        this.text2 = text2;
        this.regex = regex;
        this.useIgnoreCaseAndUnicode = useIgnoreCaseAndUnicode;

        Pattern pattern;
        if (useIgnoreCaseAndUnicode) {
            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
        else {
            pattern = Pattern.compile(regex);
        }
        Matcher matcher = pattern.matcher(text1);
        firstOk = matcher.find();
        if (text2 != null) {
            Matcher secondMatcher = pattern.matcher(text2);
            secondOk = secondMatcher.find();
        }
        log.debug("CheckRegex result: " + this);
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

    public boolean isUseIgnoreCaseAndUnicode() {
        return useIgnoreCaseAndUnicode;
    }

    @Override
    public String toString() {
        return "CheckRegex{" +
                "text1='" + text1 + '\'' +
                ", text2='" + text2 + '\'' +
                ", firstOk=" + firstOk +
                ", secondOk=" + secondOk +
                ", useIgnoreCaseAndUnicode=" + useIgnoreCaseAndUnicode +
                ", regex='" + regex + '\'' +
                '}';
    }
}
