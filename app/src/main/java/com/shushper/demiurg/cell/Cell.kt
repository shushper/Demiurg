package com.shushper.demiurg.cell

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.shushper.demiurg.R

enum class CellType {
    LIVING,
    DEAD,
    LIFE
}

data class Cell(val type: CellType) {

    val isLife: Boolean
        get() = type == CellType.LIFE

    val isLiving: Boolean
        get() = type == CellType.LIVING


    @DrawableRes
    fun getIconBackgroundRes(): Int {
        return when(type) {
            CellType.LIVING -> R.drawable.bg_cell_icon_living
            CellType.DEAD -> R.drawable.bg_cell_icon_dead
            CellType.LIFE -> R.drawable.bg_cell_icon_life
        }
    }

    @StringRes
    fun getIconEmojiRes(): Int {
        return when(type) {
            CellType.LIVING -> R.string.cell_icon_living
            CellType.DEAD -> R.string.cell_icon_dead
            CellType.LIFE -> R.string.cell_icon_life
        }
    }

    @StringRes
    fun getTitleRes(): Int {
        return when(type) {
            CellType.LIVING -> R.string.cell_title_living
            CellType.DEAD -> R.string.cell_title_dead
            CellType.LIFE -> R.string.cell_title_life
        }
    }

    @StringRes
    fun getSubtitleRes(): Int {
        return when(type) {
            CellType.LIVING -> R.string.cell_subtitle_living
            CellType.DEAD -> R.string.cell_subtitle_dead
            CellType.LIFE -> R.string.cell_subtitle_life
        }
    }
}



