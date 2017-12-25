package org.clonecat.binarytree

import java.lang.StringBuilder

class Tree<T>(val root: Node<T>, val name: String? = null) {

    private val lineSeparator: String by lazy {
        System.getProperty("line.separator")
    }

    override fun toString(): String {
        val sb = StringBuilder()
        writeHead(sb)
        writeContent(sb)
        return sb.toString()
    }

    private fun writeHead(sb: StringBuilder) {
        sb.append("Tree(").append(if (name != null) "Name:${name}" else "HashCode:${hashCode()}").append("):${lineSeparator}")
    }

    private fun writeContent(sb: StringBuilder) {
        doWrite(root, sb, "", true)
    }

    private fun doWrite(node: Node<T>?, sb: StringBuilder, holder: String, isRightChild: Boolean) {
        val curPrefix = getPrefix(isRightChild)
        sb.append("${holder}${curPrefix}${node?.value}${lineSeparator}")
        if (node != null) {
            val childHolder = if (isRightChild) "${holder}    " else "${holder}|    "
            doWrite(node.left, sb, childHolder, false)
            doWrite(node.right, sb, childHolder, true)
        }
    }

    private fun getPrefix(isRightChild: Boolean) = if (isRightChild) "└── " else "├── "

}