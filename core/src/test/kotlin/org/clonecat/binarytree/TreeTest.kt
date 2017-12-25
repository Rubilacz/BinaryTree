import org.junit.Test
import org.junit.Before
import kotlin.test.*

import java.io.File

import org.clonecat.binarytree.*

class TreeTest {

    var tree: Tree<String>? = null

    @Before
    fun setUp() {
        val root = Node("Root", Node("Root.Left", Node("Root.Left.Left", null, null), null), Node("Root.Right", null, Node("Root.Right.Right", null, null)))
        tree = Tree(root, "TreeName")
    }

    @Test
    fun testToString() {
        File("build/node_to_graphic.txt").writeText(tree.toString())
    }

}