buildscript {
    with(extra) {
        set("kotlin_version", "1.3.60")
        set("klockVersion", "1.8.0")
    }
}

repositories {
    mavenCentral()
    jcenter()
}


plugins {
    kotlin("multiplatform") version ("1.3.60")
}

repositories {
    mavenCentral()
    jcenter()
}

group = "com.example"
version = "1.0-SNAPSHOT"


kotlin {
    targets {
        jvm {
            compilations.all {
                kotlinOptions {
                    freeCompilerArgs = listOf("-Xjsr305=strict")
                    jvmTarget = "1.8"
                }
            }
        }
        js {
            useCommonJs()
            nodejs {
                testTask {
                    debug = true
                    useMocha()
                }
            }

        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:${extra["kotlin_version"]}")
                implementation("com.soywiz.korlibs.klock:klock:${extra["klockVersion"]}")
            }
        }
        commonTest {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common:${extra["kotlin_version"]}")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:${extra["kotlin_version"]}")
            }
        }
        js().compilations["main"].defaultSourceSet {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-js:${extra["kotlin_version"]}")
                implementation("com.soywiz.korlibs.klock:klock-js:${extra["klockVersion"]}")
            }
        }
        js().compilations["test"].defaultSourceSet {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-js:${extra["kotlin_version"]}")
            }
        }
        jvm().compilations["main"].defaultSourceSet {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${extra["kotlin_version"]}")
                implementation("com.soywiz.korlibs.klock:klock-jvm:${extra["klockVersion"]}")
            }
        }
        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-junit:${extra["kotlin_version"]}")
            }
        }
    }
}

