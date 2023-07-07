// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra.apply {
        set("hilt_version", "2.44.2")
        set("splash_version", "1.0.1")
        set("roomdb_version", "2.5.2")
        set("datastore_version", "1.0.0")
        set("viewmodel_compose_version", "2.6.1")
        set("navigation_compose_version", "2.6.0")
        set("navigation_compose_version", "1.0.0")
    }
}

plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id("com.google.dagger.hilt.android") version "2.44.2" apply false
}