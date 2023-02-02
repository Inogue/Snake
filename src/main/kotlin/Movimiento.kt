import java.lang.IndexOutOfBoundsException

class Movimiento(val difficulty: Int) {

    val mapeo = Mapa(difficulty)
    val mapa = mapeo.mapa
    var puntos = 0

    fun inicio(posicionx: Int, posiciony: Int, serTamano: Int) {
        mapeo.appleSpawn(difficulty)
        mapa[posicionx][posiciony] = Iconos.SERPIENTE
        mapeo.printaBordes()
        if (difficulty == Iconos.FACIL && puntos == 20) {
            victoria()
        } else if (difficulty == Iconos.NORMAL && puntos == 30) {
            victoria()
        } else if (difficulty == Iconos.DIFICL && puntos == 40) {
            victoria()
        } else {
            println("TIENES $puntos PUNTOS")
            val movimiento = readln().lowercase()
            if (movimiento == Posiciones.ABAJO)
                abajo(posicionx, posiciony, serTamano)
            else if (Posiciones.DERECHA == movimiento)
                derecha(posicionx, posiciony, serTamano)
            else if (Posiciones.ARRIBA == movimiento)
                arriba(posicionx, posiciony, serTamano)
            else if (Posiciones.IZQUIERDA == movimiento)
                izquierda(posicionx, posiciony, serTamano)
            else
                derecha(posicionx, posiciony, serTamano)
        }
    }

    fun abajo(posicionx: Int, posiciony: Int, serTamano: Int) {


        Thread.sleep(Iconos.REFRESH)
        if (serTamano > 0) {
            mapa[posicionx - serTamano][posiciony] = Iconos.VACIO
            mapeo.suma(posicionx, posiciony, serTamano, Posiciones.ABAJO)
        }

        try {

            if (mapa[posicionx + 1][posiciony] == Iconos.MANZANA) {


                puntos += 2
                inicio(posicionx + 1, posiciony, serTamano + 1)

            } else if (posicionx < mapa.size - 1) {


                mapa[posicionx - serTamano][posiciony] = Iconos.VACIO
                inicio(posicionx + 1, posiciony, serTamano)

            }
        } catch (e: IndexOutOfBoundsException) {
            mapeo.printaBordes()
            println(Iconos.MUERTE)
            return
        }
    }

    fun derecha(posicionx: Int, posiciony: Int, serTamano: Int) {

        Thread.sleep(Iconos.REFRESH)

        if (serTamano > 0) {
            mapa[posicionx][posiciony - serTamano] = Iconos.VACIO
            mapeo.suma(posicionx, posiciony, serTamano, Posiciones.DERECHA)
        }
        try {

            if (mapa[posicionx][posiciony + 1] == Iconos.MANZANA) {
                puntos += 2
                inicio(posicionx, posiciony + 1, serTamano + 1)
            } else if (posiciony < mapa.size - 1) {
                mapa[posicionx][posiciony - serTamano] = Iconos.VACIO
                inicio(posicionx, posiciony + 1, serTamano)
            }
        } catch (e: IndexOutOfBoundsException) {
            mapeo.printaBordes()
            println(Iconos.MUERTE)
            return
        }
    }

    fun arriba(posicionx: Int, posiciony: Int, serTamano: Int) {

        Thread.sleep(Iconos.REFRESH)

        if (serTamano > 0) {
            mapa[posicionx + serTamano][posiciony] = Iconos.VACIO
            mapeo.suma(posicionx, posiciony, serTamano, Posiciones.ARRIBA)
        }

        try {

            if (mapa[posicionx - 1][posiciony] == Iconos.MANZANA) {

                puntos += 2
                inicio(posicionx - 1, posiciony, serTamano + 1)

            } else if (posicionx < mapa.size - 1) {


                mapa[posicionx + serTamano][posiciony] = Iconos.VACIO

                inicio(posicionx - 1, posiciony, serTamano)

            }
        } catch (e: IndexOutOfBoundsException) {
            mapeo.printaBordes()
            println(Iconos.MUERTE)
            return
        }
    }

    fun izquierda(posicionx: Int, posiciony: Int, serTamano: Int) {


        Thread.sleep(Iconos.REFRESH)

        if (serTamano > 0) {
            mapa[posicionx][posiciony + serTamano] = Iconos.VACIO
            mapeo.suma(posicionx, posiciony, serTamano, Posiciones.IZQUIERDA)
        }

        try {

            if (mapa[posicionx][posiciony - 1] == Iconos.MANZANA) {

                puntos += 2
                inicio(posicionx, posiciony - 1, serTamano + 1)

            } else if (posiciony < mapa.size - 1) {


                mapa[posicionx][posiciony + serTamano] = Iconos.VACIO

                inicio(posicionx, posiciony - 1, serTamano)

            }
        } catch (e: IndexOutOfBoundsException) {
            mapeo.printaBordes()
            println(Iconos.MUERTE)
            return
        }
    }

    private fun victoria() {
        println(Iconos.VICTORIA)
    }

}