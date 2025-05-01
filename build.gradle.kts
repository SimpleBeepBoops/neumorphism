plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    id(Plugins.COMPOSE_MULTIPLATFORM) version Versions.composeMultiplatform apply false
    id(Plugins.DOKKA) version Versions.dokka apply false
}

subprojects {
    apply(plugin = Plugins.DOKKA)
}
