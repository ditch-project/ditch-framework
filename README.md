# ditch-framework
a simple java gui wrapper, element oriented, targeted to beginners who wants to see a window, not a command prompt.

## concept
when i was in the shower earlier, i thought to myself,

"*why the hell* are java gui libraries confusing?"

i've been getting into c#, and stumbled upon **osu-framework** which is some sort of holy creation that osu devs use for their own game, *osu*.  so now, ive been thinking to myself, why doesn't java have libraries like these(~~exclude the fact that this is an old, slower, backend language~~)?  thus born, **ditch-framework**, a simple gui library targetted to beginner java programmers, who don't want to see that command prompt thingy, but also don't want to learn how to (*gasp*) do javafx or some funky stuff like that.

## paradigm
this project will be using the `minimal objects` approach to passing data through methods.  an example will be shown below.

**minimal objects**
```java
public static void function(String name, WindowParameters params){
    //deconstruct object
    //do stuff
}
```
in this instance, the information is being passed via another object.  this is a less popular way, to transfer data, however you will see this frequently in api-bound libraries(see. *Anarchy*).

## license
*tldr, just give credit, you are free to redistribute, copy, modify, and use for commercial purposes.*

### the real license, for you legal nerds
[![creative commons license](https://i.creativecommons.org/l/by/4.0/88x31.png)](http://creativecommons.org/licenses/by/4.0/)  
this work is licensed under a [creative commons attribution 4.0 international license](http://creativecommons.org/licenses/by/4.0/).

## credits
**font:** https://fontesk.com/basically-a-sans-serif-font/