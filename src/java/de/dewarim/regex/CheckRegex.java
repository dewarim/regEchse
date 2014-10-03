package de.dewarim.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class CheckRegex {

    static Logger log = LoggerFactory.getLogger(CheckRegex.class);

    final String text1;
    final String text2;

    Boolean firstOk;
    Boolean secondOk;
    boolean threadFinished = false;
    boolean useIgnoreCaseAndUnicode;

    String regex;

    public CheckRegex(String _text1, String _text2, String regex, boolean useIgnoreCaseAndUnicode) {
        this.text1 = _text1;
        this.text2 = _text2;
        this.regex = regex;
        this.useIgnoreCaseAndUnicode = useIgnoreCaseAndUnicode;

        Pattern pattern;
        if (useIgnoreCaseAndUnicode) {
            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
        else {
            pattern = Pattern.compile(regex);
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MatcherThread matcherThread = new MatcherThread(pattern, text1, text2); 
        Future future = executorService.submit(matcherThread);
        try {
            boolean hadToTerminateThread = executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
            log.debug("hadToTerminateThread: "+hadToTerminateThread);
            log.debug("future is done: "+future.isDone());
            if(future.isDone() && ! hadToTerminateThread) {
                threadFinished = true;
            }
        }
        catch (InterruptedException e){
            threadFinished = false;
        }
        if(!threadFinished){
            log.debug("thread was terminated.");
            throw new RuntimeException("thread.terminated");
        }
        firstOk = matcherThread.getFirstOk();
        secondOk = matcherThread.getSecondOk();
        
        log.debug("CheckRegex result: " + firstOk);
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
