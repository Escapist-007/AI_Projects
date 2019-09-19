
class Backtracking_Forward_Checking(object):
		
	def __init__(self,b):
		
		self.Variable_Count = 0
		self.Value_Count = 0
		self.board = b
	
	
	def BackTrack(self):
		
		
		if self.board.isFinished():
			print "Variable Count: ",Variable_Count," Value_Count: ",Value_Count
			print 
			return True
			
		position = self.variable_first()
		#position=self.MRV()
				
		i = position / 9
		j = position % 9
		
		
		if len(self.board.board[i][j].Domain)==0:
			
			print "Domain is empty:\n\n",board
			return False
		
		
		
		if not self.board.board[i][j].assigned:

			for k in range(0,len(self.board.board[i][j].Domain)):

				value = self.vaule_first(i,j,k)

				if self.board.Consistency_checking(i,j,value):

					self.board.board[i][j].Assigned_value = value
					self.board.board[i][j].assigned = True


					if self.Forward_Check(i,j,self.board.board[i][j].Assigned_value):
						print "assign ",value,"  pos ",i," ",j
						try:
							print self.board
							result = self.BackTrack()
							if result :
								return result

						except ValueError:
							print len(self.board.board.unassigned_var)," ",position+1
							
					self.Backward_Check(i,j,self.board.board[i][j].Assigned_value)
					self.board.board[i][j].Assigned_value = 0
					self.board.board[i][j].assigned = False

				 
			
			
		
		
		return False
	
	def Initial_Forward_Checking(self):
		
		for i in range(0,9):
			for j in range(0,9):
				if(self.board.board[i][j].pre_assigned):
					val = self.board.board[i][j].Assigned_value
					self.Forward_Check(i,j,val)

	#constraint propagation
		
	def Forward_Check(self,x,y,value):
		
		i = x
		j = y

	     #Reducing the domain of the square in that row

		for k in range(0,9):
			#skipping the square for which forward checking is  performed       
		   
			if(k==j):
				continue
			
			flag = (not self.board.board[i][k].pre_assigned) and ( not self.board.board[i][k].assigned)
			
			if flag:
				
				if  value in  self.board.board[i][k].Domain:

					self.board.board[i][k].Domain.remove(value)
					if i==2 and k==5:
						print "board :",self.board 
						print "remove ",i," ",j," ",value
			
		
	
		
		#Reducing the domain of the square in that column

		for k in range(0,9):                    
			
			#skipping the square for which forward checking is  performed       
		   
			if(k==i):
				continue
			
			flag = (not self.board.board[k][j].pre_assigned) and ( not self.board.board[k][j].assigned)
			
			if flag:
				
				if  value  in  self.board.board[k][j].Domain:

					self.board.board[k][j].Domain.remove(value)
					if k==2 and j==5:
						print "board :",self.board 
						print "remove ",i," ",j," ",value
				
			
		
		
		#Reducing the domain of the square in that block/regions
		
		X = (i/3)*3
		Y = (j/3)*3

		for m in range(X,X+3):  
			
			for n in range(Y,Y+3):
			
				if m==i and n==j:
					continue
				
				flag = ( not self.board.board[m][n].pre_assigned ) and ( not self.board.board[m][n].assigned)
				
				if flag :
					
					if value  in  self.board.board[m][n].Domain:
						self.board.board[m][n].Domain.remove(value)
						if m==2 and n==5:
							print "board :",self.board 
							print "remove ",i," ",j," ",value
							
			
		

		#inference constraint propagation check
		
		for i in range(0,9):  
			for j in range(0,9):
				
				#@checking if domain is empty for any variable
				if len(self.board.board[i][j].Domain)==0:
					print "Domain : ",self.board.board[i][j].Domain,i," ",j," value ",value
					return False
		  
			
		

		return True
		
   
	
	def Backward_Check(self,x,y,value):
		
		i = x
		j = y

		#Fixing the domain of the square in that row
		for k in range(0,9):
			#skipping the square for which forward checking is  performed		
		   
			if(k==j):
				continue
			
			flag = (not self.board.board[i][k].pre_assigned) and ( not self.board.board[i][k].assigned)
			
			if flag:
				
				if  value not in  self.board.board[i][k].Domain:

					self.board.board[i][k].Domain.append(value)
			
		
		
		#Fixing the domain of the square in that column

		for k in range(0,9):					
			
			#skipping the square for which forward checking is  performed       
		   
			if(k==i):
				continue
			
			flag = (not self.board.board[k][j].pre_assigned) and ( not self.board.board[k][j].assigned)
			
			if flag:
				
				if  value not in  self.board.board[k][j].Domain:

					self.board.board[k][j].Domain.append(value)
				
			
		

		#Fixing the domain of the square in that block/regions
		
		X = (i/3)*3
		Y = (j/3)*3

		for m in range(X,X+3):	
			
			for n in range(Y,Y+3):
			
				if m==i and n==j:
					continue
				
				flag = ( not self.board.board[m][n].pre_assigned ) and ( not self.board.board[m][n].assigned)
				
				if flag :
					
					if value not in  self.board.board[k][j].Domain:
						self.board.board[m][n].Domain.append(value)
							
			
		

	   
  
	
	
	def variable_first(self):
		
		self.Variable_Count+=1

		for i in range(0,len(self.board.unassigned_var)):
			
			row = self.board.unassigned_var[i]/9 
			col = self.board.unassigned_var[i]%9 
			
			if not self.board.board[row][col].assigned:
			   return self.board.unassigned_var[i]
			 
		

		return -1
	
	
	
	def MRV(self):
		
		min_domain = 200000
		position = -1
		self.Variable_Count+=1

		for i in range(0,len(self.board.unassigned_var)):

			x = self.board.unassigned_var[i]/9
			y = self.board.unassigned_var[i]%9

			if (( not self.board.board[x][y].assigned) and (len(self.board.board[x][y].Domain) < min_domain) ):

				min_domain = len(self.board.board[x][y].Domain)
				position = self.board.unassigned_var[i]
			



		return position
	
	#value heuristic
	def vaule_first(self,x,y,z):
		
		self.Value_Count+=1
				
		for j in range(0,len(self.board.board[x][y].Domain)):
			if j==z:
				return self.board.board[x][y].Domain[z] 
			
		
		
		return 0
	
	

