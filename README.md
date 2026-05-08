# Taller2

Integrantes: Matias Gonzalez, Maximiliano Abd-El-Kader

Docentes: Alejandro Paolini, Cristian Rabi, Juan Nilo.

Ayudantes: Nicolás Rojas (Talleres), Catalina Galleguillos (Catedra), Martin Droguett (Catedra), Estefania Ulloa(Catedra).

El taller consiste en desarrollar una simulación de un juego de Pokémon por consola en Java. El jugador puede elegir un apodo, salir a capturar Pokémon en distintas zonas, armar su equipo y desafiar a los líderes de gimnasio en orden para luego enfrentarse al Alto Mando y coronarse campeón.
Para resolverlo creamos las clases Pokemon, Habitat, Persona, Gimnasio y TablaTipos, dejando toda la lógica del juego en el Main. Cada Pokémon tiene sus estadísticas (vida, ataque, defensa, ataque especial, defensa especial, velocidad y tipo), y los combates se resuelven comparando la suma de stats de ambos Pokémon, aplicando un multiplicador según la tabla de tipos (x2 si es efectivo, x0.5 si es poco eficaz). Los hábitats almacenan los Pokémon ponderados según su porcentaje de aparición para que la generación aleatoria sea proporcional. La partida se puede guardar y cargar desde un archivo Registros.txt, conservando el progreso del jugador, sus Pokémon y el estado de los gimnasios.
Para las peleas implementamos un método peleaPokemones que recibe al lider(Gimnasio) y al jugador. Dentro de un while, ambos sacan su Pokémon actual y el jugador elige entre atacar, cambiar de Pokémon o rendirse. Al atacar, se obtienen los stats totales de cada Pokémon y se consulta la TablaTipos con los tipos de ambos para obtener el multiplicador. Si el multiplicador es mayor a 1.0 los stats del jugador se multiplican por 2, si es menor a 1.0 se dividen a la mitad. Luego se comparan los stats resultantes y el que tenga mayor valor gana el enfrentamiento. El Pokémon perdedor queda Debilitado y se avanza al siguiente Pokémon disponible del lado correspondiente. La pelea termina cuando uno de los dos se queda sin Pokémon disponibles o el jugador se rinde, retornando true si ganó el jugador y false en caso contrario.
