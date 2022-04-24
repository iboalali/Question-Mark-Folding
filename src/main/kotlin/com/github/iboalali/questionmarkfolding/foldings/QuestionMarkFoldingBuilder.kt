package com.github.iboalali.questionmarkfolding.foldings

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiIdentifier
import com.intellij.psi.util.PsiTreeUtil

class QuestionMarkFoldingBuilder : FoldingBuilderEx(), DumbAware {

    init {
        println("${this::class.simpleName} loaded")
    }

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val group = FoldingGroup.newGroup("Question Marks Group")

        // PsiIdentifier: classes methods fields and local fields
        val identifiers = PsiTreeUtil.findChildrenOfType(root, PsiIdentifier::class.java)
        val foundIdentifiers = identifiers.filter { it.text.endsWith("QuestionMark") }

        val descriptors = foundIdentifiers.map { FoldingDescriptor(
            it.node,
            it.textRange,
            group
        ) }

        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return node.text.replace("QuestionMark", "?")
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return true
    }
}