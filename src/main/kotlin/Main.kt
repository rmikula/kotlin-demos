import cz.scorpionsoft.kotlin.demos.Person

class Button(private val onClick: () -> Unit) {
    fun performClick() {
        onClick()
    }
}

class ButtonClickListener(private val name: String) {
    fun onClick() {
        println(name)
    }
}

class ScreenView {
    var listener = ButtonClickListener("First")
    val buttonLambda = Button { listener.onClick() }
    val buttonReference = Button(listener::onClick)
}

class IntTransformer : (Int) -> Int {
    override fun invoke(p1: Int): Int {
        TODO("Not yet implemented")
    }
}

class HTML {
    fun body() {
        println("BOdy")
    }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}


fun main() {

    val res = html {
        body()
    }

    println(res)
}

fun main2(args: Array<String>) {

    val screenView = ScreenView()

    screenView.listener = ButtonClickListener("Second")
    screenView.buttonLambda.performClick()
    screenView.buttonReference.performClick()

    val intFunction: (hello: Int) -> Int = IntTransformer()

    intFunction(30)

}