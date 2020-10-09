"""
Author : Gwenaël
Date   : 24/09/2020
Version: 1
"""

from Dice import *
from typing import *

class OtherDice(Dice):

    # ------------------------- Special class attributes ------------------------- #
    def __init__(self, faces_elt:List[Any], faces:int = 6, nom:str = None):
        """Class constructor

        :param faces_elt: List of any containing the faces elements
        :param faces: Number of dice's faces, defaults to 6
        :param nom: Dice's name, defaults to None
        """
        Dice.__init__(self, faces, nom)
        
        if len(faces_elt) == faces:
            self._faces_elt:List[Any] = faces_elt
        else:
            raise Exception("The number of faces elements must be the same as the number of faces")

    # ---------------------------------- Getters --------------------------------- #
    def _get_faces_elt(self):
        return self.faces_elt

    faces_elt = property(_get_faces_elt)

    # ------------------------------- Class Methods ------------------------------ #
    def lancer(self) -> Any:
        """Launch the Dice
        :return: An element of the dice taken randomly
        """
        return self._faces_elt[Dice.lancer(self)]