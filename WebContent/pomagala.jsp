<%@ page 
language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"
%>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Keywords" content="hzzo,program,fakturiranje" />

<meta name="Description" content="program za fakturiranje prema HZZO-u" />
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<Title>Sunce*HZZO - popis artikala u HZZO registru</title>
 
 
<SCRIPT LANGUAGE="javascript">
	 function PrikaziEmailAdresu(Server, Login, Prikaz, Subjekt)
	{	
	if (Subjekt && Subjekt.length>0)
     Subjekt="?Subject="+Subjekt;
	else Subjekt="";
	var m="'mai";
	
	if ((Prikaz.length == 0) || (Prikaz.indexOf('@')+1)) {
	document.write("<A class='crni' HREF=" + m + "lto:" + Login + "@" + Server + ""+Subjekt+"'>" + Login + "@" + Server + "</A>"); }
	else  {
	document.write("<A HREF=" + m + "lto:" + Login + "@" + Server + ""+Subjekt+"' class='crni'>" + Prikaz + "</A>"); }
	}	 
	 </SCRIPT>
	 <style type="text/css">
	 table.round{
	-moz-border-radius: 8px;
	border-radius: 8px;
	} 
	 </style>
</head>
<BODY >
<table class='heading' border='0' hspace='0' vspace='0' width='100%'>
<tr valign='bottom'><td><img src='resources/img/sunce-logo.jpg' height='120'>
<td valign='bottom' align='right'>
<table class='round' style='background-color:lightgray;padding:5px;'><tr><td>Sunce mikrosustavi d.o.o.</tr> 
<tr><td>Vis, Obala sv. Jurja 9</tr>
<tr><td>OIB: 15400396683</tr>
<tr><td>tel: 091 451 3632</tr>
<tr><td>e-mail: <script>PrikaziEmailAdresu('sunce.biz', 'prodaja', '','HZZO softver - upit');</script></tr>
</table>
</tr>
</table>
<h1 align='center'>Sunce*HZZO - popis HZZO artikala</h1>
<p>
<h2>lista svih artikala koje podrzava HZZO</h2>
<table class='heading' border='0' witdh='100%'>
<tr>
<td width='10'>
<td>
<p>
<script type="text/javascript" src='resources/jquery.js'></script>
<script type="text/javascript" src='resources/underscore.js'></script>
<script type="text/javascript" src='resources/backbone.js'></script>
<script type="text/javascript" src='resources/pomagala.js'></script>
 

</p>
</td>
</tr>
</table>
</BODY>
</HTML>
 