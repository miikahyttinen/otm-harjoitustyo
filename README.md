# Yhdenkertainen kirjanpito-ohjelma (työpöytäsovellus)

Harjoitustyö kurssille Ohjelmistotekniikan menetelmät. Ohjelmalla voi pitää kirjaa menoista ja tuloista. 

## Dokumentaatio


* [Vaatimusmäärittely](https://github.com/miikahyttinen/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

* [Arkkitehtuurikuvaus](https://github.com/miikahyttinen/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

* [Käyttöohje](https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/kayttoohje.md)

* [Testausdokumentti](https://github.com/miikahyttinen/Otm-harjoitustyo-Yksinkertainen-kirjanpitosovellus/blob/master/dokumentaatio/testausdokumentti.md)

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

### JavaDoc

Javadoc generoidaan komennolla

```
 mvn javadoc:javadoc
```

