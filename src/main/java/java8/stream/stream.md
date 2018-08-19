# stream api

## 特点
1. 不是数组
2. 不支持索引访问
3. 延迟计算
4. 支持并行
5. 支持过滤聚合等

## 中间操作

过滤 filter
去重 distinct
排序 Sorted
截取 1imit、 skip
转换 map/flatMap
其他 peek
## 终止操作
循环forEaCh
计算min、max、 count、 average
匹配 anyMatch、allMatch、 noneMatch、 findFirst、 findAny
汇聚 reduce
收集器 toArray collect

