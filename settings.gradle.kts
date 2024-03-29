pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "MyDiaryApp"
include(":app")
include(":common:ui")
include(":common:util")
include(":data:mongo")
include(":feature:auth")
include(":feature:home")
include(":feature:write")
