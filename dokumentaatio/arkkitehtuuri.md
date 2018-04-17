# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/miikahyttinen/otm-harjoitustyo/blob/master/dokumentaatio/pakkausrakenne.png" width="500">

Pakkaus _fi.ykkirjanpitohojelma.gui_ sisältää JavaFX:llä toteutetun käyttöliittymän _fi.ykkirjanpitohojelma.logic_ sovelluslogiikan ja _fi.ykkirjanpitohojelma.data_ tietojen tallennuksesta vastaavan koodin.

Pakkaus _fi.ykkirjanpitohojelma.test_ sisältää luokkia testaavat metodit. 

## Käyttöliittymä

Käyttöliittymä sisältää seuraavat näkmyät:
1. Sovelluksen avaus: uuden tilikauden luominen tai vanhan avaaminen
2. Uuden tilikauden luominen ja tallentaminen
3. Tallennetun tilikauden muokkaaminen ja tallentaminen

jokainen näistä on toteutettu omana [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona. Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html). Käyttöliittymä on rakennettu ohjelmallisesti luokassa [todoapp.ui.TodoUi](https://github.com/mluukkai/OtmTodoApp/blob/master/src/main/java/todoapp/ui/TodoUi.java).

Käyttöliittymä on pyritty eristämään sovelluslogiikasta. 

Sovelluksessa voi pitää kirjaa tuloista ja menoista sekä laskea "tuloksen".

## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat **Entry** (kirjaus) sekä **AccountingYear** (Tilikausi).
Tilikausi koostuu erilaisista kirjauksista, joilla on rahallinen arvo sekä erinäistä tietoa liittyen kirjaukseen.
 
## Toiminallisuudet

**TODO**

## Tietojen pysyväistallennus

Pakkauksen _fi.ykkirjanpitohojelma.data_ luokka **AccountingData** huolehtii tietojen tallettamisesta tiedostoihin.


### Tiedostot

Luokkaa tallentaa tietoja CSV-formaatissa paikkaan X (TODO)

Sovellus tallettaa tilikauden seuraavassa formaatissa:

<pre>
TODO
</pre>

Kentät on eroteltu pilkuin.

### Päätoiminnallisuudet

TODO

