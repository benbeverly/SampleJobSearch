# Sample Job Search

## Purpose
This is a quick app written up as a simple coding exercise to show off job interview requirements.
Rapidly demonstrate my ability to hook up to an API and show some libraries I am familiar with using.

I also took this as another outlet to continue learning Kotlin as it is a new language to me at the time of wroting this.

Was also a great opportunity to introduce myself into RxJava which I wish I had learned earlier.

## Things to note:

I took some shortcuts in writing this that I wouldn't normally do in a larger application.
* Dependency Injection: I took a quick shortcut and just create my Retrofit service inside my main Fragment.
In a larger application, I'd initialize and setup my Dependency Manager within my Application class and then Dependency Inject that to my classes using [Dagger2](https://google.github.io/dagger/)
* Project Structure with so few files, I didn't want to make an assortment of packages with just one file in each. So I just left everything on the top level and it helps to navigate through to look at the source

## Future features
I added a search button in the main menu, I'd like to revisit the sample someday and actually implement.
But I couldn't finish that in the first weekend I was throwing this app together.

I wanted to create a fluid scroll with pulling in subsequent pages. But with trying to push this up in just a day, I opted to push that as a later goal.