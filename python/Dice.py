"""
Author : Gwenaël
Date   : 24/09/2020
Version: 1
"""

from random import randint

class Dice:
    MIN_FACES:int = 3
    MAX_FACES:int = 120

    __nb_instances:int = 0

    # ----------------------------- Specials Methods ----------------------------- #
    def __init__(self, faces:int = 6, nom:str = None):
        """
        Class Constructor
        
        :param faces: Number of faces (default 6)
        :param nom: Dice names (default None)
        """

        self.__nb_instances;
        self.nb_faces = faces

        if nom != None and len(nom) > 0:
            self.__name = nom
        else:
            self.__name = f"Dé n°{Dice.__nb_instances}"

    def __str__(self):
        """
        toString() equivalent
        :return: A representative string of the Dice
        """
        return f"Dice's name: {self.__name}\nNumber of faces: {self._nb_faces}"

    def __eq__(self, obj) -> bool:
        """
        equals() equivalent
        
        :param obj: Object to compare with the instance
        :return: True if they are equivalent, else return False
        """
        eq = False
        if isinstance(obj, self.__class__):
            eq = obj._nb_faces == self._nb_faces
        
        return eq

    def __ne__(self, obj) -> bool:
        """
        not equals() equivalent
        
        :param obj: Object to compare with the instance
        :return: False if they are equivalent, else return True
        """
        return not self.__eq__(obj)

    # ------------------------------ Getters/Setters ----------------------------- #
    def _set_nb_faces(self, faces:int):
        """
        Number of faces setters
        
        :param faces: Number of faces
        """
        if self.MIN_FACES <= faces <= self.MAX_FACES:
            self._nb_faces = faces
        else:
            raise Exception(f"Le nombre de face doit être compris entre {self.MIN_FACES} et {self.MAX_FACES}")

    def _get_nb_faces(self) -> int:
        return self._nb_faces

    def _get__name(self) -> str:
        return self.__name

    nb_faces = property(_get_nb_faces, _set_nb_faces)
    name = property(_get__name)

    # ------------------------------ Static Methods ------------------------------ #

    @classmethod
    def _get__nb_instances(cls) -> int:
        return cls.__nb_instances

    nb_instances = property(_get__nb_instances)

    # ------------------------------- Class Methods ------------------------------ #
    def _single_launch(self) -> int:
        """
        Launch the dice
        :return: A random number between 1 & the number of faces
        """
        return randint(1, self._nb_faces)

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