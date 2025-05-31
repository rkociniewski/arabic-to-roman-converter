# Arabic to Roman Converter

[![version](https://img.shields.io/badge/version-1.0.1-yellow.svg)](https://semver.org)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![Build](https://github.com/rkociniewski/arabic-to-roman-converter/actions/workflows/main.yml/badge.svg)](https://github.com/rkociniewski/arabic-to-roman-converter/actions/workflows/main.yml)
[![codecov](https://codecov.io/gh/rkociniewski/arabic-to-roman-converter/branch/main/graph/badge.svg)](https://codecov.io/gh/rkociniewski/arabic-to-roman-converter)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.21-blueviolet?logo=kotlin)](https://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8.14.1-blue?logo=gradle)](https://gradle.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-greem.svg)](https://opensource.org/licenses/MIT)

A simple Kotlin library to convert Arabic integers to their Roman numeral representation.

## Features

- Converts individual integers to Roman numerals
- Extension functions for `Int`, `Set<Int>`, and `List<Int>`
- Duplicate elimination when converting collections
- Minimal and idiomatic Kotlin API

## Usage

### Convert a single number:

```kotlin
val roman = 1987.toRoman() // "MCMLXXXVII"
````

### Convert a set of integers:

```kotlin
val numbers = setOf(3, 4, 9)
val romanList = numbers.toRoman() // ["III", "IV", "IX"]
```

### Convert a list (duplicates removed):

```kotlin
val numbers = listOf(5, 5, 10, 1)
val romanList = numbers.toRoman() // ["V", "X", "I"]
```

## Notes

* Values ≤ 0 return an empty string.
* Collections are deduplicated using `Set`.

## License

MIT

```

## Built With

* [Gradle](https://gradle.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Rafał Kociniewski** - [PowerMilk](https://gitlab.com/rafal.kociniewski)
