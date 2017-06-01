package me.denghui.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

public class CleanTask extends DefaultTask {

    static final String NAME = "cleanUnusedRes"

    final String UNUSED_RESOURCES_ID = "UnusedResources"
    final String ISSUE_XML_TAG = "issue"

    HashSet<String> filePaths = new HashSet<>()
    StringBuilder delLog = new StringBuilder()
    StringBuilder keepLog = new StringBuilder()

    public CleanTask() {
        group = CleanUnusedResourcesPlugin.GROUP
        description = "Removes unused resources reported by the Android Plugin lint task"
    }

    @TaskAction
    def start() {
        // 1.解析lint.xml 获取无用资源文件路径
        // 2.生成删除的文件列表list
        def ext = project.extensions.findByName(CleanUnusedResourcesPlugin.EXTENSION_NAME) as PluginExtension
        println ext.toString()

        def file = new File(ext.lintXmlPath)
        if (!file.exists()) {
            println '找不到lint的xml文件，请检查路径是否正确！'
            return
        }

        // 解析xml，添加无用文件的路径到容器中
        new XmlSlurper().parse(file).'**'.findAll { node ->
            if (node.name() == ISSUE_XML_TAG && node.@id == UNUSED_RESOURCES_ID) {
                filePaths.add(node.location.@file)
            }
        }

        def num = filePaths.size()
        if (num > 0) {
            delLog.append("\n=====删除的文件=====\n")
            keepLog.append("\n=====保留的文件=====\n")
            for (String path : filePaths) {
                deleteFileByPath(path)
            }
            writeToOutput(ext.outputPath)
        } else {
            println '不存在无用资源！'
        }
    }

    def deleteFileByPath(String path) {
        if (isDelFile(path)) {
            if (new File(path).delete()) {
                delLog.append('\n\t' + path)
            } else {
                keepLog.append('\n\t删除失败：' + path)
            }
        } else {
            keepLog.append('\n\t' + path)
        }
    }

    /**
     * 只选定drawable,layout,mipmap,menu下的文件,(无用引用暂不处理)
     * "/Users/allen/AndroidStudioProjects/MyMoney/base/src/main/res/drawable-xhdpi/abc_ic_cab_done_holo_dark.png"/>
     * @param path
     */
    def isDelFile(String path) {
        def dirs = path.split(File.separator)
        def len = dirs.length
        if (len > 3) {
            String dir = dirs[len-2]
            dir.contains('drawable') || dir.contains('layout') || dir.contains('mipmap') || dir.contains('menu')
        } else {
            false
        }
    }

    def writeToOutput(def path) {
        def f = new File(path)
        if (f.exists()) {
            f.delete()
        }
        new File(path).withPrintWriter { pw ->
            pw.write(delLog.toString())
            pw.write(keepLog.toString())
        }
    }

}