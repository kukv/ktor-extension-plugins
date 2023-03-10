package env

data class ENV(private val map: Map<String, String>) {

    fun propertyOrThrow(key: PropertyKey): String = propertyOrNull(key) ?: throw IllegalArgumentException("key does not exist. %s".format(key))
    fun propertyOrDefault(key: PropertyKey, defaultValue: String): String = propertyOrNull(key) ?: defaultValue
    fun propertyOrNull(key: PropertyKey): String? = map[key.name]

    companion object {

        fun factory(): ENV = ENV(System.getenv())
    }
}
