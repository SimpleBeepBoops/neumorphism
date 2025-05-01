plugins {
    id("com.android.library")
    id(Plugins.NEU_MULTIPLATFORM)
    id(Plugins.COMPOSE_MULTIPLATFORM)
    id(Plugins.DOKKA)
    `maven-publish`
}

kotlin.sourceSets {
    named("commonMain") {
        dependencies {
            implementation(project(Modules.EFFECT))
            implementation(compose.dependencies.ui)
            implementation(compose.dependencies.material)
            implementation(compose.dependencies.materialIconsExtended)
            implementation(compose.dependencies.animation)
            implementation(compose.dependencies.animationGraphics)
            implementation(Dependencies.ComposeMultiplatform.colorMath)
        }
    }
}

android {
    namespace = location(Modules.COMPONENTS)
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = AppConfig.Maven.groupId
            artifactId = AppConfig.Maven.artifactId
            version = AppConfig.Maven.version
            
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
