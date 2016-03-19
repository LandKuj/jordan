# YOU MUST SET THE PATH TO THE LOCATION OF graphics.py
# PACKAGE CAN BE FOUND AT: 
# ALSO IS INCLUDED ON GIT COMMIT
# PLACE PATH HERE 
PATH = '/home/pi/pyPKG/'


# IMPORT REQUIRED PACKAGES
import time
import numpy as np
import random as rand
import sys
# ADD PATH FOR GRAPHICS
sys.path.insert(1, PATH)
import graphics as gp

# SET CONSTANTS 
WIDTH = 1000
HEIGHT = 500
RANGE_SIZE = 100
STEP_TIME = 0
SLEEP_TIME = 2


# DEFINE SUPPORT METHODS
def isSorted(array):
        out = True
        for i in xrange(RANGE_SIZE - 1):
                if array[i] < array[i + 1]:
                        out = False
        return out




win = gp.GraphWin('Sort Sum Nums', WIDTH, HEIGHT + 50)
win.setBackground("black")

arr = np.arange(0, RANGE_SIZE)

for i in arr: 
	arr[i] = int(rand.random() * (HEIGHT -100))


count = 0
x = []
for i in arr: 
	rect = gp.Rectangle(gp.Point(count * (WIDTH / 100), HEIGHT + 50),
			    gp.Point((count * (WIDTH / 100)) + (WIDTH / 100), i))
	rect.setFill("white")
	rect.draw(win)
	x.append(rect)
	count += 1

#x[0] = x[0].setFill("yellow")
#x[99] = x[99].setFill("yellow")

time.sleep(2)

# BUBBLE SORT ALGO
while isSorted(arr) == False :
	for i in xrange(0, 99):
		x[i].setFill("red")
		if arr[i] < arr[i + 1] : 
			
			x[i+1].setFill("green")
			time.sleep(STEP_TIME)
			x[i].move((WIDTH / 100), 0)
			x[i + 1].move(-(WIDTH / 100), 0)	
			time.sleep(STEP_TIME)

			hold = arr[i]
			rectHold = x[i]

			arr[i] = arr[i + 1] 
			x[i] = x[i + 1]	
	
			arr[i + 1] = hold
 			x[i + 1] = rectHold
		 
		x[i].setFill("white")
                x[i + 1].setFill("White")

 	
if isSorted(arr) : 
	for i in xrange(100): 
		x[i].setFill("green")



time.sleep(SLEEP_TIME)



