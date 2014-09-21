<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <asset:javascript src="jquery.autosize.js"/>
    <asset:script type="text/javascript">

        function resizeTextAreas(){
            $('textarea').autosize(); 
        }
        
        $(document).ready(function(){
            resizeTextAreas();    
        });
        
        function addTextToTextArea(sourceId, targetId){
        var target = $('#'+targetId);
         target.val($('#'+sourceId).text());
         target.trigger('autosize.resize');
        }
    </asset:script>
    <g:layoutHead/>
</head>

<body>

<div class="row">

    <div class="col-md-3" id="left-column">
        <!--
        <h3><g:message code="regex.special.characters"/></h3>
        <ul>
            <li>
                
            </li>
        </ul>
        -->
    </div>

    <div class="col-md-6">
        <div style="text-align: center;">
            <h1 style="padding-top: 2ex;"><g:message code="reg.echse.title"/></h1>
        </div>

        <p style="text-align: center;padding-bottom: 2ex;">
            <g:link controller="portal" action="index">
                <g:message code="link.to.test.page"/>
            </g:link>
            &nbsp;|&nbsp;
            <g:link controller="portal" action="benchmark">
                <g:message code="link.to.benchmark.page"/>
            </g:link>
            &nbsp;|&nbsp;
            <g:link controller="portal" action="resources">
                <g:message code="link.to.resources"/>
            </g:link>
            &nbsp;|&nbsp;
            <g:link controller="portal" action="about">
                <g:message code="link.to.about"/>
            </g:link>
        </p>
        <g:layoutBody/>
    </div>

    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt"
                                                                       default="Loading&hellip;"/></div>

    <div class="col-md-3" id="right-column">

    </div>
</div>

<asset:deferredScripts/>

</body>
</html>
