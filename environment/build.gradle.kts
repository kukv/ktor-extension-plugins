// なぜかサブプロジェクトの方はファイル自体にアノテーションを付与してあげないとビルドできなくなってしまう
// https://github.com/gradle/gradle/issues/23784
@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id("kotlin-module")
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.kotlinx.datetime)
}
