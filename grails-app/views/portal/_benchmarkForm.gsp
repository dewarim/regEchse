<g:form name="testRegex" onsubmit="return false;">

    <fieldset>
        <legend><g:message code="regex.benchmark.legend"/></legend>


        <table>
            <tbody>
            <tr>
                <td>
                    <g:message code="regex.text"/>
                </td>
                <td>
                    <g:textArea style="width: 80ex;" name="text" value="${bench?.text}" cols="80" rows="5"/>
                </td>
                <td>

                </td>
            </tr>

            <tr>
                <td><g:message code="regex.test.1"/>
                <br>
                <g:if test="${bench?.finished}">
                    <g:if test="${bench?.found1}">
                        <asset:image src="ok.png" alt="ok"/>
                    </g:if>
                    <g:else>
                        <asset:image src="no.png" alt="not ok"/>
                    </g:else>
                </g:if>
                </td>
                <td>
                    <g:textField name="regex1" size="80" value="${bench?.regex1}"/>
                </td>
            </tr>

            <g:if test="${bench?.runtime1}">
                <tr>
                    <td></td>
                    <td>
                        <g:message code="benchmark.runtime" args="[bench.iterations, bench.runtime1]"/>
                    </td>
                </tr>
            </g:if>


            <tr>
                <td><g:message code="regex.test.2"/>
                <br>
                    <g:if test="${bench?.finished}">
                        <g:if test="${bench?.found2}">
                            <asset:image src="ok.png" alt="ok"/>
                        </g:if>
                        <g:else>
                            <asset:image src="no.png" alt="not ok"/>
                        </g:else>
                    </g:if>
                <td>
                    <g:textField name="regex2" size="80" value="${bench?.regex2}"/>
                </td>
            </tr>
            <g:if test="${bench?.runtime2}">
                <tr>
                    <td></td>
                    <td>
                        <g:message code="benchmark.runtime" args="[bench.iterations, bench.runtime2]"/>
                    </td>
                </tr>
            </g:if>
            <tr>
                <td><g:message code="benchmark.iterations"/></td>
                <td>
                    <g:textField name="iterations" value="${bench?.iterations ?: 1000000}"/>
                    <br>
                    <g:message code="benchmark.useIgnoreCaseAndUnicode"/>
                
                    <g:checkBox name="useIgnoreCaseAndUnicode" checked="${bench?.useIgnoreCaseAndUnicode}"/>
                    
                </td>
            </tr>

            <tr>
                <td></td>
                <td><g:submitToRemote url="[action: 'doBenchmark']"
                                      update="[success: 'regex-form', failure: 'regex-fail']"
                                      onFailure="\$('#regex-fail').show();"
                                      onSuccess="\$('#regex-fail').hide();"
                                      value="${message(code: 'regex.benchmark')}"/>

                    <br>

                    <div id="regex-fail">
                        &nbsp;
                    </div>
                </td>

            </tr>
            </tbody>
        </table>
    </fieldset>

</g:form>
