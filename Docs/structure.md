Luokkakaavion rakennekuvaus:

Pelin luokkarakenne on seuraavanlainen:
Screen on abstrakti yliluokka josta periytyvät eri pelin ruudut.
Niitä on tällä hetkellä kaksi, GameScreen joka näyttää itse pelin sekä
GameOverScreen joka näyttää voitto- tai tappioruudun tuloksen mukaan.
Tätä luokkaa edelleen periyttämällä peliin voisi lisätä esim. aloitusmenun
ja lisää tauluja, tosin taulut voisi myös lisätä GameScreenin logiikkaan
tai periyttää siitä.

Entity on niin ikään abstrakti luokka josta periytyvät kaikki pelin liikkuvat oliot.
Sen konstruktori ottaa atribuuttinaan tekstuurin joka saadaan TextureManager-luokan
vakioista. Siitä periytyvät luokat Player, Enemy ja Missile lisäävät sen perustoimintojen
(paikka, liikesuunta- ja nopeusvektori sekä tekstuuri) omat toiminnallisuutensa.

SpaceInvaders on eräänlainen pääohjausluokka, joka sisältää renderöintiin ja pelin 
pysäyttämiseen sisältyvät toiminnot.

EntityManager on luokka joka sisältää viitteet kaikkiin pelin hahmoihin ja se huolehtii
niiden päivittämisestä, törmäyksenhavaitsemisesta ja pelin loppumisehtojen tarkkailusta.

