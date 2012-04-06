#!/usr/bin/python
# -*- coding: utf-8 -*-

from scapy.all import *


def paketAl():

    while 1:

        paketler=sniff(filter="host 192.168.206.12", count=1)
        paket=paketler[0]
        paket[IP].dst="192.168.107.84"
        send(paket[IP])

if __name__ == "__main__":
    paketAl()
