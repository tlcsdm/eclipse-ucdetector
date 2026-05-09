# UCDetector

UCDetector（不必要的代码检测器 - 发音为“You See Detector”）是一个 eclipse 插件工具，用于查找不必要的（死的）公共 Java 代码。例如，没有引用的公共类、方法或字段。UCDetector 为以下问题创建标记，这些问题出现在 eclipse 问题视图中：
* 不必要的（死的）代码
* 可见性可以更改为受保护、默认或私有的代码
* 方法或字段，可以是 final

请访问 UCDetector 网站获取更多屏幕截图和其他信息：http://www.ucdetector.org/index.html

本项目 fork 自 SourceForge 上的原始 [UCDetector](https://sourceforge.net/projects/ucdetector/) 项目，本仓库中的 `ucdetector` 分支保留了 fork 时的上游代码。

## 使用方式

1. 在 Eclipse 中通过更新站点安装 UCDetector。
2. 在 *Package Explorer* 中右键点击 Java 项目、包、类或 working set，选择 **UCDetector**。
3. 在子菜单中选择 **Detect unnecessary code**、**Clean UCDetector markers** 或 **Count references** 等动作。
4. 在 Eclipse *Problems* 视图中查看 UCDetector 生成的标记，必要时使用 Quick Fix（`Ctrl+1`）。
5. 可在 **Window > Preferences > UCDetector** 中调整检测模式与过滤规则。

插件内置帮助可通过 Eclipse 的 **Help > Help Contents > UCDetector** 打开。

## 模块说明

* `plugins/com.tlcsdm.eclipse.ucdetector` - UCDetector 主插件。
* `plugins/com.tlcsdm.eclipse.ucdetector.additional` - 演示如何在 UCDetector 之上开发自定义检测器（detector）的示例插件，可作为编写自定义检测规则、标记、动作和 Quick Fix 的模板。

## 如何安装

**Update Site:**

在 Eclipse 中创建一个新的更新站点，内容如下：

* Site name:  ``Tlcsdm UCDetector``
* Site URL:   ``https://raw.githubusercontent.com/tlcsdm/eclipse-ucdetector/update_site/``

**手动安装：**

下载插件 jar 并将其复制到 Eclipse 插件目录。jar 位置为（替换 ``<version>``）：
``https://raw.githubusercontent.com/tlcsdm/eclipse-ucdetector/update_site/plugins/com.tlcsdm.eclipse.ucdetector_<version>.jar``。或者，您可以下载上面发布链接中捆绑的所有其他内容的整个更新站点，并在 Eclipse 中创建一个新的更新站点，指向您展开发布的本地目录。

## 历史变更

历史变更日志请参见仓库根目录下的 [`CHANGELOG.md`](CHANGELOG.md)。仓库根目录下的 `launches/` 文件夹提供了用于在 Eclipse 中运行/调试 UCDetector 的启动配置。

## 许可证

本项目使用 [Eclipse Public License 2.0](LICENSE) 发布。
