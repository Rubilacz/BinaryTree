import org.junit.Test
import kotlin.test.*

import org.clonecat.binarytree.Node

class NodeTest {

    @Test
    fun testConstruct() {
        val node = Node("Node1", Node("SubNode1", null, null), null)
        assertEquals("Node1", node.value)
        assertEquals("SubNode1", node.left!!.value)
        assertEquals(null, node.right)
    }

}