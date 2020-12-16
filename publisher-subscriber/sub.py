import zmq

context = zmq.Context()
s = context.socket(zmq.SUB)  # create a subscriber socket
s.connect('tcp://localhost:2000')  # connect to the server
s.setsockopt_string(zmq.SUBSCRIBE, "Folder")  # subscribe to Folder messages

while True:
    directory = s.recv()  # receive the message
    file = s.recv()
    print(directory), print(file)  # print the received message
