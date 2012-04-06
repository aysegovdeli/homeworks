#ifndef RSA.PY
#define RSA.PY
#!/usr/bin/python
# -*- coding: utf-8 -*-

import random
import math
from math import sqrt


def tamkaremi(deger):
    if(deger/2<2):
        return 0
    for i in range(2,deger/2):
        sorgu=i**2
        if(sorgu==deger):
            return 1
        else:
            return 0


def legendresymbol(tdeger,sayi):
    if(tdeger==0):
        return 0
    elif(tdeger!=0 and sayi==1):
        return 1
    else:
        return -1

def asalmi(n):
    i=0
    for j in (1,50):
        while i!=10:
             print"n=",n
             a=random.randint(2,n-1)
             print "a=",a
             sonuc1=(a**((n-1)/2))%n
             if(n-sonuc1==1):
                 sonuc1=-1
             print "s1",sonuc1
             testdegeri=a%n
             print "testdgeri",testdegeri
             print"2"
             tamkare=tamkaremi(testdegeri)
             print"t or f",tamkare
             sonuc2=legendresymbol(testdegeri,tamkare)
             print"s2=",sonuc2
             if(sonuc1==sonuc2):
                 i=i+1
             elif(sonuc2==0 or sonuc1!=sonuc2):
                 return 0
    return 1




sayi=0
p1=0
q1=0
while p1!=1:
    sayi=random.randint((10**307),(10**308)-1)
    if(sayi%2!=0):
        p1=asalmi(sayi)

p=sayi

while q1!=1:
    sayi=random.randint((10**307)+2,(10**308)-1)
    if(sayi%2!=0):
        q1=asalmi(sayi)

q=sayi

N=p*q
Q=(p-1)*(q-1)
print "p=",p
print "q=",q
print "N=",N
print "Q=",Q


#endif // RSA.PY
