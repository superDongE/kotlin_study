import kotlinx.coroutines.*
import java.lang.System.currentTimeMillis
import kotlin.concurrent.timer

/*
fun main(args: Array<String>) {

    val time = currentTimeMillis()

    GlobalScope.launch { // launch -> 시작
        delay(100)
        println("Task 1 finished in ${currentTimeMillis() - time} ms")
    }

    GlobalScope.launch {
        delay(100)
        println("Task 2 finished in ${currentTimeMillis() - time} ms")
    }

    // out-log :
    // Task 2 finished in 207 ms
    // Task 1 finished in 207 ms

    Thread.sleep(200)

}*/

/*suspend fun main() {
    val message = GlobalScope.async {
        delay(100)
        "abc"
    }

    val count = GlobalScope.async {
        delay(100)
        1 + 2
    }

    delay(100)

    val result = message.await().repeat(count.await())
    println(result)

    // out-log
    // abcabcabc
}*/

/*fun main() {

    GlobalScope.launch {
        delay(100)
        println("Background task : ${Thread.currentThread().name}") // Background task : DefaultDispatcher-worker-1
    }

    runBlocking {
        println("Primary task : ${Thread.currentThread().name}") // Primary task : main
        delay(200)
    }

    // out-log
    // Primary task : main
    // Background task : DefaultDispatcher-worker-1
}*/

/*fun main() {
    runBlocking {
        println("Parent task started")

        launch {
            println("Task A Start")
            delay(200)
            println("Task A End")
        }

        launch {
            println("Task B Start")
            delay(200)
            println("Task B End")
        }

        delay(100)
        println("Parent task finished")
    }
    println("Shutting down")

    // out - log
    */
/**
Parent task started
Task A Start
Task B Start
Parent task finished
Task A End
Task B End
Shutting down
 *//*
}*/

/*fun main() {
    runBlocking {
        println("Custom scope start")

        coroutineScope {
            launch {
                delay(200)
                println("Task 1 finished")
            }

            launch {
                delay(100)
                println("Task 2 finished")
            }
        }
        println("Custom scope end")
    }

    // out - log
    *//**
Custom scope start
Task 1 finished
Task 2 finished
Custom scope end
 *//*
}*/

/*
fun main() {
    GlobalScope.launch {
        // 현재 잡을 얻고 "Task is active: true"를 출력
        println("Task is active: ${coroutineContext[Job.Key]!!.isActive}")
    }

    Thread.sleep(200) // Main이 더 빨리 끝나서 sleep을 동작하였습니다.
}*/
/*
fun main() {
    runBlocking {
        val job = launch(start = CoroutineStart.LAZY) {
            println("Job started")
        }

        val job1 = launch { // default가 자동으로 실행임.
            println("Job1 started")
        }

        delay(100)

        println("Preparing to start...")
        job.start()

        */
/*
            Job1 started
            Preparing to start...
            Job started
         *//*

    }
}*/
/*fun main() {
    runBlocking {
        *//*val job = coroutineContext[Job.Key]!!

        launch { println("This is task A") }
        launch { println("This is task B") }

        println("${job.children.count()} children running")*//*

        *//*
        2 children running
        This is task A
        This is task B
         *//*

        val job = coroutineContext[Job.Key]!!

        val jobA = launch { println("This is task A") }
        val jobB = launch { println("This is task B") }

        jobA.join()
        jobB.join()

        println("${job.children.count()} children running")

        *//*
            This is task A
            This is task B
            0 children running
         *//*
    }
}*/
/*suspend fun main() {
    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
        var i = 1
        while (isActive) {
            println(i++)
        }
    }

    delay(100)
    squarePrinter.cancel()
}*/
/*suspend fun main() {
    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
        var i = 1
        while (true) {
            yield() // 실행중인 잡을 일시중단 시켜서 자신을 실행 중인 스레드를 다른 코루틴에게 양보한다.
            println(i++)
        }
    }

    delay(100)
    squarePrinter.cancel()
}*/

/*fun main() {
    runBlocking {
        launch {
            throw Exception("Error Task A")
            println("Task A completed")
        }

        launch {
            delay(1000)
            println("Task B completed")
        }

        println("Root")
    }
}*/

/*suspend fun main() {
    val handler = CoroutineExceptionHandler { _, throwable ->
        println("throwable : $throwable")
    }

    GlobalScope.launch(handler) {
        launch {
            throw Exception("Error Task A")
            println("Task A completed")
        }

        launch {
            delay(1000)
            println("Task B completed")
        }

        println("Root")
    }.join()
}*/

/*fun main() {
    runBlocking {
        supervisorScope {
            val deferredA = async {
                throw Exception("Error in Task A")
                println("Task A completed")
            }

            val deferredB = async {
                println("Task B completed")
            }

            try {
                deferredA.await()
            } catch (e: Exception) {
                println("Caught : $e")
            }
            deferredB.await()
            println("Root")
        }


    }
}*/

fun main() {
    println("Starting a thread ...")
    var counter = 0

    kotlin.concurrent.timer(period = 150, name = "Worker", daemon = true) {
        println("${Thread.currentThread().name} : ${counter++}")
    }

    Thread.sleep(500)
    println("Shutting down ...")
}


