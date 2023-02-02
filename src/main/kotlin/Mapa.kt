open class Mapa(tamano: Int) {
    var mapa: List<ArrayList<Any?>>

    init {
        val mapa = arrayListOf<ArrayList<Any?>>()
        for (x in 0 until tamano) {
            mapa.add(arrayListOf())
            for (y in 0 until tamano) {
                mapa[x].add(Iconos.MAPA)
            }
        }


        this.mapa = mapa
    }

    fun suma(posicionx: Int, posiciony: Int, serTamano: Int, movment: String) {

        when (movment) {
            Posiciones.ABAJO -> {
                for (elem in 0..serTamano) {
                    mapa[posicionx - elem][posiciony] = Iconos.SERPIENTE
                }
            }
            Posiciones.DERECHA -> {
                for (elem in 0..serTamano) {
                    mapa[posicionx][posiciony - elem] = Iconos.SERPIENTE

                }
            }
            Posiciones.ARRIBA -> {
                for (elem in 0..serTamano) {
                    mapa[posicionx + elem][posiciony] = Iconos.SERPIENTE

                }
            }
            Posiciones.IZQUIERDA -> {
                for (elem in 0..serTamano+serTamano) {
                    mapa[posicionx][posiciony + elem] = Iconos.SERPIENTE

                }
            }
            else -> {
                for (elem in 0..serTamano) {
                    mapa[posicionx][posiciony - elem] = Iconos.SERPIENTE

                }
            }
        }

    }

    fun appleSpawn(tamano: Int) {
        var confirm = false
        for (elem in mapa) {
            for (casilla in elem) {
                if (casilla == Iconos.MANZANA)
                    confirm = true
            }
        }
        if (!confirm) {
            mapa[(0 until tamano).random()][(0 until tamano).random()] = Iconos.MANZANA
        }

    }

    fun printaBordes() {
        repeat(mapa.size + 1) {
            print(" # ")
        }
        println()
        for (fila in mapa) {
            print("# ")
            for (casilla in fila) {
                print(casilla ?: Iconos.VACIO)
            }
            println(" #")
        }
        repeat(mapa.size + 1) {
            print(" # ")
        }
        println()
    }
}
