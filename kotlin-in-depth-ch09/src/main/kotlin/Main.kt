import com.sun.source.tree.Tree

fun main(args: Array<String>) {

    val root = TreeNode("Hello").apply {
        addChild("World")
        addChild("!!!")
    }

    println(root) // Hello {World {}, !!! {}}
}

fun <T : Number> TreeNode<T>.average(): Double {

    var count = 0
    var sum = 0.0

    walkDepthFirst {
        count++
        sum += it.toDouble()
    }

    return sum / count
}

fun <T> TreeNode<T>.walkDepthFirst(action: (T) -> Unit) {
    children.forEach { it.walkDepthFirst(action) }
    action(data)
}

class TreeNode<T>(val data: T) {

    private val _children = arrayListOf<TreeNode<T>>()
    var parent: TreeNode<T>? = null
        private set

    val children: List<TreeNode<T>> get() = _children

    fun addChild(data: T) = TreeNode(data).also {
        _children += it
        it.parent = this
    }

    override fun toString(): String =
        _children.joinToString(prefix = "$data {", postfix = "}")
}