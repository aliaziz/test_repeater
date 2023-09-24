# The Repetable Annotation
A test rule and annotation to repeat a specific test case. It's useful when trying to identify flaky tests.

## Use case
Writing test cases that verify the execution of concurrent code can get painful sometimes. Passing `90%` of the time and failing `10%`, especially during pipeline builds. 
We need a way to at least capture the failing 10% locally.
That's where the `@Repeatable` annotation and `@RepeatableRule` can come into place

We can now add the ```@RepeatableRule ``` to our test class

```Kotlin 
 @get:Rule
val repeatRule = RepeatableRule()
```

And then add the `@Repeatable(repeatCount=...)` annotation to the test method we've identified as flaky

```Kotlin
@Test
@Repeatable(repeatCount = REPEAT_COUNT) //Add the annotation on the test method to repeat
fun `test clickFabCount increments on click`() {
...
}
```

Now, we can `tweak` our repeatCount to whatever number of times we want to try repeating the test and capture when it fails.

