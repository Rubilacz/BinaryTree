import org.junit.Test
import org.junit.Before
import kotlin.test.*
import java.io.PrintWriter

import org.clonecat.binarytree.Node

class NodeTest {

    var node: Node<String>? = null

    @Before
    fun setUp() {
        node = Node("Node1", Node("SubNode1", null, null), null)
    }

    @Test
    fun testConstructor() {
        assertEquals("Node1", node?.value)
        assertEquals("SubNode1", node?.left!!.value)
        assertEquals(null, node?.right)
    }

    @Test
    fun testtoGraphic() {
        val writer = PrintWriter("build/node_to_graphic.txt")
        node?.toGraphic(writer)
        writer.close()
    }

}