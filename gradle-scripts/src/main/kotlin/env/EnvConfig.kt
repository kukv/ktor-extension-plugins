package env

data class EnvConfig(private val map: Map<String, String>) {
    fun propertyOrDefault(
        key: PropertyKey,
        defaultValue: String
    ): String = propertyOrNull(key) ?: defaultValue

    private fun propertyOrNull(key: PropertyKey): String? = map[key.name]

    companion object {
        fun factory(): EnvConfig = EnvConfig(System.getenv())
    }
}
