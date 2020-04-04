package com.shushper.demiurg.cell

class CellManager(private val generator: CellGenerator) {

    private val cells = mutableListOf<Cell>()

    fun getCells(): List<Cell> = cells.toList()

    fun createNewCell() {
        val cell = generator.getLivingOrDead()
        cells.add(cell)
        checkCells()
    }

    private fun checkCells() {
        if (isLastThreeCellsAre(CellType.LIVING)) {
            addLifeCell()
        } else if (isLastThreeCellsAre(CellType.DEAD)) {
            killLifeCells()
        }
    }

    private fun isLastThreeCellsAre(cellType: CellType): Boolean {
        if (cells.size < 3) return false

        return cells.takeLast(3).all { it.type == cellType }
    }

    private fun addLifeCell() {
        cells.add(Cell(CellType.LIFE))
    }

    private fun killLifeCells() {
        if (cells.size < 4) return

        var index = cells.lastIndex - 3
        var cell = cells[index]

        while (cell.isLife) {
            cells.removeAt(index)
            index--
            cell = cells[index]
        }
    }

}