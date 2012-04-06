#!/usr/bin/python
# -*- coding: utf-8 -*-

alfabe="ABCDEFGHIJKLMNOPRSTUVYZ"
talfabe=" ZYVUTSRPONMLKJIHGFEDCBA"

def dosyayayaz(karakter):
    dosya=open("sifrelimetin.txt","w")
    dosya.write(karakter)
    dosya.close()

def dosya_yaz(karakter):
    dosya=open("duzmetin.txt","w")
    dosya.write(karakter)
    dosya.close()

secim=raw_input("şifreleme[s],deşifreleme[d]")
if(secim=='s'):
    anahtar=raw_input("Anahtar değerini girin:")
    gelenmetin=open("duzmetin.txt","r")
    metin=gelenmetin.read()
    j=0
    i=0
    sifreli=""
    while j<(len(metin)):
        if(i==(len(anahtar))):
             i=0
        kr=anahtar[i]
        KR=kr.upper()
        konum1=alfabe.find(KR)
        kr1=metin[j]
        if(kr1==' '):
            kr1='X'
            sifreli=sifreli+kr1
            j=j+1
            kr1=metin[j]
        i=i+1
        j=j+1
        KR1=kr1.upper()
        konum2=alfabe.find(KR1)
        konum=konum2-konum1
        sifreli=sifreli+ alfabe[konum]
        print sifreli

    dosyayayaz(sifreli)

elif(secim=='d'):
    anahtar=raw_input("Anahtar değerini girin:")
    sifrelimetin=open("sifrelimetin.txt","r")
    smetin=sifrelimetin.read()
    k=0
    l=0
    duzmetin=""
    while  k<(len(smetin)):
        if(l==(len(anahtar))):
           l=0
        skr=anahtar[l]
        SKR=skr.upper()
        skonum1=alfabe.find(SKR)
        skr1=smetin[k]
        if(skr1=='X'):
            skr1=' '
            duzmetin=duzmetin+skr1
            k=k+1
            skr1=smetin[k]
        l=l+1
        k=k+1
        SKR1=skr1.upper()
        skonum2=talfabe.find(SKR1)
        print skonum2
        print skonum1
        skonum=skonum1-skonum2
        duzmetin=duzmetin+alfabe[skonum]
        print duzmetin

    dosya_yaz(duzmetin)





