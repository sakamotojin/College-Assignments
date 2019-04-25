import RPi.GPIO as GPIO

LED1 = 4
LED2 = 17
IRSEN = 27

GPIO.setmode(GPIO.BCM)
GPIO.setup(IRSEN,GPIO.IN)
GPIO.setup(LED1,GPIO.OUT)
GPIO.setup(LED2,GPIO.OUT)

while(True):
    sensor=GPIO.input(IRSEN)
    if sensor==1:
        GPIO.output(LED1,True)   #Switch led 1 on
        GPIO.output(LED2,False) #Switch led 2 off
        
    
    if sensor==0:
        
        GPIO.output(LED2,True)
        GPIO.output(LED1,False)

GPIO.output(LED2,False)
GPIO.output(LED1,False)
