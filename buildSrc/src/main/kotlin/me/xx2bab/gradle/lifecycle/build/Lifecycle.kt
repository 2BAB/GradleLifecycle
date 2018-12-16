package me.xx2bab.gradle.lifecycle.build

object Lifecycle {

    fun println(text: String) {
        kotlin.io.println("[Lifecycle] >>> $text")
    }

    fun onBuildStarted() {
        throw IllegalAccessException("Can not trigger this hook" +
                "since it only works in Gradle Framework inside.")
    }

    fun onEvaluatingInitScript() {
        throw IllegalAccessException("Can not trigger this hook" +
                "since init.gradle didn't depend on buildSrc.")
    }

    fun onEvaluatingSettingsScript(message: String) {
        Lifecycle.println("[settings.gradle.kts] >>> $message")
    }

    fun onSettingsEvaluated() {

    }

    fun onProjectsLoaded() {

    }

    fun beforeProject() {

    }

    fun beforeEvaluate() {

    }

    fun onEvaluatingProjectWithinBuildScript() {

    }

    fun afterProject() {

    }

    fun afterEvaluate() {

    }

    fun onProjectsEvaluated() {

    }

    fun whenTaskAdded() {

    }

    fun whenTaskGraphIsReady() {

    }

    fun beforeTask() {

    }

    fun beforeAction() {

    }

    fun afterAction() {

    }

    fun afterTask() {

    }

    fun onBuildFinished() {

    }

}