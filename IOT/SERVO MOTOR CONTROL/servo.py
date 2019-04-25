import RPi.GPIO as GPIO
import time

servoPIN = 21
GPIO.setmode(GPIO.BCM)
GPIO.setup(servoPIN, GPIO.OUT)

p = GPIO.PWM(servoPIN, 50) # GPIO 17 for PWM with 50Hz
p.start(2.5) # Initialization
def SetAngle(angle):
        duty = angle / 18 + 2
        GPIO.output(servoPIN, True)
        p.ChangeDutyCycle(duty)
        time.sleep(1)
        GPIO.output(servoPIN, False)
        p.ChangeDutyCycle(0)
while True :
        x = int(input('Enter an Angle To which Servo Should Move \n'))
        SetAngle(x)

