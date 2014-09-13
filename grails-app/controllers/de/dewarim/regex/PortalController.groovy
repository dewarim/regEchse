package de.dewarim.regex

class PortalController {

    def index() { }
    
    def testRegex(String firstText, String secondText, String regex){
        CheckRegex check = new CheckRegex(firstText, secondText, regex)
        render(template: "testForm", model: [check:check])
    }
}
