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
<form >
	
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