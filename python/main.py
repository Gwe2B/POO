"""
Author: Gwenaël
Date  : 24/09/2020
"""

from PipedDice import *

def main():
    hDice = Dice()
    hDice.nb_faces = 10
    print(hDice.nb_faces)

if __name__ == '__main__':
    main()