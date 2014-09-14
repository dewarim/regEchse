package de.dewarim.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class BenchmarkRegex {

    static Logger log = LoggerFactory.getLogger(BenchmarkRegex.class);

    String text;
    String regex1;
    String regex2;

    long runtime1;
    long runtime2;
    int iterations;
    boolean useIgnoreCaseAndUnicode;
    boolean found1;
    boolean found2;
    boolean finished;

    public BenchmarkRegex(String text, String regex1, String regex2, int iterations, boolean useIgnoreCaseAndUnicode) {
        this.text = text;
        this.regex1 = regex1;
        this.regex2 = regex2;
        this.iterations = iterations;
        this.useIgnoreCaseAndUnicode = useIgnoreCaseAndUnicode;

        Pattern pattern1;
        try {
            if (useIgnoreCaseAndUnicode) {
                pattern1 = Pattern.compile(regex1, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            }
            else {
                pattern1 = Pattern.compile(regex1);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to compile pattern for regex 1: " + e.getMessage(), e);
        }

        Pattern pattern2;
        try {
            if (useIgnoreCaseAndUnicode) {
                pattern2 = Pattern.compile(regex2, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            }
            else {
                pattern2 = Pattern.compile(regex2);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to compile pattern for regex 2: " + e.getMessage(), e);
        }

        BenchmarkResult result = benchmark(pattern1, text, iterations);
        runtime1 = result.getRuntime();
        found1 = result.isFound();
        
        result = benchmark(pattern2, text, iterations);
        runtime2 = result.getRuntime();
        found2 = result.isFound();

        finished = true;
    }

    public BenchmarkResult benchmark(Pattern pattern, String text, int iterations) {
        long startTime = System.currentTimeMillis();
        boolean found = false;
        for (int x = 0; x < iterations; x++) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                found = true;
            }
        }
        long runtime = System.currentTimeMillis() - startTime;
        log.debug("runtime: " + runtime + ", found match: " + found);
        return new BenchmarkResult(runtime, found);
    }

    private class BenchmarkResult {
        long runtime;
        boolean found;

        public BenchmarkResult(long runtime, boolean found) {
            this.runtime = runtime;
            this.found = found;
        }

        public long getRuntime() {
            return runtime;
        }

        public boolean isFound() {
            return found;
        }
    }

    public String getText() {
        return text;
    }

    public long getRuntime2() {
        return runtime2;
    }

    public long getRuntime1() {
        return runtime1;
    }

    public String getRegex1() {
        return regex1;
    }

    public String getRegex2() {
        return regex2;
    }

    public int getIterations() {
        return iterations;
    }

    public boolean isUseIgnoreCaseAndUnicode() {
        return useIgnoreCaseAndUnicode;
    }

    public boolean isFound1() {
        return found1;
    }

    public boolean isFound2() {
        return found2;
    }

    public boolean isFinished() {
        return finished;
    }
}
