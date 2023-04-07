# ktor-extension-plugins

This plugin is used to retrieve preferences from outside of ktor's Application class.

## Installation

See [README](../README.md) at the top.

## How to use

### Installation

```kotlin
fun Application.module() {
    install(EnvironmentPlugin) {
        config = environment.config
    }
}
```

### Injecting preferences in Class

```kotlin
object Example : EnvironmentComponent {
  
    val foo by inject<String>("example.foo")
  
    fun baz() {
      val bar by injectOrDefault<Int>("example.bar", 0)
      
      val decimalList by injectList<BigDecimal>("example.decimalList")
    }
}
```

## Mappable types

The following types are currently available for injection.

- String
- Byte
- Short
- Int
- Long
- Float
- Double
- Boolean
- BigInteger
- BigDecimal
- java.time.LocalDate
- java.time.LocalDateTime
- java.time.LocalTime
- kotlinx.datetime.LocalDate (※1)
- kotlinx.datetime.LocalDateTime (※1)
- kotlinx.datetime.LocalTime (※1)

※1 To use them, add [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime) as a dependency.
