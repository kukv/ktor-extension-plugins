package jp.kukv.annotation

@Target(AnnotationTarget.CLASS)
annotation class Routing(val value: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Route(val value: String = "", val method: Methods = Methods.GET)

@Target(AnnotationTarget.FUNCTION)
annotation class Authenticate(val value: String = "")

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class RequestBody

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class RequestParam(val value: String, val require: Boolean = true, val default: String = "")

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class PathParam(val value: String)
