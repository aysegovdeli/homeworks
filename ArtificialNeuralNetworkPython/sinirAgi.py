#!/usr/bin/python
# -*- coding: utf-8 -*-


import random
import math

giris=int(raw_input("Girdi Bilgisini giriniz:"))
arakatman=int(raw_input("Ara Katman Sayisini Giriniz:"))
b=1
w=random.random()
girdiDizisi=[giris]
ciktiDizisi=[arakatman]
agirlik=[[giris],[arakatman]]


def netHesapla(dizi,matris,j):
    net=0.0
    i=0
    while i<giris:

        net=net+dizi[i]*matris[i][j]
        i=i+1
    print "Net: ",net
    return net+b


def fNetHesapla(net):
    sonuc=1.0/(1 + math.pow((math.e),(-net)))
    return sonuc


i=0
while i<giris:
    girdi=int(raw_input("Girdi: "))
    girdiDizisi.append(girdi)
    i=i+1


print "Agirlik Tablosu:"

i=0
while i<giris:
    j=0
    while j<arakatman:

        agirlik[i][j]=random.random()
        print "   ",agirlik[i][j]
        j=j+1
    i=i+1
    print "/n "

i=0
while i<arakatman:
    ciktiDizisi[i]=fNetHesapla(netHesapla(girdiDizisi,agirlik,i))
    print "Fnet ",ciktiDizisi[i]
    i=i+1

if(len(ciktiDizisi)==1):
    sonuc=1-ciktiDizisi[0]
else:
    toplam=0.0
    i=0
    while i<len(ciktiDizisi):
        toplam=toplam+ciktiDizisi[i]*ciktiDizisi[i]
        i=i+1
    sonuc=math.sqrt(toplam)

print "Sonuc=",sonuc

