# AnimalStudySnapShot

ThoughtWorks 成都内推作业

### 运行方法

可以运行测试用例验证实现是否成功。

如果要使用接口，则按如下方式使用：
```java
SnapShot animalMap = new AnimalSnapShot();
String snapShot = animalMap.getSnapShot(historyData, id);
```

### 项目接口设计

提供一个接口，提供一个方法
```java
public interface SnapShot {
  String getSnapShot(String historyData, String id);
}
```
提供一个实现类`AnimalSnapShot`，把这个方法作为`API`发布