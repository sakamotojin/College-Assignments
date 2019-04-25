import RPi.GPIO as GPIO
import time
import socket

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(7,GPIO.OUT,initial=GPIO.LOW)
GPIO.setup(11,GPIO.OUT,initial=GPIO.LOW)

def liteon(but):
    if(but=='1'):
        GPIO.output(7 ,GPIO.HIGH)
    if(but=='3'):
        GPIO.output(11 ,GPIO.HIGH)
    time.sleep(1)
    return
def liteoff(but):
    if(but=='2'):
        GPIO.output(7 ,GPIO.LOW)
    if(but=='4'):
        GPIO.output(11 ,GPIO.LOW)
    time.sleep(1)
    return

TCP_IP = '192.168.43.252'
TCP_PORT = 5686
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind((TCP_IP , TCP_PORT))
s.listen(True)
conn, addr = s.accept()
while True :
    dat = conn.recv(1)
    data = dat.decode()
    print data
    if data=='1' or  data=='3':
        liteon(data)
    else:
        liteoff(data)
    

