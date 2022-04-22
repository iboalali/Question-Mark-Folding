package com.github.iboalali.questionmarkfolding.foldings

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue
import com.intellij.psi.util.PsiTreeUtil

class QuestionMarkFoldingBuilder() : FoldingBuilderEx(), DumbAware {


    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val group = FoldingGroup.newGroup("Question Marks Group")

        val descriptors = mutableListOf<FoldingDescriptor>()

        //val literalExpression: Collection<PsiLiteralValue> = PsiTreeUtil.findChildOfType(root, PsiLiteralValue)

        return arrayOf()
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return "?"
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return true
    }
}