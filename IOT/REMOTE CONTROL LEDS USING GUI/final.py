import RPi.GPIO as GPIO
import time
import picamera
import socket
from PIL import Image
import io

#TCP_IP = '192.168.43.149'
#TCP_PORT = 9995
open = 120
close = 170

servoPIN1 = 21

pir = 18

stream = io.BytesIO()

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.setup(servoPIN1, GPIO.OUT)
GPIO.setup(pir, GPIO.IN)

camera = picamera.PiCamera()
camera.resolution=(500,500)

p1 = GPIO.PWM(servoPIN1, 50) 
p1.start(11.5)


#sock = socket.socket()
#sock.connect((TCP_IP, TCP_PORT))


def SetAngle(angle):
	duty = angle / 18 + 2
	GPIO.output(servoPIN1, True)
	p1.ChangeDutyCycle(duty)
	time.sleep(1)
	GPIO.output(servoPIN1, False)
	p1.ChangeDutyCycle(11.5)
	
        
def capture_image():
	
	#camera.start_preview()
	#time.sleep(2)
	camera.capture('a.jpg')
	#stream.seek(0)
	image = Image.open('a.jpg')
	buff=image.tobytes()
	#image.show()
	#time.sleep(10)
	#print(buff)
	#sock.send( buff );
	#camera.stop_preview()
	print(2)
	#camera.close()
    
while True:
	if GPIO.input(pir)==1:
                    SetAngle(open)
                    print(1)
                    capture_image()
                    #time.sleep(5)
                    SetAngle(close)
        else :
            SetAngle(close)
            
	
camera.close()
    
