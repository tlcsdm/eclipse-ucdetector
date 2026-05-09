# UCDetector

UCDetector（不必要的代码检测器 - 发音为“You See Detector”）是一个 eclipse 插件工具，用于查找不必要的（死的）公共 Java 代码。例如，没有引用的公共类、方法或字段。UCDetector 为以下问题创建标记，这些问题出现在 eclipse 问题视图中：
* 不必要的（死的）代码
* 可见性可以更改为受保护、默认或私有的代码
* 方法或字段，可以是 final

请访问 UCDetector 网站获取更多屏幕截图和其他信息：http://www.ucdetector.org/index.html

# 如何安装

**Update Site:**

在 Eclipse 中创建一个新的更新站点，内容如下：

* Site name:  ``Tlcsdm UCDetector``
* Site URL:   ``https://raw.githubusercontent.com/tlcsdm/eclipse-ucdetector/update_site/``

**手动安装：**

下载插件 jar 并将其复制到 Eclipse 插件目录。jar 位置为（替换 ``<version>``）：
``https://raw.githubusercontent.com/tlcsdm/eclipse-ucdetector/update_site/plugins/com.tlcsdm.eclipse.ucdetector_<version>.jar``。或者，您可以下载上面发布链接中捆绑的所有其他内容的整个更新站点，并在 Eclipse 中创建一个新的更新站点，指向您展开发布的本地目录。
