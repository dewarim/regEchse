package de.dewarim.regex

class PortalController {

    def index() { }
    
    def testRegex(String firstText, String secondText, String regex){
        try {
            CheckRegex check = new CheckRegex(firstText, secondText, regex)
            render(template: "testForm", model: [check: check])
        }
        catch (Exception e){
            log.debug("Failed to test regex.",e)
            render(status: 500, text:message(code: 'regex.check.fail', args: [e.message]))
        }
    }
    
    def benchmark(){
        
    }
}
