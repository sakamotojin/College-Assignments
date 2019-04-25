#blink led using rpi3

import time
import RPi.GPIO as GPIO

PIN=17
GPIO.setmode(GPIO.BCM) #BCM MODE FOLLOW GPIO PIN CONFIGURATION
GPIO.setup(PIN,GPIO.OUT)
while(True):
    GPIO.output(PIN,True)
    time.sleep(2)
    GPIO.output(PIN,False)
    time.sleep(PIN)
    
