package de.dewarim.regex

class PortalController {

    def index() { }
    
    def testRegex(String firstText, String secondText, String regex, Boolean useIgnoreCaseAndUnicode){
        if(!useIgnoreCaseAndUnicode){
            useIgnoreCaseAndUnicode = false
        }
        try {
            CheckRegex check = new CheckRegex(firstText, secondText, regex, useIgnoreCaseAndUnicode)
            render(template: "testForm", model: [check: check])
        }
        catch (Exception e){
            log.debug("Failed to test regex.",e)
            render(status: 500, text:message(code: 'regex.check.fail', args: [e.message]))
        }
    }
    
    def benchmark(){
        
    }
    
    def doBenchmark(String text, String regex1, String regex2, Integer iterations, Boolean useIgnoreCaseAndUnicode){
        if(!iterations){
            iterations = 1000000
        }
        if(!useIgnoreCaseAndUnicode){
            useIgnoreCaseAndUnicode = false
        }
        try{
            BenchmarkRegex benchmark = new BenchmarkRegex(text, regex1, regex2, iterations, useIgnoreCaseAndUnicode)
            render(template: "benchmarkForm", model: [bench:benchmark])
        }
        catch (Exception e){
            log.debug("Failed to benchmark regex.",e)
            render(status: 500, text:message(code: 'regex.benchmark.fail', args: [e.message]))
        }
    }
    
    def about(){
        
    }
    
    def resources(){
        
    }
}
