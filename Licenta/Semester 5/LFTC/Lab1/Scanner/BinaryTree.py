class Node:
    def __init__(self,val):
       self.value=val
       self.leftChild=None
       self.rightChild=None

    def insert(self, data):

        if self.value[0] == data[0]:
            return False
        elif self.value[0] > data[0]:
            if self.leftChild:
                return self.leftChild.insert(data[0])

            else:
                self.leftChild=Node(data[0])
                return True
        else:
            if self.rightChild:
                return self.rightChild.insert(data[0])
            else:
                self.rightChild=Node(data[0])

    def find(self, data):
        if self.value[0] == data[0]:
            return data[1]
        elif self.value[0] >data[0]:
            if self.leftChild:
                return self.leftChild.find(data[0])
            else:
                return False
        else:
            if self.rightChild:
                return self.rightChild.find(data[0])
            else:
                return False
    def inorder(self):
        if self:
            if self.leftChild:
                self.leftChild.inorder()
            if self.rightChild:
                self.rightChild.inorder()
            print(str(self.value))

class Tree:
    def __init__(self):
        self.root=None

    def insert(self,data):
        if self.root:
            return self.root.insert(data)
        else:
            self.root = Node(data)
            return True

    def find(self,data):
        if self.root:
            return self.root.find(data)
        else:
            return False

    def inorder(self):
        self.root.inorder()
bst=Tree()
l=[]
l.append([3,2])
l.append([331,2])
l.append([32,2])
bst.insert(l[0])
bst.insert(l[1])
bst.insert(l[2])
bst.inorder()