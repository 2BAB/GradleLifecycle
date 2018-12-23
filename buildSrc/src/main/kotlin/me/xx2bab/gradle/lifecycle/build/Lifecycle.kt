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
        Lifecycle.println("[onEvaluatingSettingsScript] >>> $message")
    }

    fun onSettingsEvaluated(message: String) {
        Lifecycle.println("[onSettingsEvaluated] >>> $message")
    }

    fun onProjectsLoaded(message: String) {
        Lifecycle.println("[onProjectsLoaded] >>> $message")
    }

    fun beforeProject(message: String) {
        Lifecycle.println("[beforeProject] >>> $message")
    }

    fun beforeEvaluate(message: String) {
        Lifecycle.println("[beforeEvaluate] >>> $message")
    }

    fun onEvaluatingProjectWithinBuildScript(message: String) {
        Lifecycle.println("[onEvaluatingProjectWithinBuildScript] >>> $message")
    }

    fun afterProject(message: String) {
        Lifecycle.println("[afterProject] >>> $message")
    }

    fun afterEvaluate(message: String) {
        Lifecycle.println("[afterEvaluate] >>> $message")
    }

    fun onProjectsEvaluated(message: String) {
        Lifecycle.println("[onProjectsEvaluated] >>> $message")
    }

    fun whenTaskAdded(message: String) {
        Lifecycle.println("[whenTaskAdded] >>> $message")
    }

    fun whenTaskGraphIsReady(message: String) {
        Lifecycle.println("[whenTaskGraphIsReady] >>> $message")
    }

    fun beforeTask(message: String) {
        Lifecycle.println("[beforeTask] >>> $message")
    }

    fun beforeAction(message: String) {
        Lifecycle.println("[beforeAction] >>> $message")
    }

    fun afterAction(message: String) {
        Lifecycle.println("[afterAction] >>> $message")
    }

    fun afterTask(message: String) {
        Lifecycle.println("[afterTask] >>> $message")
    }

    fun onBuildFinished(message: String) {
        Lifecycle.println("[onBuildFinished] >>> $message")
    }

}