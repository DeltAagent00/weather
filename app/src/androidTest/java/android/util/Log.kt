package android.util

class Log {
    companion object {
        fun println(priority: Int, tag: String, msg: String): Int {
            println("[$priority]$tag: $msg")
            return 0
        }
    }
}