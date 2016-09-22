# AnimalStudySnapShot
[![Build Status](https://travis-ci.org/kbyyd24/AnimalStudySnapShot.svg?branch=master)](https://travis-ci.org/kbyyd24/AnimalStudySnapShot)
===

ThoughtWorks 成都内推作业

github:[https://github.com/kbyyd24/AnimalStudySnapShot](https://github.com/kbyyd24/AnimalStudySnapShot)

### 运行方法

可以运行测试用例验证实现是否成功。使用`gradle`构建，可以用`gradle`来运行测试
```shell
gradle clean build
```

如果要使用接口，则按如下方式使用：
```
//使用默认实现的service
SnapShotable animalMap = new AnimalSnapShotImpl();
String snapShot = animalMap.getSnapShot(historyData, id);

//构造器注入service
SnapShotable animapMap = new AnimalSnapShotImpl(serializeService, mapService, searchService);
```

某一次查询后，要在相同数据中查找，可以使用
```
String snapShot = animalMap.getSnapShot(id);
```

### explanation

#### 参数约定

* `historyData`的格式如下：
```text
e4e87cb2-8e9a-4749-abb6-26c59344dfee
2016/09/02 22:30:46
cat1 10 9

351055db-33e6-4f9b-bfe1-16f1ac446ac1
2016/09/02 22:30:52
cat1 10 9 2 -1
cat2 2 3

dcfa0c7a-5855-4ed2-bc8c-4accae8bd155
2016/09/02 22:31:02
cat1 12 8 3 4
```
* 每组快照的数据之间有有且只有一个空行
* 时间格式固定
* `id`是唯一的

#### 输出说明

* 正确执行后返回动物信息的字符串，包含换行符，动物按`name`排序
* `historyData`格式有误时返回字符串**`Invalid format`**
* 相邻时刻动物位置的数据对应有误时，返回字符串**`Conflict found at ${id}`**（`id`为后一个时刻的`id`）
* `id`不在`historyData`中时返回字符串**`Not found ${id}`**
