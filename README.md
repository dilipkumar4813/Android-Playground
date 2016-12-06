# Android-Playground
Just a playground for testing android coding

#Animations in Android
1. ObjectAnimator
2. Interpolator
3. Evaluators

##ObjectAnimator
The object animator is the easiest and simplest animations that can be implemented in android using the ObjectAnimator Class
ObjectAnimator object = ObjectAnimator.ofFloat(widget,property,value); //Can use the function ofInt as well

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

##Collections
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
