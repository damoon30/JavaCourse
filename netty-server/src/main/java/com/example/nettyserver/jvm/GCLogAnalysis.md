### 并行GC

#### 不指定内存：java -XX:+PrintGCDetails GCLogAnalysis

正在执行...
[GC (Allocation Failure) [PSYoungGen: 65536K->10751K(76288K)] 65536K->18453K(251392K), 0.0086348 secs] [Times: user=0.01 sys=0.03, real=0.01 secs]

[GC (Allocation Failure) [PSYoungGen: 75975K->10736K(141824K)] 83677K->39162K(316928K), 0.0143265 secs] [Times: user=0.02 sys=0.06, real=0.01 secs]

[GC (Allocation Failure) [PSYoungGen: 141808K->10746K(141824K)] 170234K->76265K(316928K), 0.0211650 secs] [Times: user=0.03 sys=0.09, real=0.02 secs]

[GC (Allocation Failure) [PSYoungGen: 141384K->10736K(272896K)] 206902K->118790K(448000K), 0.0233992 secs] [Times: user=0.03 sys=0.11, real=0.03 secs]

[GC (Allocation Failure) [PSYoungGen: 272880K->10747K(272896K)] 380934K->202600K(465408K), 0.0387331 secs] [Times: user=0.05 sys=0.18, real=0.03 secs]

[Full GC (Ergonomics) [PSYoungGen: 10747K->0K(272896K)] [ParOldGen: 191853K->167427K(330752K)] 202600K->167427K(603648K), [Metaspace: 2743K->2743K(1056768K)], 0.0240281 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]

[GC (Allocation Failure) [PSYoungGen: 262144K->77125K(563200K)] 429571K->244553K(893952K), 0.0343345 secs] [Times: user=0.04 sys=0.16, real=0.04 secs]

[GC (Allocation Failure) [PSYoungGen: 563013K->107007K(593408K)] 730441K->350766K(924160K), 0.0805804 secs] [Times: user=0.10 sys=0.36, real=0.08 secs]

[Full GC (Ergonomics) [PSYoungGen: 107007K->0K(593408K)] [ParOldGen: 243758K->263008K(452608K)] 350766K->263008K(1046016K), [Metaspace: 2743K->2743K(1056768K)], 0.0470251 secs] [Times: user=0.19 sys=0.04, real=0.05 secs]

[GC (Allocation Failure) [PSYoungGen: 486400K->138513K(1033728K)] 749408K->401521K(1486336K), 0.0856212 secs] [Times: user=0.08 sys=0.39, real=0.09 secs]

执行结束!共生成对象次数:9363

Heap

PSYoungGen      total 1033728K, used 773017K [0x000000076ab00000, 0x00000007b6100000, 0x00000007c0000000)

eden space 869376K, 72% used [0x000000076ab00000,0x00000007916a20a0,0x000000079fc00000)

from space 164352K, 84% used [0x00000007abc00000,0x00000007b4344600,0x00000007b5c80000)

to   space 182784K, 0% used [0x000000079fc00000,0x000000079fc00000,0x00000007aae80000)

ParOldGen       total 452608K, used 263008K [0x00000006c0000000, 0x00000006dba00000, 0x000000076ab00000)

object space 452608K, 58% used [0x00000006c0000000,0x00000006d00d80d8,0x00000006dba00000)

Metaspace       used 2750K, capacity 4486K, committed 4864K, reserved 1056768K

class space    used 297K, capacity 386K, committed 512K, reserved 1048576K

总结：新生代使用1033782/1024/1024 = 0.98G, 老年代使用了0.43G, 在没有配置GC策略的时候，默认并行GC，1s内共进行了8次youngGC，2次FullGC


#### 执行堆内存1G

执行命令：java -XX:+PrintGCDetails -Xmx1G -Xms1G GCLogAnalysis

正在执行...
[GC (Allocation Failure) [PSYoungGen: 262144K->43518K(305664K)] 262144K->73733K(1005056K), 0.0318390 secs] [Times: user=0.04 sys=0.13, real=0.03 secs] 

[GC (Allocation Failure) [PSYoungGen: 305469K->43515K(305664K)] 335684K->147168K(1005056K), 0.1022156 secs] [Times: user=0.06 sys=0.15, real=0.10 secs] 

[GC (Allocation Failure) [PSYoungGen: 305659K->43516K(305664K)] 409312K->222325K(1005056K), 0.0499011 secs] [Times: user=0.08 sys=0.15, real=0.05 secs] 

[GC (Allocation Failure) [PSYoungGen: 305660K->43516K(305664K)] 484469K->296416K(1005056K), 0.0632767 secs] [Times: user=0.08 sys=0.12, real=0.07 secs] 

[GC (Allocation Failure) [PSYoungGen: 305660K->43512K(305664K)] 558560K->371672K(1005056K), 0.0578505 secs] [Times: user=0.08 sys=0.11, real=0.06 secs] 

[GC (Allocation Failure) [PSYoungGen: 305656K->43513K(160256K)] 633816K->440816K(859648K), 0.0742107 secs] [Times: user=0.07 sys=0.12, real=0.08 secs] 

[GC (Allocation Failure) [PSYoungGen: 160249K->72308K(232960K)] 557552K->475498K(932352K), 0.0158212 secs] [Times: user=0.06 sys=0.01, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 189044K->88330K(232960K)] 592234K->501432K(932352K), 0.0173762 secs] [Times: user=0.08 sys=0.02, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 205066K->100567K(232960K)] 618168K->529510K(932352K), 0.0264222 secs] [Times: user=0.10 sys=0.03, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 217303K->76506K(232960K)] 646246K->559038K(932352K), 0.0351296 secs] [Times: user=0.07 sys=0.11, real=0.03 secs] 

[GC (Allocation Failure) [PSYoungGen: 193242K->40040K(232960K)] 675774K->590880K(932352K), 0.0716803 secs] [Times: user=0.05 sys=0.12, real=0.07 secs] 

执行结束!共生成对象次数:8049

Heap

PSYoungGen      total 232960K, used 45320K [0x00000007aab00000, 0x00000007c0000000, 0x00000007c0000000)

eden space 116736K, 4% used [0x00000007aab00000,0x00000007ab028140,0x00000007b1d00000)  
 from space 116224K, 34% used [0x00000007b1d00000,0x00000007b441a110,0x00000007b8e80000)  
 to   space 116224K, 0% used [0x00000007b8e80000,0x00000007b8e80000,0x00000007c0000000)  
 ParOldGen       total 699392K, used 550840K [0x0000000780000000, 0x00000007aab00000, 0x00000007aab00000)  
object space 699392K, 78% used [0x0000000780000000,0x00000007a19ee220,0x00000007aab00000)  
Metaspace       used 2750K, capacity 4486K, committed 4864K, reserved 1056768K  
class space    used 297K, capacity 386K, committed 512K, reserved 1048576K  

总结：在分配了堆内存1G后，1s内创建对象8099次，老年代的内存为699392/1024/1024 = 0.66G, 新生代内存0.22G，产生了11次youngGC

#### 打印时间戳
-XX:+PrintGCDateStamps  
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1G -Xms1G GCLogAnalysis  
2022-01-16T15:23:06.236-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43517K(305664K)] 262144K->76227K(1005056K), 0.0342707 secs] [Times: user=0.04 sys=0.16, real=0.04 secs]  
young区降低了262144-43517=218627，整个堆内存降低了262144-76227=185917，那么有218627-185917 = 32710k 从young区晋升到了old区
2022-01-16T15:23:06.313-0800: [GC (Allocation Failure) [PSYoungGen: 305661K->43508K(305664K)] 338371K->155604K(1005056K), 0.0576949 secs] [Times: user=0.05 sys=0.26, real=0.06 secs]  


#### 使用串行
* java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1G -Xms1G -XX:+UseSerialGC GCLogAnalysis

正在执行...
2022-01-16T15:32:16.208-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.208-0800: [DefNew: 279616K->34944K(314560K), 0.0581483 secs] 279616K->82781K(1013632K), 0.0582466 secs] [Times: user=0.03 sys=0.02, real=0.06 secs]  
2022-01-16T15:32:16.321-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.321-0800: [DefNew: 314560K->34943K(314560K), 0.0718148 secs] 362397K->164018K(1013632K), 0.0718495 secs] [Times: user=0.04 sys=0.03, real=0.07 secs]  
2022-01-16T15:32:16.429-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.430-0800: [DefNew: 314559K->34942K(314560K), 0.0666862 secs] 443634K->247421K(1013632K), 0.0667258 secs] [Times: user=0.04 sys=0.03, real=0.07 secs]  
2022-01-16T15:32:16.531-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.531-0800: [DefNew: 314558K->34944K(314560K), 0.0579078 secs] 527037K->330969K(1013632K), 0.0579450 secs] [Times: user=0.04 sys=0.02, real=0.05 secs]  
2022-01-16T15:32:16.626-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.626-0800: [DefNew: 314560K->34943K(314560K), 0.0563014 secs] 610585K->414007K(1013632K), 0.0563389 secs] [Times: user=0.04 sys=0.02, real=0.06 secs]  
2022-01-16T15:32:16.719-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.719-0800: [DefNew: 314559K->34943K(314560K), 0.0508566 secs] 693623K->484094K(1013632K), 0.0508932 secs] [Times: user=0.03 sys=0.02, real=0.06 secs]  
2022-01-16T15:32:16.805-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.805-0800: [DefNew: 314559K->34943K(314560K), 0.0595744 secs] 763710K->563316K(1013632K), 0.0596124 secs] [Times: user=0.03 sys=0.03, real=0.06 secs]  
2022-01-16T15:32:16.904-0800: [GC (Allocation Failure) 2022-01-16T15:32:16.904-0800: [DefNew: 314559K->34943K(314560K), 0.0541024 secs] 842932K->634882K(1013632K), 0.0541362 secs] [Times: user=0.03 sys=0.02, real=0.05 secs]  
2022-01-16T15:32:17.003-0800: [GC (Allocation Failure) 2022-01-16T15:32:17.003-0800: [DefNew: 314296K->34943K(314560K), 0.0580533 secs] 914234K->712910K(1013632K), 0.0580909 secs] [Times: user=0.03 sys=0.02, real=0.06 secs]  
执行结束!共生成对象次数:9377  
Heap  
def new generation   total 314560K, used 46343K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)  
eden space 279616K,   4% used [0x0000000780000000, 0x0000000780b21f28, 0x0000000791110000)  
from space 34944K,  99% used [0x0000000793330000, 0x000000079554fed8, 0x0000000795550000)  
to   space 34944K,   0% used [0x0000000791110000, 0x0000000791110000, 0x0000000793330000)  
tenured generation   total 699072K, used 677966K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)  
the space 699072K,  96% used [0x0000000795550000, 0x00000007beb639f8, 0x00000007beb63a00, 0x00000007c0000000)  
Metaspace       used 2750K, capacity 4486K, committed 4864K, reserved 1056768K  
class space    used 297K, capacity 386K, committed 512K, reserved 1048576K  

* 采用4G：java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx4G -Xms4G -XX:+UseSerialGC GCLogAnalysis 

正在执行...  
2022-01-16T15:35:24.974-0800: [GC (Allocation Failure) 2022-01-16T15:35:24.974-0800: [DefNew: 1118528K->139776K(1258304K), 0.1755793 secs] 1118528K->235738K(4054528K), 0.1756736 secs] [Times: user=0.10 sys=0.07, real=0.17 secs]  
2022-01-16T15:35:25.344-0800: [GC (Allocation Failure) 2022-01-16T15:35:25.344-0800: [DefNew: 1258304K->139776K(1258304K), 0.2461728 secs] 1354266K->385250K(4054528K), 0.2462109 secs] [Times: user=0.10 sys=0.09, real=0.25 secs]  
执行结束!共生成对象次数:8445    
Heap  
def new generation   total 1258304K, used 184831K [0x00000006c0000000, 0x0000000715550000, 0x0000000715550000)  
eden space 1118528K,   4% used [0x00000006c0000000, 0x00000006c2bffc30, 0x0000000704450000)  
from space 139776K, 100% used [0x0000000704450000, 0x000000070ccd0000, 0x000000070ccd0000)  
to   space 139776K,   0% used [0x000000070ccd0000, 0x000000070ccd0000, 0x0000000715550000)  
tenured generation   total 2796224K, used 245474K [0x0000000715550000, 0x00000007c0000000, 0x00000007c0000000)  
the space 2796224K,   8% used [0x0000000715550000, 0x00000007245088d8, 0x0000000724508a00, 0x00000007c0000000)  
Metaspace       used 2750K, capacity 4486K, committed 4864K, reserved 1056768K  
class space    used 297K, capacity 386K, committed 512K, reserved 1048576K  

总结：在4G内存下，并行GC垃圾回收时间次数变少，但是GC时间增加，


#### 使用CMS
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1G -Xms1G -XX:+UseConcMarkSweepGC GCLogAnalysis 

正在执行...  
2022-01-16T15:40:22.938-0800: [GC (Allocation Failure) 2022-01-16T15:40:22.944-0800: [ParNew: 279616K->34944K(314560K), 0.0421332 secs] 279616K->89520K(1013632K), 0.0476646 secs] [Times: user=0.06 sys=0.19, real=0.05 secs]  
2022-01-16T15:40:23.030-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.030-0800: [ParNew: 314560K->34943K(314560K), 0.0403431 secs] 369136K->160667K(1013632K), 0.0403853 secs] [Times: user=0.07 sys=0.17, real=0.04 secs]  
2022-01-16T15:40:23.119-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.120-0800: [ParNew: 314559K->34941K(314560K), 0.0627843 secs] 440283K->239062K(1013632K), 0.0628538 secs] [Times: user=0.29 sys=0.04, real=0.07 secs]  
2022-01-16T15:40:23.221-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.221-0800: [ParNew: 314557K->34944K(314560K), 0.0522388 secs] 518678K->328508K(1013632K), 0.0522765 secs] [Times: user=0.30 sys=0.05, real=0.05 secs]  
2022-01-16T15:40:23.310-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.310-0800: [ParNew: 314560K->34942K(314560K), 0.0434526 secs] 608124K->407903K(1013632K), 0.0434914 secs] [Times: user=0.26 sys=0.04, real=0.04 secs]  
2022-01-16T15:40:23.359-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 372960K(699072K)] 450974K(1013632K), 0.0004399 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]  
2022-01-16T15:40:23.359-0800: [CMS-concurrent-mark-start]  
2022-01-16T15:40:23.363-0800: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]  
2022-01-16T15:40:23.363-0800: [CMS-concurrent-preclean-start]  
2022-01-16T15:40:23.365-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]  
2022-01-16T15:40:23.365-0800: [CMS-concurrent-abortable-preclean-start]  
2022-01-16T15:40:23.391-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.391-0800: [ParNew: 314558K->34942K(314560K), 0.0494377 secs] 687519K->495201K(1013632K), 0.0494736 secs] [Times: user=0.33 sys=0.04, real=0.05 secs]  
2022-01-16T15:40:23.474-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.474-0800: [ParNew: 314558K->34943K(314560K), 0.0454925 secs] 774817K->578432K(1013632K), 0.0455310 secs] [Times: user=0.30 sys=0.04, real=0.05 secs]  
2022-01-16T15:40:23.555-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.555-0800: [ParNew: 314559K->34942K(314560K), 0.0501556 secs] 858048K->660974K(1013632K), 0.0501959 secs] [Times: user=0.30 sys=0.05, real=0.05 secs]  
2022-01-16T15:40:23.640-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.640-0800: [ParNew: 314558K->314558K(314560K), 0.0000173 secs]2022-01-16T15:40:23.640-0800: [CMS2022-01-16T15:40:23.641-0800: [CMS-concurrent-abortable-preclean: 0.009/0.276 secs] [Times: user=1.05 sys=0.13, real=0.28 secs]
(concurrent mode failure): 626031K->343940K(699072K), 0.0682720 secs] 940590K->343940K(1013632K), [Metaspace: 2743K->2743K(1056768K)], 0.0683828 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]  
2022-01-16T15:40:23.754-0800: [GC (Allocation Failure) 2022-01-16T15:40:23.754-0800: [ParNew: 279616K->34943K(314560K), 0.0127247 secs] 623556K->435614K(1013632K), 0.0128170 secs] [Times: user=0.09 sys=0.00, real=0.01 secs]  
2022-01-16T15:40:23.767-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 400671K(699072K)] 435975K(1013632K), 0.0001577 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]  
2022-01-16T15:40:23.767-0800: [CMS-concurrent-mark-start]  
2022-01-16T15:40:23.768-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]  
2022-01-16T15:40:23.768-0800: [CMS-concurrent-preclean-start]  
2022-01-16T15:40:23.770-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]  
2022-01-16T15:40:23.770-0800: [CMS-concurrent-abortable-preclean-start]  
执行结束!共生成对象次数:10889  
Heap  
par new generation   total 314560K, used 135670K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)  
eden space 279616K,  36% used [0x0000000780000000, 0x000000078625dc28, 0x0000000791110000)  
from space 34944K,  99% used [0x0000000793330000, 0x000000079554feb8, 0x0000000795550000)  
to   space 34944K,   0% used [0x0000000791110000, 0x0000000791110000, 0x0000000793330000)  
concurrent mark-sweep generation total 699072K, used 400671K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)  
Metaspace       used 2750K, capacity 4486K, committed 4864K, reserved 1056768K  
class space    used 297K, capacity 386K, committed 512K, reserved 1048576K  

CMS流程：
初始标记
并发标记
并发预清理
最终标记
并发清除
并发重置

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx4G -Xms4G -XX:+UseConcMarkSweepGC GCLogAnalysis  

正在执行...  
2022-01-16T15:42:35.830-0800: [GC (Allocation Failure) 2022-01-16T15:42:35.830-0800: [ParNew: 544837K->68096K(613440K), 0.0695532 secs] 544837K->142917K(4126208K), 0.0696252 secs] [Times: user=0.11 sys=0.26, real=0.07 secs]  
2022-01-16T15:42:35.994-0800: [GC (Allocation Failure) 2022-01-16T15:42:35.994-0800: [ParNew: 613440K->68096K(613440K), 0.0680694 secs] 688261K->255988K(4126208K), 0.0681062 secs] [Times: user=0.14 sys=0.27, real=0.07 secs]  
2022-01-16T15:42:36.132-0800: [GC (Allocation Failure) 2022-01-16T15:42:36.132-0800: [ParNew: 613440K->68094K(613440K), 0.0931656 secs] 801332K->387990K(4126208K), 0.0932044 secs] [Times: user=0.58 sys=0.05, real=0.09 secs]  
2022-01-16T15:42:36.297-0800: [GC (Allocation Failure) 2022-01-16T15:42:36.298-0800: [ParNew: 613438K->68096K(613440K), 0.0824933 secs] 933334K->509676K(4126208K), 0.0825313 secs] [Times: user=0.55 sys=0.05, real=0.09 secs]  
2022-01-16T15:42:36.447-0800: [GC (Allocation Failure) 2022-01-16T15:42:36.447-0800: [ParNew: 613440K->68096K(613440K), 0.0858109 secs] 1055020K->638459K(4126208K), 0.0858496 secs] [Times: user=0.58 sys=0.05, real=0.09 secs]  
执行结束!共生成对象次数:10334  
Heap  
par new generation   total 613440K, used 89870K [0x00000006c0000000, 0x00000006e9990000, 0x00000006e9990000)  
eden space 545344K,   3% used [0x00000006c0000000, 0x00000006c15439c0, 0x00000006e1490000)  
from space 68096K, 100% used [0x00000006e5710000, 0x00000006e9990000, 0x00000006e9990000)  
to   space 68096K,   0% used [0x00000006e1490000, 0x00000006e1490000, 0x00000006e5710000)  
concurrent mark-sweep generation total 3512768K, used 570363K [0x00000006e9990000, 0x00000007c0000000, 0x00000007c0000000)  
Metaspace       used 2750K, capacity 4486K, committed 4864K, reserved 1056768K  
class space    used 297K, capacity 386K, committed 512K, reserved 1048576K  

总结：CMS垃圾收集器（parNew+CMS），内存为1G的情况下，1s内生成对象10889次，产生了10次youngGC，2次fullGC；内存为4G的情况下，只产生了4次youngGC，无fullGC

#### 使用G1
java -XX:+PrintGC -XX:+PrintGCDateStamps -Xmx4G -Xms4G -XX:+UseG1GC GCLogAnalysis 

java -XX:+PrintGC -XX:+PrintGCDateStamps -Xmx4G -Xms4G -XX:+UseG1GC GCLogAnalysis
正在执行...
2022-01-16T15:53:23.476-0800: [GC pause (G1 Evacuation Pause) (young) 204M->71M(4096M), 0.0358991 secs]  
2022-01-16T15:53:23.541-0800: [GC pause (G1 Evacuation Pause) (young) 249M->132M(4096M), 0.0259433 secs]  
2022-01-16T15:53:23.595-0800: [GC pause (G1 Evacuation Pause) (young) 310M->191M(4096M), 0.0317695 secs]  
2022-01-16T15:53:23.651-0800: [GC pause (G1 Evacuation Pause) (young) 369M->253M(4096M), 0.0310887 secs]  
2022-01-16T15:53:23.714-0800: [GC pause (G1 Evacuation Pause) (young) 431M->311M(4096M), 0.0301431 secs]  
2022-01-16T15:53:23.776-0800: [GC pause (G1 Evacuation Pause) (young) 489M->374M(4096M), 0.0309514 secs]  
2022-01-16T15:53:23.830-0800: [GC pause (G1 Evacuation Pause) (young) 552M->429M(4096M), 0.0275091 secs]  
2022-01-16T15:53:23.881-0800: [GC pause (G1 Evacuation Pause) (young) 611M->484M(4096M), 0.0273345 secs]  
2022-01-16T15:53:23.956-0800: [GC pause (G1 Evacuation Pause) (young) 734M->566M(4096M), 0.0373735 secs]  
2022-01-16T15:53:24.027-0800: [GC pause (G1 Evacuation Pause) (young) 822M->644M(4096M), 0.0355975 secs]  
2022-01-16T15:53:24.102-0800: [GC pause (G1 Evacuation Pause) (young) 928M->729M(4096M), 0.0378480 secs]  
2022-01-16T15:53:24.213-0800: [GC pause (G1 Evacuation Pause) (young) 1105M->829M(4096M), 0.0588381 secs]  
2022-01-16T15:53:24.329-0800: [GC pause (G1 Evacuation Pause) (young) 1227M->932M(4096M), 0.0474000 secs]  
执行结束!共生成对象次数:11008


java -XX:+PrintGC -XX:+PrintGCDateStamps -Xmx1G -Xms1G -XX:+UseG1GC GCLogAnalysis
正在执行...
2022-01-16T15:54:22.743-0800: [GC pause (G1 Evacuation Pause) (young) 66M->23M(1024M), 0.0088159 secs]
2022-01-16T15:54:22.767-0800: [GC pause (G1 Evacuation Pause) (young) 72M->37M(1024M), 0.0093281 secs]
2022-01-16T15:54:22.791-0800: [GC pause (G1 Evacuation Pause) (young) 93M->56M(1024M), 0.0072500 secs]
2022-01-16T15:54:22.837-0800: [GC pause (G1 Evacuation Pause) (young) 148M->87M(1024M), 0.0125485 secs]
2022-01-16T15:54:22.868-0800: [GC pause (G1 Evacuation Pause) (young) 181M->117M(1024M), 0.0152986 secs]
2022-01-16T15:54:22.915-0800: [GC pause (G1 Evacuation Pause) (young) 243M->155M(1024M), 0.0156547 secs]
2022-01-16T15:54:22.980-0800: [GC pause (G1 Evacuation Pause) (young) 329M->200M(1024M), 0.0187473 secs]
2022-01-16T15:54:23.048-0800: [GC pause (G1 Evacuation Pause) (young) 419M->261M(1024M), 0.0251155 secs]
2022-01-16T15:54:23.119-0800: [GC pause (G1 Evacuation Pause) (young) 492M->320M(1024M), 0.0298579 secs]
2022-01-16T15:54:23.209-0800: [GC pause (G1 Evacuation Pause) (young) 581M->377M(1024M), 0.0304623 secs]
2022-01-16T15:54:23.272-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 621M->430M(1024M), 0.0233638 secs]
2022-01-16T15:54:23.296-0800: [GC concurrent-root-region-scan-start]
2022-01-16T15:54:23.296-0800: [GC concurrent-root-region-scan-end, 0.0001669 secs]
2022-01-16T15:54:23.296-0800: [GC concurrent-mark-start]
2022-01-16T15:54:23.305-0800: [GC concurrent-mark-end, 0.0085168 secs]
2022-01-16T15:54:23.305-0800: [GC remark, 0.0013040 secs]
2022-01-16T15:54:23.306-0800: [GC cleanup 501M->485M(1024M), 0.0007801 secs]
2022-01-16T15:54:23.307-0800: [GC concurrent-cleanup-start]
2022-01-16T15:54:23.307-0800: [GC concurrent-cleanup-end, 0.0000383 secs]
2022-01-16T15:54:23.360-0800: [GC pause (G1 Evacuation Pause) (young) 734M->489M(1024M), 0.0326187 secs]
2022-01-16T15:54:23.395-0800: [GC pause (G1 Evacuation Pause) (mixed) 508M->404M(1024M), 0.0092134 secs]
2022-01-16T15:54:23.415-0800: [GC pause (G1 Evacuation Pause) (mixed) 469M->416M(1024M), 0.0031794 secs]
2022-01-16T15:54:23.418-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 416M->416M(1024M), 0.0020925 secs]
2022-01-16T15:54:23.420-0800: [GC concurrent-root-region-scan-start]
2022-01-16T15:54:23.420-0800: [GC concurrent-root-region-scan-end, 0.0001339 secs]
2022-01-16T15:54:23.420-0800: [GC concurrent-mark-start]
2022-01-16T15:54:23.422-0800: [GC concurrent-mark-end, 0.0012828 secs]
2022-01-16T15:54:23.422-0800: [GC remark, 0.0021864 secs]
2022-01-16T15:54:23.424-0800: [GC cleanup 428M->424M(1024M), 0.0007799 secs]
2022-01-16T15:54:23.425-0800: [GC concurrent-cleanup-start]
2022-01-16T15:54:23.425-0800: [GC concurrent-cleanup-end, 0.0000148 secs]
2022-01-16T15:54:23.533-0800: [GC pause (G1 Evacuation Pause) (young)-- 894M->707M(1024M), 0.0095272 secs]
2022-01-16T15:54:23.547-0800: [GC pause (G1 Evacuation Pause) (mixed) 745M->654M(1024M), 0.0070417 secs]
2022-01-16T15:54:23.554-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 655M->654M(1024M), 0.0026995 secs]
2022-01-16T15:54:23.557-0800: [GC concurrent-root-region-scan-start]
2022-01-16T15:54:23.557-0800: [GC concurrent-root-region-scan-end, 0.0001850 secs]
2022-01-16T15:54:23.557-0800: [GC concurrent-mark-start]
2022-01-16T15:54:23.560-0800: [GC concurrent-mark-end, 0.0023525 secs]
2022-01-16T15:54:23.560-0800: [GC remark, 0.0016487 secs]
2022-01-16T15:54:23.562-0800: [GC cleanup 664M->649M(1024M), 0.0009002 secs]
2022-01-16T15:54:23.563-0800: [GC concurrent-cleanup-start]
2022-01-16T15:54:23.563-0800: [GC concurrent-cleanup-end, 0.0000271 secs]
2022-01-16T15:54:23.598-0800: [GC pause (G1 Evacuation Pause) (young) 838M->679M(1024M), 0.0064690 secs]
2022-01-16T15:54:23.610-0800: [GC pause (G1 Evacuation Pause) (mixed) 710M->590M(1024M), 0.0050397 secs]
2022-01-16T15:54:23.624-0800: [GC pause (G1 Evacuation Pause) (mixed) 650M->523M(1024M), 0.0079215 secs]
2022-01-16T15:54:23.643-0800: [GC pause (G1 Evacuation Pause) (mixed) 584M->469M(1024M), 0.0072027 secs]
2022-01-16T15:54:23.661-0800: [GC pause (G1 Evacuation Pause) (mixed) 523M->455M(1024M), 0.0073124 secs]
2022-01-16T15:54:23.668-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 457M->455M(1024M), 0.0019863 secs]
2022-01-16T15:54:23.670-0800: [GC concurrent-root-region-scan-start]
2022-01-16T15:54:23.671-0800: [GC concurrent-root-region-scan-end, 0.0001579 secs]
2022-01-16T15:54:23.671-0800: [GC concurrent-mark-start]
2022-01-16T15:54:23.672-0800: [GC concurrent-mark-end, 0.0018550 secs]
2022-01-16T15:54:23.673-0800: [GC remark, 0.0025187 secs]
2022-01-16T15:54:23.675-0800: [GC cleanup 465M->462M(1024M), 0.0010066 secs]
2022-01-16T15:54:23.676-0800: [GC concurrent-cleanup-start]
2022-01-16T15:54:23.676-0800: [GC concurrent-cleanup-end, 0.0000235 secs]
执行结束!共生成对象次数:10948

Evacuation Pause:young 纯年轻代模式转移暂停
Concurrent Marking 并发标记
阶段1：Initial Mark 初始标记
阶段2：root-region-scan  root区扫描
阶段3：Concurrent Mark 并发标记
阶段4：remark 再次标记
阶段5：cleanup
Evacuation Pause （mixed） 转移暂停：混合模式
Full GC Allocation Failure


总结：GCEasy工具，堆内存在