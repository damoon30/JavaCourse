分析见 GCDetails.md
1、串行GC

串行垃圾收集器对年轻代使用标记复制算法（ mark-copy），对老年代使用标记清理压缩算法（ mark-sweep-compact ）
无法并行处理任务。这两种收集器还会触发stop-the-world暂停，停止所有应用程序线程

使用方式：-XX:+UseSerialGC

2、并行GC

在年轻代使用 标记-复制(mark-copy)算法, 在老年代使用 标记-清除-整理(mark-sweep-compact)算法。年轻代和老年代的垃圾回收都会触发STW事件,暂停所有的应用线程来执行垃圾收集。两者在执行 标记和 复制/整理阶段时都使用多个线程, 因此得名“(Parallel)”
通过命令行参数 -XX:ParallelGCThreads=NNN 来指定 GC 线程数。 其默认值为CPU内核数。

使用方式：-XX:+UseParallelGC -XX:+UseParallelOldGC

3、CMS

CMS的官方名称为 “Mostly Concurrent Mark and Sweep Garbage Collector”(主要并发-标记-清除-垃圾收集器). 
其对年轻代采用并行 STW方式的 mark-copy (标记-复制)算法, 对老年代主要使用并发 mark-sweep (标记-清除)算法。

CMS的设计目标是避免在老年代垃圾收集时出现长时间的卡顿。主要通过两种手段来达成此目标。

第一, 不对老年代进行整理, 而是使用空闲列表(free-lists)来管理内存空间的回收。  
第二, 在 mark-and-sweep (标记-清除) 阶段的大部分工作和应用线程一起并发执行。  
也就是说, 在这些阶段并没有明显的应用线程暂停。但值得注意的是, 它仍然和应用线程争抢CPU时间。默认情况下, 
CMS 使用的并发线程数等于CPU内核数的 1/4。

使用方式：-XX:+UseConcMarkSweepGC
CMSGC流程：
1、初始标记  
2、并发标记  
3、并发预清理  
4、最终标记  
5、并发清除  
6、并发重置  

4、G1

G1最主要的设计目标是: 将STW停顿的时间和分布变成可预期以及可配置的。事实上, G1是一款软实时垃圾收集器, 
也就是说可以为其设置某项特定的性能指标. 可以指定: 在任意 xx 毫秒的时间范围内, STW停顿不得超过 x 毫秒。 
如: 任意1秒暂停时间不得超过5毫秒. Garbage-First GC 会尽力达成这个目标

使用方式：-XX:+UseG1GC  

1、Evacuation Pause:young 纯年轻代模式转移暂停  
  在应用程序刚启动时, G1还未执行过(not-yet-executed)并发阶段, 也就没有获得任何额外的信息, 处于初始的 fully-young 模式. 在年轻代空间用满之后, 应用线程被暂停, 年轻代堆区中的存活对象被复制到存活区, 如果还没有存活区,则选择任意一部分空闲的小堆区用作存活区。

Concurrent Marking 并发标记  
阶段1：Initial Mark 初始标记  
    此阶段标记所有从GC root 直接可达的对象。在CMS中需要一次STW暂停, 但G1里面通常是在转移暂停的同时处理这些事情, 所以它的开销是很小的. 可以在 Evacuation Pause 日志中的第一行看到(initial-mark)暂停:  
    [GC pause (G1 Humongous Allocation) (young) (initial-mark) 621M->430M(1024M), 0.0233638 secs]  

阶段2：root-region-scan  root区扫描  
    2022-01-16T15:54:23.296-0800: [GC concurrent-root-region-scan-start]  
    2022-01-16T15:54:23.296-0800: [GC concurrent-root-region-scan-end, 0.0001669 secs]  

阶段3：Concurrent Mark 并发标记  
    2022-01-16T15:54:23.296-0800: [GC concurrent-mark-start]  
    2022-01-16T15:54:23.305-0800: [GC concurrent-mark-end, 0.0085168 secs]  

阶段4：remark 再次标记
    2022-01-16T15:54:23.305-0800: [GC remark, 0.0013040 secs]  

阶段5：cleanup
    2022-01-16T15:54:23.306-0800: [GC cleanup 501M->485M(1024M), 0.0007801 secs]

Evacuation Pause （mixed） 转移暂停：混合模式
    能并发清理老年代中整个整个的小堆区是一种最优情形, 但有时候并不是这样。并发标记完成之后, G1将执行一次混合收集(mixed collection), 不只清理年轻代, 还将一部分老年代区域也加入到 collection set 中。
    混合模式的转移暂停(Evacuation pause)不一定紧跟着并发标记阶段。有很多规则和历史数据会影响混合模式的启动时机。比如, 假若在老年代中可以并发地腾出很多的小堆区,就没有必要启动混合模式。    因此, 在并发标记与混合转移暂停之间, 很可能会存在多次 fully-young 转移暂停。




