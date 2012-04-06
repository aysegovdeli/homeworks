#!/usr/bin/python
# -*- coding: utf-8 -

import socket
import sys

istemciSoket=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
istemciSoket.connect(("192.168.2.6",8080))
istemciSoket.send("hello ayse")
veri=istemciSoket.recv(1024)
print veri
istemciSoket.close()
