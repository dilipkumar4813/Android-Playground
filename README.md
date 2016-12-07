# Android-Playground
Just a playground for testing android coding

#Animations in Android
1. ObjectAnimator
2. Interpolator
3. Evaluators

##ObjectAnimator
The object animator is the easiest and simplest animations that can be implemented in android using the ObjectAnimator Class
ObjectAnimator object = ObjectAnimator.ofFloat(widget,property,value); //Can use the function ofInt as well

The various properties are as follows

1. rotation
2. rotationX
3. rotationY
4. scaleX
5. scaleY

Example code
```java

ObjectAnimator rotation = ObjectAnimator.ofFloat(ivTest,"rotation",360);
rotation.setDuration(2000);
rotation.start();

```

##Interpolator
Interpolators are used for creating animations on android widgets. The following interpolators are supported in android : 

1. bounce_interpolator
2. accelerate_interpolator
3. decelerate_interpolator
4. cycle_interpolator
5. anticipate_interpolator
6. overshoot_interpolator
7. accelerate_decelerate_interpolator
8. linear_interpolator
9. anticipate_overshoot_interpolator

Once the above interpolators are set in the anim xml files. The we have to do the following in code
Create an animation class
Animation animation = AnimationUtils.loadAnimation(this,R.anim.yourxmlfilename);

Start the animation using the widget as follows
widget.startAnimation(animation);

xml file example
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/bounce_interpolator">
    <translate
        android:fromYDelta="-100%p"
        android:toYDelta="0"
        android:duration="2000"
        />
</set>
```

##Evaluators
Animating colors and rectangles can be achieved using ArgbEvalutor and RectEvalutor. The implementation is done using the ObjectAnimator and using the method ofObject present within the ObjectAnimator class.

Example
```java
ObjectAnimator argbEvaluator = ObjectAnimator.ofObject(ivArgbEvaluators, "backgroundColor", new ArgbEvaluator(), Color.CYAN, Color.MAGENTA);
argbEvaluator.setDuration(5000);
argbEvaluator.start();
```

#Intent
Share, view links, call, send messages and do other exiting things using intents a few examples as given below

Code to view web link
```java
Intent viewLinkIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
startActivity(viewLinkIntent);
```

Code to share
```java
Intent shareIntent = new Intent(Intent.ACTION_SEND);
shareIntent.setType("text/plain");
shareIntent.putExtra(Intent.EXTRA_TEXT,"Something you want to share");
startActivity(Intent.createChooser(shareIntent,"Share using"));
```

#Threads
**Asynchronous - Message Queue (Will complete one item after another)**

1. Activity
2. Service
3. Broadcast Receiever

**Synchronous - Runs on the main thread**

1. Content Provider

Anything that is going to perform a long operation will block the main thread and cause the application to crash, use additional threads for tasks longer than 5 seconds. For very long time consumption operation use services

**Android Threading Architecture**

Process has the following

1. Internal Components
	* Activities
	* Services
	* Content Provider
	* Broadcast receiever
2. Contains the main thread which is run by the looper
3. Thread pool
4. External Componenets

Methods

1. runOnUiThread(Runnable runnable) - use to update the UI
2. post(Runnable runnable) - Add to message queue
3. postDelayed(Runnable runnable,long miliseconds) - Execute after a time provided
4. setThreadPriority(int priority) -> -20 highest and 19 lowest priority

Example
```java
new Thread(new Runnable(){
	public void run(){
		downloadSomething();
	}
});
```

The progress dialog runs as a thread and the value of the progress dialog can be set from a thread using the following code

```java
progressdialogwidget.post(priority);
```


#Collections
Collection is the root interface from which the classes are dervices

There main classes derived from the root collection class are List, Sets and Queue

###Lists
1. ArrayList
2. LinkedList
3. Vector -> Stack

###Sets
1. HashSet -> LinkedHashSet
2. SortedSet -> NavigableSet -> TreeSet

###Queue
1. PriorityQueue
2. BlockingQueue
	* LinkedBlockingQueue
	* PriorityBlockingQueue
	
##Maps
1. HashMap -> LinkedHashMap
2. WeakHashMap
3. SortedMap -> NavigableMap -> TreeMap
4. IdentityHashMap
5. HashTable -> Properties
