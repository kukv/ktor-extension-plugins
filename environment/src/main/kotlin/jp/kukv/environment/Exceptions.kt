package jp.kukv.environment

internal class KeyNotFoundException(message: String) : RuntimeException(message)

internal class InitializationFailureException(message: String) : RuntimeException(message)
