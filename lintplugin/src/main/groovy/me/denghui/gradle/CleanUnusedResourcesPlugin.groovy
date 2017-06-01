package me.denghui.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class CleanUnusedResourcesPlugin implements Plugin<Project> {
    static final String GROUP = 'LintCleaner'
    static final String EXTENSION_NAME = 'lintCleaner'

    @Override
    void apply(Project project) {

        project.extensions.create(EXTENSION_NAME, PluginExtension, project)

        project.tasks.create(CleanTask.NAME, CleanTask) {
            println 'load done!'
        }
    }
}