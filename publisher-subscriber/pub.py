import time
import zmq
import os

context = zmq.Context()
s = context.socket(zmq.PUB)  # create a publisher socket
s.bind('tcp://localhost:2000')  # bind socket to the address

directory = input("Enter the directory: ")
for file in os.listdir(directory):
    time.sleep(2) # wait every 2 seconds
    s.send_string("Folder " + directory + " has " + file)  # publish the Folder A has B
