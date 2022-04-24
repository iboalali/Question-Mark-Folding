package com.github.iboalali.questionmarkfolding.listeners

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

internal class MyProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        println("Welcome to the era of folding Question Marks")
    }
}
