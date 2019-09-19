
from Square import Square
from Board import Board
from Backtracking_Forward_Checking import Backtracking_Forward_Checking
from timeit import default_timer

def Input(filename):
	def readfile(filename,delim=' '):
		with open(filename, 'r') as f:
			for line in f:
				yield list(line[:-1].split(delim))

	readline=readfile(filename)
	sudoku_board=[]
	for line in readline:
		if len(line)!=1:
			l=[]
			for t in line:
				l.append(Square(0,0,eval(t)))
			sudoku_board.append(l)

	sudoku = Board(sudoku_board)
	return sudoku


if __name__=="__main__":
	start=default_timer()
	filename='Easy.txt'
        #filename='Hard.txt'
        #filename='Medium.txt'
        #filename='Medium_1.txt'
        #filename='80_hard.txt'
	try:
		Main_Board=Input(filename)
	except ValueError:
		pass
	print Main_Board

	b_f = Backtracking_Forward_Checking(Main_Board)
	b_f.Initial_Forward_Checking()
	print "after"
	b_f.BackTrack();
	stop=default_timer()
	print Main_Board
	print "Time elapsed : ",stop-start
