package com.superus.javafx.flexgantt

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import com.flexganttfx.view.GanttChart

class FlexganttApplication : Application() {
    override fun start(primaryStage: Stage) {
        val rootRow = DefaultRow("root1").apply {
            children.setAll(
                DefaultRow("row 11"),
                DefaultRow("row 12"),
                DefaultRow("row 13"),
                DefaultRow("row 14")
            )
        }

        val chart = GanttChart(rootRow).apply {
            treeTable.isShowRoot = false
        }

        val menuBar = MenuBar().apply {
            menus += Menu("Menu").apply {
                items += MenuItem("switch root").apply {
                    accelerator = KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN)
                    setOnAction {
                        chart.root = DefaultRow("root").apply {
                            children.setAll((1..4).shuffled().map { DefaultRow(it.toString()) })
                        }
                    }
                }
            }
        }

        val root = BorderPane().apply {
            top = menuBar
            center = chart
        }

        primaryStage.scene = Scene(root)
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(FlexganttApplication::class.java, *args)
}
