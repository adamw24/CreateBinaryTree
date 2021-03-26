import pygame, sys
from pygame.locals import *
from tkinter import * 
from math import *
from time import sleep
from pygame.event import wait
from numpy.core.defchararray import lower

#Awaits user input for the height of the tree and the angle of separation.
try:
    print("\n")
    h = int(input("height of tree: "))
    split_angle = int(input("angle between branches (degrees): "))*pi/360
    draw = input("Do you want to see it be drawn? (y/n): ")
    drawbool = (lower(draw) == "y")
except ValueError:
    print("Oops! One of your inputs was an invalid number. Please restart the program and try again.")
    pygame.quit()
    sys.exit()


BLACK = (0,0,0)
WHITE = (255,255,255)

length = 75
length_scalar = length/(h+1)

root = Tk()
window_width = root.winfo_screenwidth()-100
window_height = root.winfo_screenheight()-100
point_thickness = 3
display_surf = pygame.display.set_mode((window_width,window_height))

#Main Function
def main():
    pygame.init()
    global display_surf
    display_surf = pygame.display.set_mode((window_width,window_height))
    pygame.display.set_caption('Binary Tree Drawer')
    display_surf.fill(BLACK)

#Draws the trunk of the tree if height >=1.
def drawTreeTrunk(h):
    if (h >= 1):
        x1 = window_width/2
        y1 = 6*window_height/7
        p1 = (x1,y1)
        p2 = (x1,y1-length);
        pygame.draw.line(display_surf,WHITE,p1,p2,4)
        drawTreeLeaves(h-1,length-length_scalar,0,x1,y1-length);

#Draws each branch of the tree recursively.
def drawTreeLeaves(h, length, start_angle,x1,y1):
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
    if (h >= 1):
        p1 = (x1,y1)
        p2 = (x1 + length*sin(start_angle + split_angle), y1 - length*cos(start_angle + split_angle));
        p3 = (x1 + length*sin(start_angle - split_angle), y1 - length*cos(start_angle - split_angle));
        pygame.draw.line(display_surf,WHITE,p1,p2,4)
        pygame.draw.line(display_surf,WHITE,p1,p3,4)
        if(drawbool):
            pygame.display.flip()
            wait(5)
        drawTreeLeaves(h-1,length-length_scalar, start_angle + split_angle, x1 + length*sin(start_angle + split_angle), y1 - length*cos(start_angle + split_angle))
        drawTreeLeaves(h-1,length-length_scalar, start_angle - split_angle, x1 + length*sin(start_angle - split_angle), y1 - length*cos(start_angle - split_angle))


#Main Loop
while True: 
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
    display_surf.fill((0,0,0))
    drawTreeTrunk(h);
    pygame.display.flip()
    wait(1000)

if __name__=='__main__':
    main()
