# Testausdokumentti

Ohjelmaa on testattu automatisoiduin yksikkö- ja integraatiotestein JUnitilla. Manuaalisesti on testattu vääriäsyötteitä ja
että tiedostojen kirjoitus tapahtuu oikein.

## Yksikkö- ja integraatiotestaus

### sovelluslogiikka

Automatisoidut testit testaavat kaikkia luokkia pois lukien käyttöliittymän rakentavat luokat. 

### CSV-tiedoston luku kirjoitus

Tiedostojen lukua ja kirjoitusta testataan luomalla vakiodatan sisältävä *test.csv* -tiedosto, johon kirjoitetaan sekä luetaan.
Testi ylikirjoittaa olemassa olevan *test.csv* -tiedoston jos se on olemassa.

### Testauskattavuus

Testien rivi- ja haaraumakattavuus on seuraava:

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/testikattavuus.png" width="800">

Tapauksia, jossa metodi heittää poikkeuksen ei ole testattu. Käyttöliittymäkerros on jätetty pois testeistä.

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu sekä OSX- ympäristössä. 

Sovellusta on testattu myös datalla, jota ei ole kirjoitettu sovelluksessa van esim. Excelissä tai Tekstieditorissa.

### Toiminnallisuudet

Kaikkia toiminallisuuksia on testattu. Myös virheellisiä syötteitä on testattu ja osasta ohjelma antaa järkevän virheilmoituksen 
käyttölittymässä. Tosin esim. kirjainten syöttäminen numerokenttään ei vain toimi; tästä ei tule virheilmoitusta.

## Sovellukseen jääneet laatuongelmat

Jotkut metodit ovat turhan pitkiä; ne olisi tullut jakaa lyhyempiin metodeihin. Tällä hetkellä sovellus käsittelee vain kokonaislukuja.
Ohjelma käsittelee vain oikeassa muodossa olevaa dataa. 