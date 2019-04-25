import socket
import time as sleep
import RPi.GPIO as GPIO
from time import sleep

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(8,GPIO.OUT,initial=GPIO.LOW)

def closeled():
    GPIO.output(8, False)
    sleep(1)
    
def openled():
    GPIO.output(8, True)
    sleep(1)


TCP_IP = '192.168.43.51'
TCP_PORT = 9992
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((TCP_IP, TCP_PORT))
s.listen(True)
print("pi ready hai \n")

while True:
    
    conn, addr = s.accept()
    print("Connected to \t", addr)
    while True :    
        data = conn.recv(1)
        if not data : break ;
        print("User Sent \t" ,(data.decode()))
        s=data.decode()
        if(s=='0'):
            closeled()
        else :
            openled()
    
    s.close()
