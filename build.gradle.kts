import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    java
}

val buildDirectory = layout.buildDirectory.get().asFile

val player1 = project.property("player1").toString()
val player2 = project.property("player2").toString()
val map = project.property("map").toString()
val seed = project.property("seed").toString()

val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_kk-mm-ss")

fun getReplayName(): String {
    return project.property("replayName").toString()
        .replace("%PLAYER1%", player1)
        .replace("%PLAYER2%", player2)
        .replace("%MAP%", map)
        .replace("%SEED%", seed)
        .replace("%TIMESTAMP%", dateTimeFormatter.format(LocalDateTime.now()))
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(fileTree("jars"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

sourceSets {
    main {
        java.srcDirs("src")
        java.destinationDirectory.set(buildDirectory.resolve("classes"))
    }

    test {
        java.srcDirs("test")
        java.destinationDirectory.set(buildDirectory.resolve("tests"))
    }
}

for (player in 1..2) {
    task("clean$player") {
        group = "ai coliseum"
        description = "Clean player $player."

        doLast {
            buildDirectory.resolve("classes/${project.property("player$player")}").deleteRecursively()
        }
    }

    task<JavaExec>("instrument$player") {
        group = "ai coliseum"
        description = "Instrument player $player."

        dependsOn("clean$player", "build")
        tasks.findByName("compileJava")!!.mustRunAfter("clean$player")

        mainClass.set("instrumenter.Main")
        classpath = sourceSets["main"].runtimeClasspath
        args = listOf(
            buildDirectory.resolve("classes/${project.property("player$player")}").toString(),
            project.property("player$player").toString(),
            "true"
        )
    }
}

task("instrument") {
    group = "ai coliseum"
    description = "Instrument player 1 and 2."

    dependsOn("instrument1", "instrument2")
}

task<JavaExec>("run") {
    group = "ai coliseum"
    description = "Run a match."

    dependsOn("instrument")

    mainClass.set("aic2023.main.Main")
    classpath = sourceSets["main"].runtimeClasspath
    jvmArgs = listOf("-noverify")

    doFirst {
        args = listOf(player1, player2, map, getReplayName(), "_default_", "_default_", "1", seed)
    }
}

task<JavaExec>("runDebug") {
    group = "ai coliseum"
    description = "Run a match in debug mode."

    dependsOn("instrument")

    mainClass.set("aic2023.main.Main")
    classpath = sourceSets["main"].runtimeClasspath
    jvmArgs = listOf(
        "-noverify",
        "-Xdebug",
        "-Xnoagent",
        "-Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=y"
    )

    doFirst {
        args = listOf(player1, player2, map, getReplayName(), "_default_", "_default_", "1", seed)
    }
}

task<JavaExec>("runSilent") {
    group = "ai coliseum"
    description = "Run a match in silent mode."

    dependsOn("instrument")

    mainClass.set("aic2023.main.Main")
    classpath = sourceSets["main"].runtimeClasspath
    jvmArgs = listOf("-noverify")

    doFirst {
        args = listOf(player1, player2, map, getReplayName(), "_default_", "_default_", "0", seed)
    }
}

task<JavaExec>("runChallenge") {
    group = "ai coliseum"
    description = "Run a match in challenge mode."

    dependsOn("instrument")

    mainClass.set("aic2023.main.MainChallenge")
    classpath = sourceSets["main"].runtimeClasspath
    jvmArgs = listOf("-noverify")
    args = listOf(player1, player2)
}

task<Zip>("createSubmission") {
    group = "ai coliseum"
    description = "Create a submission zip."

    from(file("src").absolutePath)
    include("myplayer/**/*")

    archiveBaseName.set(dateTimeFormatter.format(LocalDateTime.now()))
    destinationDirectory.set(buildDirectory.resolve("submissions"))
}
