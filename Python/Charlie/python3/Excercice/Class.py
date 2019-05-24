class MyClass:
    """一个简单的类实例"""
    i = 12345
    def f(self):
        return 'hello world'

# 实例化类
x = MyClass()

# 访问类的属性和方法
print("MyClass 类的属性 i 为：", x.i)
print("MyClass 类的方法 f 输出为：", x.f())



#类定义
class people:
    #定义基本属性
    name = ''
    age = 0
    #定义私有属性,私有属性在类外部无法直接进行访问
    __weight = 0
    #定义构造方法
    def __init__(self,n,a,w):
        self.name = n
        self.age = a
        self.__weight = w
    def speak(self):
        print("%s 说: 我 %d 岁。" %(self.name,self.age))

# 实例化类
p = people('W3Cschool',10,30)
p.speak()




class Vector:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    def __str__(self):
        return 'Vector (%d, %d)' % (self.a, self.b)

    def __add__(self, other):
        return Vector(self.a * other.a, self.b * other.b)


v1 = Vector(2, 10)
print(v1)
v2 = Vector(5, -2)
print(v2)



class Sience:
    # a = 0
    def __init__(self, a):
        self.a = a
    # def __str__(self):
    #     return 'Sience (%d, %d)' % (self.a, self.a)
    def __add__(self, other):
        return self.a * self.a
        # return self.a * self.a
# a = 7
s = Sience(7)
print(s + s)