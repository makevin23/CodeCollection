# x1 hours studied 
# x2 undergrad GPA
# y receive an A

import numpy as np

b0 = -6
b1 = 0.05
b2 = 1

x1 = 50
x2 = 3.5

def exponent(x1, x2):
    return b0+x1*b1+x2*b2

def predict(x1,x2):
    return np.exp(exponent(x1,x2))/(1+np.exp(exponent(x1,x2)))

print(predict(x1, x2))