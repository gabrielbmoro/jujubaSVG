[![Kotlin](https://img.shields.io/badge/kotlin-2.1.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/CodandoTV/jujubaSVG/issues)
[![Maven Central Version](https://img.shields.io/maven-central/v/io.github.codandotv/jujubaSVG)](https://central.sonatype.com/artifact/io.github.codandotv/jujubaSVG)
[![Unit tests](https://github.com/CodandoTV/jujubaSVG/actions/workflows/pr.yml/badge.svg)](https://github.com/CodandoTV/jujubaSVG/actions/workflows/pr.yml)
[![MegaLinter](https://github.com/CodandoTV/jujubaSVG/workflows/MegaLinter/badge.svg?branch=main)](https://github.com/CodandoTV/jujubaSVG/actions?query=workflow%3AMegaLinter+branch%3Amain)

# Welcome to the JujubaSVG library 👋

Welcome to the jujubaSVG library!

jujubaSVG library is a friendly library to handle SVG files in your Android app. The library allows you to manipulate piece by piece of your SVG. If you have an id for the element, you can access it to change background, stroke, and other things.

<img src="img/jujuba-icon.svg" />


📚 Our documentation is available [here](https://codandotv.github.io/jujubaSVG/).

---


## How to use? 🤔

You need to add the following line in your desired `module/build.gradle.kts`:

```kotlin
// ...
dependencies {
    implementation("io.github.codandotv:jujubaSVG:<library version>")
    // ...
}
    // ...
```

After that, you need to define at the top level of your composable function the
`commander` (a friend that will help you to send commands to the library):

```kotlin
@Composable
fun YourComposable() {
    val jujubaCommander = rememberJujubaCommander()
    // ...
}
```

Now you need to declare the Widget responsible to render the SVG file:

```kotlin
@Composable
fun YourComposable() {
    val jujubaCommander = rememberJujubaCommander()

    JujubaSVG(
        svgText = svgText,
        onElementClick = { nodeInfo ->
            println("NodeInfo $nodeInfo")
            coroutineScope.launch {
                // commander sample
                jujubaCommander.execute(
                    Command.RemoveNode(
                        nodeInfo.id
                    )
                )
            }
        },
        commander = jujubaCommander,
    )
}
```

Don't forget:

- `svgText` should contain all content of your SVG file.

### Sample project

More details you can check at our [sample project](sampleApp)

<img src="img/teaser.gif" height="500"  alt="teaser showing the app working with SVG image, where onClick deletes a State from Brazil."/>

### How to contribute?

- Fork this repository;

- Solve an issue, or do any improvement you want;

- Open a PR to the origin repository.

As soon the PR is reviewed and merged, your update will be available.
