import kotlin.reflect.KProperty1

fun main(args: Array<String>) {
    println("chapter-10 start")


    val secretHolder = SecretHolder("Secret")
    var secretProperty = secretHolder::class.members
        .first {
            it.name == "secret"
        } as KProperty1<SecretHolder, String>

    println(secretProperty.get(secretHolder))
}

class SecretHolder(private val secret: String)