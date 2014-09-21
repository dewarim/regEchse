<g:form name="testRegex" onsubmit="return false;">

    <fieldset>
        <legend><g:message code="regex.form.legend"/></legend>

        <table>
            <tbody>
            <tr>
                <td><g:message code="regex.text.1"/>
                    <br>
                    <g:if test="${check?.text1}">
                        <g:if test="${check.firstOk}">
                            <asset:image src="ok.png" alt="ok"/>
                        </g:if>
                        <g:else>
                            <asset:image src="no.png" alt="not ok"/>
                        </g:else>
                    </g:if>

                </td>
                <td>
                    <g:textArea style="width: 80ex;" id="firstText" name="firstText" value="${check?.text1}" cols="80" rows="5"/>
                </td>
            </tr>
            <tr>
                <td><g:message code="regex.text.2"/>
                    <br>
                    <g:if test="${check?.text2}">
                        <g:if test="${check.secondOk}">
                            <asset:image src="ok.png" alt="ok"/>
                        </g:if>
                        <g:else>
                            <asset:image src="no.png" alt="not ok"/>
                        </g:else>
                    </g:if>
                </td>
                <td>
                    <g:textArea style="width: 80ex;" name="secondText" cols="80"
                                rows="5" value="${check?.text2}"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <g:message code="benchmark.useIgnoreCaseAndUnicode"/>
                    <g:checkBox name="useIgnoreCaseAndUnicode" checked="${check?.useIgnoreCaseAndUnicode}"/>
                </td>
            </tr>

            <tr>
                <td><g:message code="regex.expression"/></td>
                <td>
                    <g:textField name="regex" size="80" value="${check?.regex}"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><g:submitToRemote url="[action: 'testRegex']"
                                      update="[success: 'regex-form', failure: 'regex-fail']"
                                      onFailure="\$('#regex-fail').show();"
                                      onSuccess="\$('#regex-fail').hide();resizeTextAreas();"
                                      value="${message(code: 'regex.test')}"/>

                    <div id="regex-fail" style="color: red;background-color: #ffffff;width:80%;">
                        &nbsp;
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>

</g:form>
<g:render template="examples"/>
