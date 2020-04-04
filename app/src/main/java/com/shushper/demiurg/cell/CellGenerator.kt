package com.shushper.demiurg.cell

import java.util.*

class CellGenerator {

    private val random = Random()

    fun getLivingOrDead(): Cell {
        return if (random.nextBoolean()) {
            Cell(CellType.LIVING)
        } else {
            Cell(CellType.DEAD)
        }
    }
}