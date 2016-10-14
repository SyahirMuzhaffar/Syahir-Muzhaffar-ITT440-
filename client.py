#Python 2.7.12 (v2.7.12:d33e0cf91556, Jun 27 2016, 15:19:22) [MSC v.1500 32 bit (Intel)] on win32
#Type "copyright", "credits" or "license()" for more information.
#!/usr/bin/python           # This is client.py file

import socket               # Import socket module

s = socket.socket()         # Create a socket object
host = "192.168.60.129"     #socket.gethostname() # Get local machine name
port = 12345                # Reserve a port for your service.

s.connect((host, port))

print s.recv(1024)

s.close                     # Close the socket when done

