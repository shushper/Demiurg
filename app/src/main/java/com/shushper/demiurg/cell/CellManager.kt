package com.shushper.demiurg.cell

class CellManager(private val generator: CellGenerator) {

    private val cells = mutableListOf<Cell>()

    fun getCells(): List<Cell> = listOf(*cells.toTypedArray())

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

        val lastCells = cells.takeLast(3)

        for (cell in lastCells) {
            if (cell.type != cellType) {
                return false
            }
        }

        return true
    }

    private fun addLifeCell() {
        cells.add(Cell(CellType.LIFE))
    }

    private fun killLifeCells() {
        var index = cells.lastIndex - 3
        var cell = cells[index]

        while (cell.isLife) {
            cells.removeAt(index)
            index--
            cell = cells[index]
        }
    }

}