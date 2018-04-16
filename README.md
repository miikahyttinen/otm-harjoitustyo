# Yhdenkertainen kirjanpito-ohjelma

Harjoitustyö kurssille Ohjelmistotekniikan menetelmät. Sovelluksella voi toteuttaa kirjanpitolain määrittelemän yksinkertaisen kirjanpidon

## Dokumentaatio


* [Vaatimusmäärittely](https://github.com/miikahyttinen/otm-harjoitustyo/blob/master/harjoitustyo/vaatimusmaarittely.md)

* [Arkkitehtuurikuvaus] TODO

* [Työaikakirjanpito](https://github.com/miikahyttinen/otm-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

## Komentoriviltä suoritettavat toiminnot

### Sovelluksen käynnistäminen

Sovelluksen voi käynnistää komentorivillä komennolla


```
mvn compile exec:java -Dexec.mainClass=fi.ykkirjanpitosovellus.logic.MainClass
```

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_


### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/miikahyttinen/otm-harjoitustyo/blob/master/ykkirjanpitosovellus/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

