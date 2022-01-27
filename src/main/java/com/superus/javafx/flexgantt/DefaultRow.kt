package com.superus.javafx.flexgantt

import com.flexganttfx.model.Activity
import com.flexganttfx.model.Row

class DefaultRow(
    private val mName: String,
) : Row<DefaultRow?, DefaultRow?, Activity?>(mName) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultRow

        if (mName != other.mName) return false

        return true
    }

    override fun hashCode(): Int {
        return mName.hashCode()
    }
}
