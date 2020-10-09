"""
Author : Gwenaël
Date   : 24/09/2020
Version: 1
"""

from Dice import *

class MemoryDice(Dice):

    def __init__(self, faces:int = 6, nom:str = None):
        """Class constructor
        :param faces: Number of Dice's faces, defaults to 6
        :param nom: Dice's name, defaults to None
        """
        Dice.__init__(self, faces, nom)
        self.__last_launch:int = 0

    def _single_launch(self) -> int:
        """Launch the piped dice
        :return: A random number between b_inf & nb_faces different from last_launch
        """
        launch = randint(1, self._nb_faces)

        while launch == self.__last_launch:
            launch = randint(1, self._nb_faces)

        return launch

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
        if len(args) == 1:
            to_return = self._multiple_launch(args[0])
        elif len(args) == 0:
            to_return = self._single_launch()

        return to_return