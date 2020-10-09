"""
Author : Gwenaël
Date   : 24/09/2020
Version: 1
"""

from Dice import *

class PipedDice(Dice):

    # -------------------------- Specials class methods -------------------------- #
    def __init__(self, b_inf:int, faces:int = 6, nom:str = None):
        """Class constructor

        :param b_inf: Minimum of the random number
        :param faces: Number of Dice's faces, defaults to 6
        :param nom: Dice's name, defaults to None
        :raises Exception: If the b_inf parameter is invalid
        """
        Dice.__init__(self, faces, nom)

        if 0 < b_inf <= self._nb_faces:
            self.__b_inf:int = b_inf
        else:
            raise Exception(f"La borne doit être comprise entre 1 et {self._nb_faces}")

    # ------------------------------ Getters/Setters ----------------------------- #
    def _get__b_inf(self) -> int:
        return self.__b_inf

    b_inf = property(_get__b_inf)

    # ------------------------------- Class methods ------------------------------ #
    def _single_launch(self) -> int:
        """Launch the piped dice
        :return: A random number between b_inf & nb_faces
        """
        return randint(self.b_inf, self.nb_faces)

    def _multiple_launch(self, nb:int) -> int:
        """
        Make nb launch of the dice
        
        :param nb: Number of launch
        :return: The best launch
        """
        meilleur:int = 0
        val:int = 0

        for i in range(nb):
            val = self.lancer()
            if val > meilleur:
                meilleur = val

        return meilleur

    def lancer(self, *args) -> int:
        """Appel single_launch ou multiple_launch en fonction des parametres
        
        :param *args: Tuple contenant les parametres passé à la fonction
        :return: Valeur renvoyé par la fonction appelé
        """
        # Possibility to use **kwargs instead of *args
        # *args    -> tuple
        # **kwargs -> dict

        if len(args) == 1:
            to_return = self._multiple_launch(args[0])
        elif len(args) == 0:
            to_return = self._single_launch()

        return to_return