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
<script language='JavaScript' src='http://www.java.com/js/deployJava.js'></script>
<Title>Sunce*HZZO - program za fakturiranje HZZO recepata</title>
<SCRIPT LANGUAGE="JavaScript"> 
var javawsInstalled = 0;  
var javaws142Installed=0;
var javaws150Installed=0;
var javaws160Installed = 0;
isIE = "false"; 
if (navigator.mimeTypes && navigator.mimeTypes.length) { 
   x = navigator.mimeTypes['application/x-java-jnlp-file']; 
   if (x) { 
      javawsInstalled = 1; 
      javaws142Installed=1;
      javaws150Installed=1;
      javaws160Installed = 1; 
  } 
} 
else { 
   isIE = "true"; 
} 
</SCRIPT> 
<SCRIPT LANGUAGE="VBScript">
on error resume next
If isIE = "true" Then
  If Not(IsObject(CreateObject("JavaWebStart.isInstalled"))) Then
     javawsInstalled = 0
  Else
     javawsInstalled = 1
  End If
  If Not(IsObject(CreateObject("JavaWebStart.isInstalled.1.4.2.0"))) Then
     javaws142Installed = 0
  Else
     javaws142Installed = 1
  End If 
  If Not(IsObject(CreateObject("JavaWebStart.isInstalled.1.5.0.0"))) Then
     javaws150Installed = 0
  Else
     javaws150Installed = 1
  End If  
  If Not(IsObject(CreateObject("JavaWebStart.isInstalled.1.6.0.0"))) Then
     javaws160Installed = 0
  Else
     javaws160Installed = 1
  End If  
End If
</SCRIPT>
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
<h1 align='center'>Sunce*HZZO - program za fakturiranje HZZO recepata</h1>
<p>
<h2>aplikacija za HZZO fakturiranje koja se jednostavno instalira i koristi</h2>
<table class='heading' border='0' witdh='100%'>
<tr>
<td width='200' valign='top'>
<jsp:include page="menu.jsp"></jsp:include>
<td>
<p>
Sunce*HZZO program je za vođenje evidencije o klijentima i izradu faktura prema HZZO-u. Aplikacija je jednostavna za instalaciju i uporabu, a ovdje možete preuzeti 
potpuno funkcionalnu demo verziju koju možete normalno koristiti kao da ste je kupili. Jedina razlika što se vaša HZZO šifra ne može prikazati na računima i u obračunima prema 
HZZO-u. 
<p>Aplikacija sama provjerava šifre putem weba kod HZZO-a, tako da je mogućnost krivog unosa broja ili istekle police dopunskog osiguranja minimalna. 
<p>Postoji verzija aplikacije za rad u optikama, kao i verzija za trgovine invalidskim pomagalima, na što trebate obratiti pažnju pri preuzimanju. 
<p>Aplikacija se može pokrenuti na bilo kojem računalu sa instaliranim windows XP,Vista,7 operacijskim sustavom, Mac OS X ili sa bilo kojom novijom distribucijom linux OS-a
koja ima grafičko sučelje. U slučaju da trebate program, a ne želite trošiti novac na dodatnu licencu za operacijski sustav, možete instalirati besplatnu distribuciju 
<a href='http://ubuntu.com/' target='_blank'>Ubuntu Linuxa</a>, 
ili <a href='http://linuxmint.com/' target='_blank'>Mint</a> distribuciju sa kojom dolaze predinstalirane aplikacije potrebne prosjećnom korisniku.
<p>Prilikom prve instalacije u aplikaciju ulazite sa korisničkim imenom  'korisnik', a lozinke nema - samo kliknete na gumb 'ulaz' ili pritisnete tipku Enter. 
Odabirom opcije: "Uredi" - "djelatnici" možete promjeniti lozinku, korisničko ime i ime i prezime korisnika, kao i dodati dodatne korisnike koji će koristiti aplikaciju. 

<p>Aplikaciju možete koristiti na neograničenom broju računala i u neograničenom broju instalacija sa jednim licenčnim ključem, bez vremenskog ograničenja, a podatke možete jednostavno prenositi 
sa računala na 
računalo kreiranjem backup datoteke, koristeći opciju "Datoteka" - "backup podataka", te na novom računalu ih povratiti sa "Datoteka" - "povrat backupiranih podataka",
te odabirom prenešene backup datoteke sa starog računala. U slučaju da HZZO izmjeni pravilnike, ovisno o kompleksnosti potrebnih zahvata, plaćate uslugu nadogradnje, obično 
100 - 200kn.
    
<p>U aplikaciji se nalazi popis svih artikala koje HZZO priznaje, sa šiframa i cijenama, tako da ne morate upisivati sami ( <a href='pomagala.do' title='popis pomagala odobrenih od HZZO-a'>primjer</a> ). Nastojali smo aplikaciju učiniti jednostavnom, 
intuitivnom i štedljivom prema Vašem vremenu kako biste svoj posao obavili što brže i kvalitetnije. Cilj nam je da ju možete koristiti bez čitanja uputa, no ipak ovdje 
možete preuzeti kratke upute za unos računa: <a target='_blank' href='upute_sunce_hzzo_unos_racuna.pdf'>PDF (390kb)</a>

<p>

<p>Cijena licence iznosi 1.200,00kn + PDV. Sve informacije o proizvodu i narudžbi možete dobiti putem e-maila: 
<script>PrikaziEmailAdresu('sunce.biz', 'prodaja', '','HZZO softver - upit');</script>
<p align='center'>
<table border='0' width='80%'>
<tr><td>
<script language="JavaScript">
/* Note that the logic below always launches the JNLP application
 *if the browser is Gecko based. This is because it is not possible
 *to detect MIME type application/x-java-jnlp-file on Gecko-based browsers. 
 */
if (javawsInstalled || (navigator.userAgent.indexOf("Gecko") !=-1)) {
    document.write("<a valign='middle' align='center' href=http://www.sunce.biz/hzzo/start.jnlp>");
	document.write("<table class='round' border='0' bgcolor='#80fdb5' align='center'><tr><td align='center'>HZZO<tr><td align='center'><img src='resources/img/sunce-hzzo.png' width='25'><tr><td align='center'>program za optike</table></a>");
} else {
document.write("Da biste se mogli koristiti ovim programom, morate imati instaliranu Javu. To možete učiniti klikom na 'pokreni' ikonu: ");
deployJava.launchButtonPNG='webstart.png';
    var url = "http://www.sunce.biz/hzzo/start.jnlp";
    deployJava.createWebStartLaunchButton(url, '1.6.0');
}
</SCRIPT>
<td>
<script language="JavaScript">
/* Note that the logic below always launches the JNLP application
 *if the browser is Gecko based. This is because it is not possible
 *to detect MIME type application/x-java-jnlp-file on Gecko-based browsers. 
 */
if (javawsInstalled || (navigator.userAgent.indexOf("Gecko") !=-1)) {
    document.write("<a valign='middle' align='center' href=http://www.sunce.biz/hzzo/start_pomagala.jnlp>");
	document.write("<table class='round' border='0' bgcolor='#80fdb5' align='center'><tr><td align='center'>HZZO<tr><td align='center'><img src='resources/img/sunce-hzzo.png' width='25'><tr><td align='center'>program za trgovine<tr><td align='center'>inv. pomagalima</table></a>");	
} else {
document.write("Da biste se mogli koristiti ovim programom, morate imati instaliranu Javu. To možete učiniti klikom na 'pokreni' ikonu: ");
deployJava.launchButtonPNG='webstart.png';
    var url = "http://www.sunce.biz/hzzo/start_pomagala.jnlp";
    deployJava.createWebStartLaunchButton(url, '1.6.0');
}
</SCRIPT>

</table>
<td width='10'>
<td valign='middle'>
Želite li probni rad s aplikacijom, možete zahtjevati besplatnu licencu na tri mjeseca. Potrebno je samo ispuniti zahtjev:
<div>
<style type='text/css'>
:invalid { 
  border-color: #e88;
  -webkit-box-shadow: 0 0 5px rgba(255, 0, 0, .8);
  -moz-box-shadow: 0 0 5px rbba(255, 0, 0, .8);
  -o-box-shadow: 0 0 5px rbba(255, 0, 0, .8);
  -ms-box-shadow: 0 0 5px rbba(255, 0, 0, .8);
  box-shadow:0 0 5px rgba(255, 0, 0, .8);
  background-image: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAeVJREFUeNqkU01oE1EQ/mazSTdRmqSxLVSJVKU9RYoHD8WfHr16kh5EFA8eSy6hXrwUPBSKZ6E9V1CU4tGf0DZWDEQrGkhprRDbCvlpavan3ezu+LLSUnADLZnHwHvzmJlvvpkhZkY7IqFNaTuAfPhhP/8Uo87SGSaDsP27hgYM/lUpy6lHdqsAtM+BPfvqKp3ufYKwcgmWCug6oKmrrG3PoaqngWjdd/922hOBs5C/jJA6x7AiUt8VYVUAVQXXShfIqCYRMZO8/N1N+B8H1sOUwivpSUSVCJ2MAjtVwBAIdv+AQkHQqbOgc+fBvorjyQENDcch16/BtkQdAlC4E6jrYHGgGU18Io3gmhzJuwub6/fQJYNi/YBpCifhbDaAPXFvCBVxXbvfbNGFeN8DkjogWAd8DljV3KRutcEAeHMN/HXZ4p9bhncJHCyhNx52R0Kv/XNuQvYBnM+CP7xddXL5KaJw0TMAF8qjnMvegeK/SLHubhpKDKIrJDlvXoMX3y9xcSMZyBQ+tpyk5hzsa2Ns7LGdfWdbL6fZvHn92d7dgROH/730YBLtiZmEdGPkFnhX4kxmjVe2xgPfCtrRd6GHRtEh9zsL8xVe+pwSzj+OtwvletZZ/wLeKD71L+ZeHHWZ/gowABkp7AwwnEjFAAAAAElFTkSuQmCC');
  background-position: right top; background-repeat: no-repeat; 
  }

 
 input:valid {  
 background-image: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAepJREFUeNrEk79PFEEUx9/uDDd7v/AAQQnEQokmJCRGwc7/QeM/YGVxsZJQYI/EhCChICYmUJigNBSGzobQaI5SaYRw6imne0d2D/bYmZ3dGd+YQKEHYiyc5GUyb3Y+77vfeWNpreFfhvXfAWAAJtbKi7dff1rWK9vPHx3mThP2Iaipk5EzTg8Qmru38H7izmkFHAF4WH1R52654PR0Oamzj2dKxYt/Bbg1OPZuY3d9aU82VGem/5LtnJscLxWzfzRxaWNqWJP0XUadIbSzu5DuvUJpzq7sfYBKsP1GJeLB+PWpt8cCXm4+2+zLXx4guKiLXWA2Nc5ChOuacMEPv20FkT+dIawyenVi5VcAbcigWzXLeNiDRCdwId0LFm5IUMBIBgrp8wOEsFlfeCGm23/zoBZWn9a4C314A1nCoM1OAVccuGyCkPs/P+pIdVIOkG9pIh6YlyqCrwhRKD3GygK9PUBImIQQxRi4b2O+JcCLg8+e8NZiLVEygwCrWpYF0jQJziYU/ho2TUuCPTn8hHcQNuZy1/94sAMOzQHDeqaij7Cd8Dt8CatGhX3iWxgtFW/m29pnUjR7TSQcRCIAVW1FSr6KAVYdi+5Pj8yunviYHq7f72po3Y9dbi7CxzDO1+duzCXH9cEPAQYAhJELY/AqBtwAAAAASUVORK5CYII=');
 background-position: right top; background-repeat: no-repeat; 
 }

:required {
  border-color: #88a;
  -webkit-box-shadow: 0 0 5px rgba(0, 0, 255, .5);
  -moz-box-shadow: 0 0 5px rgba(0, 0, 255, .5);
  -o-box-shadow: 0 0 5px rgba(0, 0, 255, .5);
  -ms-box-shadow: 0 0 5px rgba(0, 0, 255, .5);
  box-shadow: 0 0 5px rgba(0, 0, 255, .5);
}

form {
  width:305px;
  margin: 20px auto;
}

input {
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  border:1px solid #ccc;
  font-size:20px;
  width:300px;
  min-height:30px;
  display:block;
  margin-bottom:15px;
  margin-top:5px;
  outline: none;

  -webkit-border-radius:5px;
  -moz-border-radius:5px;
  -o-border-radius:5px;
  -ms-border-radius:5px;
  border-radius:5px;
}

input[type=submit] {
  background:none;
  padding:10px;
}
</style>
<form action="registracija.do" method="POST">
	
  <table>
  <tr><td>
  <label>Naziv tvrtke:</label>
  <input type="text" id="naziv" name="naziv" placeholder="naziv vaše tvrtke/obrta" required focus>

  <tr><td>
  <label>adresa:</label>
  <input type="text" id="adresa" name="adresa" placeholder="ulica i broj" required>  
  
  <tr><td>
  <label>mjesto:</label>
  <input type="text" id="mjesto" name="mjesto" placeholder="mjesto" required>  
  
  <tr><td>
  <label>OIB:</label>
  <input type="number" id="oib" name="oib" placeholder="OIB" required >  

  <tr><td>
  <label>Šifra HZZO isporučitelja:</label>
  <input type="number" id="hzzo" name="hzzo" placeholder="HZZO šifra" required>  

  <tr><td>  
  <label>Email addresa:</label>
  <input type="email" id="email" name="email">

  <tr><td>  
  <label>Telefon:</label>
  <input type="tel" id="telefon" name="telefon" placeholder="tel. broj">

  <tr><td>
  <input type="submit" value="Pošalji zahtjev" /> 
  </table>
</form>

<script type='text/javascript'>

String.prototype.trim=function(){return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');};

function checkOIB(oib) {
oib = oib.toString();
if (oib.length != 11) return false;
var b = parseInt(oib, 10);
if (isNaN(b)) return false;
var a = 10;
for (var i = 0; i < 10; i++) {
a = a + parseInt(oib.substr(i, 1), 10);
a = a % 10;
if (a == 0) a = 10;
a *= 2;
a = a % 11;
}
var kontrolni = 11 - a;
if (kontrolni == 10) kontrolni = 0;
return kontrolni == parseInt(oib.substr(10, 1));
}


function checkHzzo( broj) {

        if (broj == null || broj.trim().length != 9) {
            return false;
        }
		
		var rez = false;
		var ponderi; 
		var umnosci;
		ponderi = new Array(9, 8, 7, 6, 5, 4, 3, 2);
        umnosci = new Array();

        broj = broj.trim();
        var zbroj = 0;
        var kontrolna = 0;

        for (var i = 0; i < 8; i++) {
            var br = "" + broj.charAt(i);
            var znamenka = 0;
            try {
                znamenka = parseInt(br);
            } catch ( nfe) {
                return false;
            }

            umnosci[i] = znamenka * ponderi[i];
            zbroj += umnosci[i];
        } //for i

        try {
            kontrolna = parseInt("" + broj.charAt(8));
        } catch ( nfe) {
            return false;
        }

        var ostatak = (zbroj % 11);

        if (ostatak > 1) {
            var kontr = 11 - ostatak;
            return kontr == kontrolna;
        }

        if (ostatak == 1 && kontrolna == 0) {
            return true;
        }

        if (ostatak == 0 && kontrolna == 0) {
            return true;
        }

        return false;
    }

var oib= document.getElementById("oib");
var hzzo= document.getElementById("hzzo");

oib.addEventListener("input", function() {

			if (!checkOIB(oib.value)){
                oib.setCustomValidity("OIB nije ispravan!");
            } else {
                oib.setCustomValidity("");
            } 
        });

hzzo.addEventListener("input", function() {

			if (!checkHzzo(hzzo.value)){
                hzzo.setCustomValidity("HZZO šifra isporučitelja nije ispravna!");
            } else {
                hzzo.setCustomValidity("");
            }
 
        });
		
</script>

</div>

</tr>
</table>
</BODY>
</HTML>