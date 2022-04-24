package com.github.iboalali.questionmarkfolding.listeners

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

internal class MyProjectManagerListener : ProjectManagerListener {

    init {
        println("${this::class.simpleName} loaded")
    }

    override fun projectOpened(project: Project) {
        println("Welcome to the folding of Question Marks project!")
    }
}
