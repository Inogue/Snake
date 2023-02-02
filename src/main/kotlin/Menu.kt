class Menu {
    fun visual1(): Int {
        val salida = "!"
        println("SELECCIONA UN MODO DE JUEGO")

        println("1-FACIL -> MAPA 10x10, PUNTUACION 20")
        println("2-NORMAL -> MAPA 15x15, PUNTUACION 30")
        println("3-DIFICIL -> MAPA 20x20, PUNTUACION 40")
        println("SI QUIRES SALIR INTRODUCE !")
        var respuesta = readln()
        while (respuesta != salida) {
            when (respuesta) {
                "1" -> {
                    return Iconos.FACIL
                }
                "2" -> {
                    return Iconos.NORMAL

                }
                "3" -> {
                    Iconos.DIFICL

                }
                else -> {
                    println("HAS DE DECIDIR ALGO CON LOS NUMEROS")
                    respuesta = readln()
                }
            }
        }
        println("PUES ADIOS")
      visual1()
            return 0
        }


}
