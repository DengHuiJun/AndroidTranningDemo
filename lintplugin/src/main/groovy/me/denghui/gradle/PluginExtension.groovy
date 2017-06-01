package me.denghui.gradle

import org.gradle.api.Project

public class PluginExtension {
    // filter:   /values/colors.xml
    // 一定删除的： .png .webp .jpg

    String lintXmlPath
    String outputPath

    public PluginExtension(Project project) {
        lintXmlPath = "$project.buildDir/reports/lint-results.xml"
        outputPath = "$project.buildDir/reports/lintCleanerLog.txt"
    }

    @Override
    String toString() {
        return "配置项:\n\tlintXmlPath:" + lintXmlPath + "\n" +
                "outputPath:" + outputPath + "\n"
    }
}