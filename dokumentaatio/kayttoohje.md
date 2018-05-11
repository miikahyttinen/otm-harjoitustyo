# Käyttöohje (luonnos)

Lataa tiedosto sekä mallidata jos haluat [ykkirjanpitosovellus-1.0-SNAPSHOT.jar](https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/releases/tag/viikko6)

## Konfigurointi

Ohjelma ei vaadi konfigurointeja. Ohjelma luo uudet tiedostot hakemistoon, josta se suoritettiin. 

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla tai suorittamalla JAR-tiedosto.

```
java -jar ykkirjanpitosovellus-1.0-SNAPSHOT.JAR
```

## Alkunäkymä

Sovelluksen alkunäkymässä voit avata tilikauden tai luoda uuden tilikauden. Uusi tilikausi luo CSV-tiedoston käynnistyshakemistoon.

(https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/gui%20pics/start%20view.png "Alkynäkymä")

## Uuden tilikauden luominen

Klikkaamalla "uusi tilikausi" voi luoda uuden tilikauden. Anna haluamasi nimi sekä päivämäärät muodossa DD.MM.YYYY.

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/gui%20pics/create%20a%20new%20accounting%20year.png" width="500">

## Olemassa olevan tilikauden avaaminen

Klikkaamalla "avaa tilikausi" avautuu tiedoston valintaikkuna, josta voit avata haluamasi tiedoston.

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/gui%20pics/file%20chooser.png width="500">

## Tilikauden listausnäkymä

Näkymä listaa kaikki tiliakauden kirjaukset ja laskee tilikauden tuloksen. Voit myöt lisätä ja poistaa kirjauksen tästä näkymäst. 

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/gui%20pics/show%20accounting%20year.png" width="500">

## Uuden kirjauksen tekeminen

Kun tilikausi on avattu tai uusi luotu, voi tehdä kirjauksia klikkaamalla uusi kirjaus. Ohjelma kirjoitta uuden 
kirjauksen suoraan tiedostoon.

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/gui%20pics/new%20entry.png" width="500">

## Kirjauksen poisto

Tilikauden listausnäkymästä voit poistaa kirjauksen. Anna kirjauksen numero (ID), jonka haluat poistaa.
ID:t näet listausnäkymäst. 

<img src="https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/gui%20pics/remove%20entry.png" width="500">






