# ktor-extension-plugins
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081?style=flat-square)](https://pinterest.github.io/ktlint/)
[![Maven Central](https://img.shields.io/maven-central/v/jp.kukv.ktor-extension-plugins/environment?style=flat-square)](https://central.sonatype.com/namespace/jp.kukv.ktor-extension-plugins)
![GitHub](https://img.shields.io/github/license/kukv/ktor-extension-plugins?style=flat-square)

Library for [ktor](https://ktor.io/) extension.

To learn more please refer to the READMEs of individual modules.

The following modules are currently available.

| module                                 | description                                                    |
|:---------------------------------------|----------------------------------------------------------------|
| [environment](./environment/README.md) | Retrieve preferences from outside of ktor's Application class. |

## Installation

1. Add the repository.
    ```kotlin
    repositories {
        mavenCentral()
    }
    ```

2. Add the dependency.
    ```kotlin
    implementation("com.github.kukv.ktor-extension-plugins:<module>:<version>")
    ```

## License

ktor-extension-plugins is provided under the MIT License.

Copyright (c) 2023 kukv.
