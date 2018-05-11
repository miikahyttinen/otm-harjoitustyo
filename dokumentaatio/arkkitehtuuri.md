# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

Pakkaus _fi.ykkirjanpitohojelma.gui_ sisältää JavaFX:llä toteutetun käyttöliittymän _fi.ykkirjanpitohojelma.logic_ sovelluslogiikan ja _fi.ykkirjanpitohojelma.data_ tietojen tallennuksesta vastaavan koodin.

Pakkaus _fi.ykkirjanpitohojelma.test_ sisältää luokkia testaavat metodit. 

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/architecture%20pics/pakkausrakenne.png" widht="500">

## Käyttöliittymä

Käyttöliittymä sisältää seuraavat näkmyät:
1. Sovelluksen avaus: uuden tilikauden luominen tai vanhan avaaminen
2. Uuden tilikauden luominen ja näyttäminen
3. Tallennetun tilikauden kirjausten listaus
4. Uuden kirjauksen teko ja olemassa olevan poisto

jokainen näistä on toteutettu omana [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona. Useita Scenejä voi olla kerrallaan näkyvänä eli sijoitettuna sovelluksen [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html). 

Käyttöliittymä on pyritty eristämään sovelluslogiikasta. 

Sovelluksessa voi pitää kirjaa tuloista ja menoista sekä laskea "tuloksen".

## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat **Entry** (kirjaus) sekä **AccountingYear** (Tilikausi).
Tilikausi koostuu erilaisista kirjauksista, joilla on rahallinen arvo sekä erinäistä tietoa liittyen kirjaukseen.

Luokssa **AccountingValidataors** on toteutettu käyttäjän syötettä testaavia validaattoreita. 

Kättöliittymä on toteuttu **AccountingInterface** luokassa. Luokka **UserInputErrors** käsittelee käyttäjän syötteistä 
johtuvat virheet ja ilmoittaa näistä käyttöliittymässä. 

## Toiminallisuudet

### Sekvenssikaavio tilikauden avaamisesta CSV-tiedostosta

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/architecture%20pics/show%20accounting%20year.png" width="700">

### Sekvenssikaavio uuden tilikauden luomisesta (luo uuden CSV-tiedoston)

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/architecture%20pics/create%20new%20year.png" width="700">

### Sekvenssikaavio uuden kirjauksen luomisesta olemassa olevalle tilikaudelle (kirjoittaa CSV-tiedostoon)

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/architecture%20pics/add%20new%20entry.png" width="700">

### Sekvenssikaavio kirjauksen poistamisesta olemassa olevalta tilikaudelta (kirjoittaa CSV-tiedostoon)

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/architecture%20pics/delete%20entry.png" width="700">


### Tietojen pysyväistallennus

Pakkauksen _fi.ykkirjanpitohojelma.data_ luokka **AccountingData** huolehtii tietojen tallettamisesta tiedostoihin.

Luokassa AccountingAlgorithms on toteutettu tietojen CSV-tiedostosta lukemiseen ja tallentamiseen liittyviä metodeja. 


### Tiedostot

Luokkaa tallentaa tietoja CSV-formaatissa paikkaan sovelluksen käynnistyshakemistoon.

Sovellus tallettaa tilikauden seuraavassa formaatissa:

<pre>
esimerkkitiedosto.csv
</pre>

Data on eroteltu puolipisten järjetyksessä ID;Nimi;Summa;Pvm;Tyyppi

<pre>
1;Esimerkki;300;1.5.2018;Myyntitulo
</pre>



