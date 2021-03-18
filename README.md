# ditch-framework
a simple java gui framework, element oriented, targeted to beginners who wants to see a window, not command prompt.

## concept
when i was in the shower earlier, i thought to myself,

"*why the hell* are java gui libraries confusing?"

i've been getting into c#, and stumbled upon **osu-framework** which is some sort of holy creation that osu devs use for their own game, *osu*.  so now, ive been thinking to myself, why doesn't java have libraries like these(~~exclude the fact that this is an old, slower, backend language~~)?  thus born, **ditch-framework**, a simple gui library targetted to beginner java programmers, who don't want to see that command prompt thingy, but also don't want to learn how to (*gasp*) do javafx or some funky stuff like that.

## paradigm
this project aims to maintain two types of paradigms, at once, so people aren't forced to use what the developer prefers.  i have absolutely no clue what the names of said paradigms are, however i'm going to explain it below:
* bloated parameter based information-travel
* minimal objects

essentially, if you have no clue what i've said, (dont worry, im pretty sure i dont too,) heres a quick example.

**bloated parameter**
```java
public static void function(String name, int x, int y, int z, boolean isTrue, ...){
    //do stuff
}
```
as you can see, information is being passed with alot of parameters, and some people like this due to readability.


**minimal objects**
```java
public static void function(String name, WindowParameters params){
    //deconstruct object
    //do stuff
}
```
in this instance, the information is being passed via another object.  this is a less popular way, to transfer data, however you will see this frequently in api-bound libraries(see. *Anarchy*).

basically its gonna have both of them, pick and choose.

## license
*tldr, just give credit, you are free to redistribute, copy, modify, and use for commercial purposes.*

### the real license, for you legal nerds
[![creative commons license](https://i.creativecommons.org/l/by/4.0/88x31.png)](http://creativecommons.org/licenses/by/4.0/)  
this work is licensed under a [creative commons attribution 4.0 international license](http://creativecommons.org/licenses/by/4.0/).

## credits
**font:** https://fontesk.com/basically-a-sans-serif-font/