

class Square:


	def __init__(self,x,y,val):
		self.Domain=[]
		if val!=0:
			self.pre_assigned = True
			self.assigned = True
			self.Assigned_value = val
			self.Domain.append(val)
		else:
			self.pre_assigned = False
			self.assigned = False
			for i in range(0,9):
				self.Domain.append(i+1)

			self.Assigned_value=0
