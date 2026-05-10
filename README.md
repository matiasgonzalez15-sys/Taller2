# Taller2

Integrantes: Matias Gonzalez, Maximiliano Abd-El-Kader

Docentes: Alejandro Paolini, Cristian Rabi, Juan Nilo.

Ayudantes: Nicolás Rojas (Talleres), Catalina Galleguillos (Catedra), Martin Droguett (Catedra), Estefania Ulloa(Catedra).

El taller consistía en crear una simulación de un juego de Pokémon por consola en Java, donde el jugador puede elegir un apodo, salir a capturar Pokémon en distintas zonas, armar su equipo y desafiar a 8 líderes de gimnasio en orden consecutivo para luego enfrentarse al Alto Mando y coronarse campeón. Para abordarlo, diseñamos el proyecto en torno a 5 clases principales: Pokemon, que almacena todas las estadísticas y el tipo de cada Pokémon; Habitat, que representa las zonas del mundo y guarda una lista ponderada de Pokémon según su porcentaje de aparición para que la captura aleatoria sea proporcional; Persona, que modela tanto al jugador como a los líderes de gimnasio y miembros del Alto Mando, gestionando su lista de Pokémon; Gimnasio, que agrupa a cada lider con su estado de batalla; y TablaTipos, que implementa la tabla de efectividad de tipos mediante una matriz de 18x18 y calcula el multiplicador de stats en cada combate. Toda la lógica del juego, incluyendo los menús, la lectura de archivos, el sistema de combate y el guardado de partida, fue centralizada en el Main. Los combates se resuelven comparando la suma de stats de ambos Pokémon, aplicando un multiplicador de x2 si el tipo es efectivo o x0.5 si es poco eficaz, avanzando al siguiente Pokémon disponible cuando uno cae debilitado, y terminando cuando uno de los dos lados se queda sin Pokémon o el jugador decide rendirse. En general el taller fue un buen ejercicio para aplicar POO de forma práctica, ya que obligó a pensar bien la distribución de responsabilidades entre clases y a manejar lectura y escritura de archivos de forma ordenada.

PD: El diagrama de clases se ve asi porque no encontre otra forma de descargarlo q no se viera cortado JADSKSJAK asi q hay q descargarlo y ahi hacerle zoom.
