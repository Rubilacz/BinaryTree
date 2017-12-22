package org.clonecat.binarytree

import java.io.PrintWriter

class Node<T>(var value: T, var left: Node<T>?, var right: Node<T>?) {

    override fun toString() = "value: $value, left: ${left?.value}, right: ${right?.value}"

    fun toGraphic(writer: PrintWriter) {
        doPrint(writer, "", true)
    }

    private fun doPrint(writer: PrintWriter, prefix: String, isTail: Boolean) {
        val preCur = if (isTail) "└── " else "├── "
        writer.println("${prefix}${preCur}${value}")
        val preChild = prefix + (if (isTail) "    " else "│   ")
        printChild(left, writer, preChild)
        printChild(right, writer, preChild)
    }

    private fun printChild(child: Node<T>?, writer: PrintWriter, prefix: String) {
        if (child != null) child.doPrint(writer, prefix, false) else writer.println("${prefix}└── null")
    }

}