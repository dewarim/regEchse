package de.dewarim.regex;

import org.archive.util.InterruptibleCharSequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Independent runnable to help detect regular expressions with pathological
 * runtime. Currently it only works for a subset of problematic cases.
 * It will not detect "1000s of 'x', followed by an 'y', matching regex
 * (x+x+x+)z in appropriate time.
 */
public class MatcherThread implements Runnable {

    static Logger log = LoggerFactory.getLogger(MatcherThread.class);

    Pattern pattern;

    /**
     * CharSequence which listens to thread interruptions.
     * Sadly, this does only work for patterns which run for a
     * long time _and_ which consume another character before
     * running into pathological backtracking behaviour.
     * So, if the regex is broken enough, the ICS will not help you.
     */
    InterruptibleCharSequence text1;
    InterruptibleCharSequence text2;
    Boolean firstOk = false;
    Boolean secondOk = false;

    public MatcherThread(Pattern pattern, String text1, String text2) {
        this.pattern = pattern;
        this.text2 = new InterruptibleCharSequence(text2);
        this.text1 = new InterruptibleCharSequence(text1);
    }

    @Override
    public void run() {
        Matcher matcher = pattern.matcher(text1);
        firstOk = matcher.find();
        log.debug("firstOk: "+firstOk);
        if (text2 != null && text2.length() > 0) {
            Matcher secondMatcher = pattern.matcher(text2);
            secondOk = secondMatcher.find();
            log.debug("secondOk: "+secondOk);
        }
        
    }

    public Boolean getFirstOk() {
        return firstOk;
    }

    public Boolean getSecondOk() {
        return secondOk;
    }

}
