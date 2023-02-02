class Menu {
    fun visual1(): Int {
        val salida = "!"
        println("SELECCIONA UN MODO DE JUEGO")
        println("1-FACIL")
        println("2-NORMAL")
        println("3-DIFICIL")
        println("SI QUIRES SALIR INTRODUCE !")
        var respuesta = readln().toInt()
        while (respuesta.toString() != salida) {
            if (respuesta == 1) {
                return Iconos.FACIL
            } else if (respuesta == 2) {
                return Iconos.NORMAL

            } else if (respuesta == 3) {
                Iconos.DIFICL

            }else {
                println("HAS DE DECIDIR ALGO CON LOS NUMEROS")
                respuesta = readln().toInt()
            }
        }
            return Iconos.NORMAL
        }


}
