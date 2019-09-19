
from Square import Square


class Board:


	def __init__(self,b):
		self.unassigned_var=[]
		self.board=b
		position=0
		for i in range(0,9):
			for j in range(0,9):
				if not self.board[i][j].pre_assigned:
					self.unassigned_var.append(position)
				position+=1

		print position

	def isFinished(self):
		for i in range(0,9):
			for j in range(0,9):
				if self.board[i][j].Assigned_value==0:
					return False
		for i in range(0,9):
			for j in range(0,9):
				if not self.check_Consistent(i,j,self.board[i][j].Assigned_value):
					return False
		return True

	def Consistency_checking(self,x,y,value):
		i,j=x,y
		#print 'pos : ',i," ",j," val : ",value
		for k in range(0,9):
			if k!=j and self.board[i][k].Assigned_value==value:
				#print "return row"
				return False


		for k in range(0,9):
			if k!=i and self.board[k][j].Assigned_value==value:
				#print "return col"
				return False
		X=(i/3)*3
		Y=(j/3)*3

		for m in range(X,X+3):
			for n in range(Y,Y+3):
				if m!=i and n!=j  and self.board[m][n].Assigned_value==value:
					#print value," position ",m," ",n
					return False
		return True
	def __str__(self):
		string="";
		for i in range(0,9):
			for j in range(0,9):
				string+=str(self.board[i][j].Assigned_value)+" "
			string+="\n"
		return string
	def Domain(self):
		for i in range(9):
			for j in range(9):
				print i,"   ",j,"   ",self.board[i][j].Domain