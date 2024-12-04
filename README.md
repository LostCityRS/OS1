## Instructions

Install Java 8, run a compatible server on port 40000/50000, then `gradle run` and go!

## Contributor notes

* Their obfuscation process inlined some functions, we can identify and restore them *carefully* but keep in mind if the deob process is re-ran, it won't capture that work.
* My deobfuscator currently doesn't rename method args or local variables, so the deob map only records classes, methods, and fields. Same applies as above. I don't plan on re-running it any time soon so I suggest naming variables!
* The deobfuscation process may *overly* split variables so if you see.
```java
int var1 = 0;
int var2 = var1 + 1;
```
Please simplify to `var1 += 1;` or `var1++;`. Keep both lines as separate declarations since there was some intent behind it.
* String building is an egregious offender too. Try to make them coherent if you see a mess.
* Don't move any fields or methods. Everything is in the correct place.
* Exception messages were stripped out (where you see `new RuntimeException("")`) but we have other references to be able to restore them.
* Prefer official naming, but any name is better than none, as long as it's accurate.
* Document document document! If you get the urge to make something understandable with comments, go for it. People after us will love to learn about the engine.
