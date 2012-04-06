#!/usr/bin/python
# -*- coding: utf-8 -*-

import socket
import sys


sunucuSoket=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
sunucuSoket.bind(("192.168.2.6",8080))
sunucuSoket.listen(1)
istemciSoketi,adres=sunucuSoket.accept()
veri=istemciSoketi.recv(1024)
istemciSoketi.send(veri)
print veri
istemciSoketi.close()

