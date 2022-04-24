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

    companion object {
        const val GROUP_NAME = "Question Marks Group"
        const val QUESTION_MARK = "QuestionMark"
        const val QUESTION_MARK_SYMBOL = "?"
    }

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val group = FoldingGroup.newGroup(GROUP_NAME)

        // PsiIdentifier: classes methods fields and local fields
        return PsiTreeUtil.findChildrenOfType(root, PsiIdentifier::class.java)
            .asSequence()
            .filter { it.text.endsWith(QUESTION_MARK) }
            .map { FoldingDescriptor(it.node, it.textRange, group) }
            .toList()
            .toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return node.text.replace(QUESTION_MARK, QUESTION_MARK_SYMBOL)
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return true
    }
}